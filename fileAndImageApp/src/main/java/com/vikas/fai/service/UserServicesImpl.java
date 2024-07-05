package com.vikas.fai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vikas.fai.model.User;
import com.vikas.fai.repository.UserRepository;
@Service
public class UserServicesImpl implements UserServices{
	@Autowired
    private UserRepository userRepository;

    public void createUser(MultipartFile file, Long uId, String uName, String email, String mobile, String type, String address) {
        User user = new User();
        user.setUId(uId);
        user.setUName(uName);
        user.setEmail(email);
        user.setMobile(mobile);
        user.setType(type);
        user.setAddress(address);
        try {
            user.setFile(file.getBytes());
        } catch (Exception e) {
            throw new RuntimeException("Failed to upload file: " + e.getMessage());
        }
        userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void updateUser(Long id, MultipartFile file, String uName, String email, String mobile, String type, String address) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        existingUser.setUName(uName);
        existingUser.setEmail(email);
        existingUser.setMobile(mobile);
        existingUser.setType(type);
        existingUser.setAddress(address);
        try {
            existingUser.setFile(file.getBytes());
        } catch (Exception e) {
            throw new RuntimeException("Failed to upload file: " + e.getMessage());
        }
        userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
