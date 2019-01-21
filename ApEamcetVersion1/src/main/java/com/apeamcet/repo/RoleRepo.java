package com.apeamcet.repo;

import org.springframework.data.jpa.repository.JpaRepository;	

import com.apeamcet.domain.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {
	/*
	 * The below method is used to retrieve Role-id based on the id present in UserTable.
	 */
	public Role findByRoleid(int id);
}
