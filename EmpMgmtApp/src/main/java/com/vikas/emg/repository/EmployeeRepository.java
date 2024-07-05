package com.vikas.emg.repository;
// EmployeeRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vikas.emg.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

