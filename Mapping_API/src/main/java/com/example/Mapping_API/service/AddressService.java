package com.example.Mapping_API.service;

import com.example.Mapping_API.model.Address;
import com.example.Mapping_API.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    public Address updateAddress(Long id, Address updatedAddress) {
        Address existingAddress = addressRepository.findById(id).orElse(null);
        if (existingAddress != null) {
            existingAddress.setLandmark(updatedAddress.getLandmark());
            existingAddress.setZipcode(updatedAddress.getZipcode());
            existingAddress.setDistrict(updatedAddress.getDistrict());
            existingAddress.setState(updatedAddress.getState());
            existingAddress.setCountry(updatedAddress.getCountry());
            return addressRepository.save(existingAddress);
        } else {
            return null;
        }
    }

    public boolean deleteAddress(Long id) {
        Address address = addressRepository.findById(id).orElse(null);
        if (address != null) {
            addressRepository.delete(address);
            return true;
        } else {
            return false;
        }
    }
}
