package com.vikas.ema.repository;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vikas.ema.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
