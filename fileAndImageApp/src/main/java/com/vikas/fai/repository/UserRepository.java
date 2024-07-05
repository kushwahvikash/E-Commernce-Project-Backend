package com.vikas.fai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vikas.fai.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
