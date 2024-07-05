package com.vikas.pa.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vikas.pa.model.Passport;

public interface PassportRepository extends JpaRepository<Passport, Long> {

	Passport findByPersonPersonId(Long personId);
}
