package com.scms.user_service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scms.user_service.entity.User;
import com.scms.user_service.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	private static final Logger log =
            LoggerFactory.getLogger(UserService.class);
		
		
		@GetMapping("/trial")
		public String trial() {
			log.info("User service ELK logging step 4 working");
			return "trial Works.....................";
		}

	    @PostMapping("/save-user")
	    public User saveUser(@RequestBody User user) {
	        return userService.saveUser(user);
	    }

	    @GetMapping("/get-all-user")
	    public List<User> getAllUsers() {
	        return userService.getAllUsers();
	    }

	    @GetMapping("/get-user-by-id/{id}")
	    public User getUserById(@PathVariable ("id") Long id) {
	        return userService.getUserById(id);
	    }

	    @PutMapping("/update-user/{id}")
	    public User updateUser(@PathVariable Long id, @RequestBody User user) {
	        return userService.updateUser(id, user);
	    }

	    @DeleteMapping("/delete-user/{id}")
	    public String deleteUser(@PathVariable Long id) {
	        userService.deleteUser(id);
	        return "User deleted successfully!";
	    }

}
