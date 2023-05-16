package com.example.Mapping_API.service;

import com.example.Mapping_API.model.Laptop;
import com.example.Mapping_API.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {
    private final LaptopRepository laptopRepository;

    @Autowired
    public LaptopService(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    public Laptop createLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    public Laptop getLaptopById(Long id) {
        return laptopRepository.findById(id).orElse(null);
    }

    public Laptop updateLaptop(Long id, Laptop updatedLaptop) {
        Laptop existingLaptop = laptopRepository.findById(id).orElse(null);
        if (existingLaptop != null) {
            existingLaptop.setName(updatedLaptop.getName());
            existingLaptop.setBrand(updatedLaptop.getBrand());
            existingLaptop.setPrice(updatedLaptop.getPrice());
            existingLaptop.setStudent(updatedLaptop.getStudent());
            return laptopRepository.save(existingLaptop);
        } else {
            return null;
        }
    }

    public boolean deleteLaptop(Long id) {
        Laptop laptop = laptopRepository.findById(id).orElse(null);
        if (laptop != null) {
            laptopRepository.delete(laptop);
            return true;
        } else {
            return false;
        }
    }
}
