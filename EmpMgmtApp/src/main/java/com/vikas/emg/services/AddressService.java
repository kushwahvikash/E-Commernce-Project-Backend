package com.vikas.emg.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikas.emg.model.Address;
import com.vikas.emg.repository.AddressRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(id);
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
