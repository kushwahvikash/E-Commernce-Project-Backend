package com.vikas.fai.service;

import org.springframework.web.multipart.MultipartFile;

import com.vikas.fai.model.User;

public interface UserServices {

	public void createUser(MultipartFile file, Long uId, String uName, String email, String mobile, String type,
			String address);

	public User getUserById(Long id);

	public void updateUser(Long id, MultipartFile file, String uName, String email, String mobile, String type,
			String address);

	public void deleteUser(Long id);

}
