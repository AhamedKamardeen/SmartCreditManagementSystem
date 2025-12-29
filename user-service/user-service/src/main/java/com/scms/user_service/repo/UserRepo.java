package com.scms.user_service.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scms.user_service.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	
	
	    Optional<User> findByUsername(String username);

}
