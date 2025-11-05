package com.scms.user_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.scms.user_service.entity.User;

@Service
public interface UserService {
	
	 User saveUser(User user);
	    List<User> getAllUsers();
	    User getUserById(Long id);
	    User updateUser(Long id, User user);
	    void deleteUser(Long id);

}
