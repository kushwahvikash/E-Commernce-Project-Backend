package com.vikas.ema.services;

import java.util.List;

import com.vikas.ema.model.Employee;

public interface EmployeeService {
	 public List<Employee> getAllEmployees();
	 public Employee getEmployeeById(String id);
	 public Employee createEmployee(Employee employee);
	 public Employee updateEmployee(String id, Employee employeeDetails);
	 public void deleteEmployee(String id);
}
