package com.vikas.erd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikas.erd.model.Employee;
import com.vikas.erd.services.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
    private EmployeeService employeeService;

    
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeWithAddress(@PathVariable Long id) {
        Employee employee = employeeService.findEmployeeWithAddressById(id);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
