package com.example.Mapping_API.controller;

import com.example.Mapping_API.model.Laptop;
import com.example.Mapping_API.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/laptops")
public class LaptopController {
    private final LaptopService laptopService;

    @Autowired
    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @PostMapping
    public ResponseEntity<Laptop> createLaptop(@RequestBody Laptop laptop) {
        Laptop createdLaptop = laptopService.createLaptop(laptop);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLaptop);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laptop> getLaptopById(@PathVariable Long id) {
        Laptop laptop = laptopService.getLaptopById(id);
        if (laptop != null) {
            return ResponseEntity.ok(laptop);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Laptop> updateLaptop(@PathVariable Long id, @RequestBody Laptop laptop) {
        Laptop updatedLaptop = laptopService.updateLaptop(id, laptop);
        if (updatedLaptop != null) {
            return ResponseEntity.ok(updatedLaptop);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLaptop(@PathVariable Long id) {
        boolean deleted = laptopService.deleteLaptop(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
