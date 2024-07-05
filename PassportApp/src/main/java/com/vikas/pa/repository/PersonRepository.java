package com.vikas.pa.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vikas.pa.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
