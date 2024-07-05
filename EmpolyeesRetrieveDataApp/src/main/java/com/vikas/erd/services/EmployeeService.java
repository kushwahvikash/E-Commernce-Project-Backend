package com.vikas.erd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikas.erd.model.Employee;
import com.vikas.erd.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
    private EmployeeRepository employeeRepository;


    public Employee findEmployeeWithAddressById(Long id) {
        return employeeRepository.findEmployeeWithAddressById(id);
    }
}
