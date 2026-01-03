package com.scms.user_service.config;
import com.scms.user_service.entity.User;
import com.scms.user_service.repo.UserRepo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initUsers(UserRepo userRepository,
                                PasswordEncoder passwordEncoder) {

        return args -> {

            if (userRepository.count() == 0) {
            	
            	List<User> users = new ArrayList<>();

            	User admin = new User();
            	admin.setUsername("admin");
            	admin.setPassword(passwordEncoder.encode("admin123"));
            	admin.setRole("ADMIN");

            	users.add(admin);
            	System.err.println("Admin Added................");
            	for (int i = 1; i <= 14; i++) {
            	    User user = new User();
            	    user.setUsername("user" + i);
            	    user.setPassword(passwordEncoder.encode("user" + i));
            	    user.setRole("USER");

            	    users.add(user);
            	    System.err.println("User"+i+" Added................");
            	}

//                User user = new User();
//                user.setUsername("admin");
//                user.setPassword(passwordEncoder.encode("admin123"));
//                user.setRole("USER");
                System.err.println("All User Saved................");
                userRepository.saveAll(users);
            }
        };
    }
}

