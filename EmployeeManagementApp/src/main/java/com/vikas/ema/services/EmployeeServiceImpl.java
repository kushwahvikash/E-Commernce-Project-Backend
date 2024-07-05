package com.vikas.ema.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikas.ema.model.Employee;
import com.vikas.ema.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
    private  EmployeeRepository employeeRepository;

    

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get employee by ID
    public Employee getEmployeeById(String id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeOptional.orElse(null);
    }

    // Create a new employee
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Update an existing employee
    public Employee updateEmployee(String id, Employee employeeDetails) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setEname(employeeDetails.getEname());
            employee.setAddress(employeeDetails.getAddress());
            employee.setSalary(employeeDetails.getSalary());
            return employeeRepository.save(employee);
        } else {
            return null; // Handle this case as needed
        }
    }

    // Delete an employee
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }
}
