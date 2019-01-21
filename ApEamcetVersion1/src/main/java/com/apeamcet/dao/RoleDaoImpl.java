package com.apeamcet.dao;

import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.stereotype.Repository;

import com.apeamcet.domain.Role;
import com.apeamcet.repo.RoleRepo;
@Repository
public class RoleDaoImpl implements RoleDao {
@Autowired
RoleRepo roleRepo;
	/*
	 * (non-Javadoc)
	 * @see com.apeamcet.dao.RoleDao#getUserRole(int)
	 * This method is used to get the Role-id, from table Role, based on id.
	 */
	public Role getUserRole(int id) {
		return roleRepo.findByRoleid(id);
	}

}
