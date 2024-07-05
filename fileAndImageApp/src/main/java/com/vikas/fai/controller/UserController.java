package com.vikas.fai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vikas.fai.model.User;
import com.vikas.fai.service.UserServices;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	    @Autowired
	    private UserServices userService;

	    // Create user
	    @PostMapping("/create")
	    public ResponseEntity<String> createUser(@RequestParam MultipartFile file,
	                                             @RequestParam Long uId,
	                                             @RequestParam String uName,
	                                             @RequestParam String email,
	                                             @RequestParam String mobile,
	                                             @RequestParam String type,
	                                             @RequestParam String address) {
	        try {
	            userService.createUser(file, uId, uName, email, mobile, type, address);
	            return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create user: " + e.getMessage());
	        }
	    }

	    // Get user by ID
	    @GetMapping("/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable Long id) {
	        User user = userService.getUserById(id);
	        if (user != null) {
	            return ResponseEntity.ok().body(user);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Update user
	    @PutMapping("/{id}")
	    public ResponseEntity<String> updateUser(@PathVariable Long id,
	                                             @RequestParam MultipartFile file,
	                                             @RequestParam String uName,
	                                             @RequestParam String email,
	                                             @RequestParam String mobile,
	                                             @RequestParam String type,
	                                             @RequestParam String address) {
	        try {
	            userService.updateUser(id, file, uName, email, mobile, type, address);
	            return ResponseEntity.ok().body("User updated successfully");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update user: " + e.getMessage());
	        }
	    }

	    // Delete user
	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
	        try {
	            userService.deleteUser(id);
	            return ResponseEntity.ok().body("User deleted successfully");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete user: " + e.getMessage());
	        }
	    }
	}



