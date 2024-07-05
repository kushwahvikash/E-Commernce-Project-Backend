package com.vikas.erd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vikas.erd.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e JOIN FETCH e.address WHERE e.id = :id")
    Employee findEmployeeWithAddressById(@Param("id") Long id);
}
