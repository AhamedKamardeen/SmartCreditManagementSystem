package com.scms.user_service.config;
import com.scms.user_service.entity.User;
import com.scms.user_service.repo.UserRepo;

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

                User user = new User();
                user.setUsername("admin");
                user.setPassword(passwordEncoder.encode("admin123"));
                user.setRole("USER");
                System.err.println("User Saved................");
                userRepository.save(user);
            }
        };
    }
}

