package com.apeamcet.repo;

import org.springframework.data.jpa.repository.JpaRepository;	

import com.apeamcet.domain.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	/*
	 * The below method is used to get the user name and it is invoked by Spring Security.
	 */
	User findByUsername(String username);
	//int findByUsername1(String username);
	
}
