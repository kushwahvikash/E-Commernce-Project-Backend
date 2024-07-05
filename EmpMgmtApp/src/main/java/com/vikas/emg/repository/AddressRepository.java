package com.vikas.emg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vikas.emg.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
