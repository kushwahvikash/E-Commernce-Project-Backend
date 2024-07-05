package com.vikas.ema.model;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@GenericGenerator(name = "employee_id_generator", strategy = "com.vikas.ema.gen.CustomEmployeeIdGenerator")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "employee_id_generator")
    private String eid;
    private String ename;
    private String address;
    private String salary;

    
}
