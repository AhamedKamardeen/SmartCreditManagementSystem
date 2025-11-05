package com.scms.user_service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scms.user_service.entity.User;
import com.scms.user_service.repo.UserRepo;
import com.scms.user_service.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	 @Autowired
	    public UserRepo userRepository;

	    @Override
	    public User saveUser(User user) {
	        return userRepository.save(user);
	    }

	    @Override
	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }

	    @Override
	    public User getUserById(Long id) {
	        return userRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("User not found with ID " + id));
	    }

	    @Override
	    public User updateUser(Long id, User updatedUser) {
	        User user = getUserById(id);
	        user.setName(updatedUser.getName());
	        user.setNrcNumber(updatedUser.getNrcNumber());
	        user.setEmailId(updatedUser.getEmailId());
	        user.setAddress(updatedUser.getAddress());
	        return userRepository.save(user);
	    }

	    @Override
	    public void deleteUser(Long id) {
	        userRepository.deleteById(id);
	    }
}
