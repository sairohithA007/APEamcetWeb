package com.apeamcet.dao;

import java.util.List;	

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apeamcet.domain.User;
import com.apeamcet.repo.UserRepo;
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	UserRepo userRepo;
	/*
	 * (non-Javadoc)
	 * @see com.apeamcet.dao.UserDao#add(com.apeamcet.domain.User)
	 * This method is used to save a record to User Table.
	 */
	public void add(User user) {
		userRepo.save(user);
	}
	
	public User findByName(String username) {
		return userRepo.findByUsername(username);
	}
	/*
	 * (non-Javadoc)
	 * @see com.apeamcet.dao.UserDao#getAll()
	 * This method is used to get the complete list of users present in User Table. 
	 */
	public List<User> getAll() {
		return userRepo.findAll();
	}
	/*
	 * (non-Javadoc)
	 * @see com.apeamcet.dao.UserDao#delete(java.lang.Integer)
	 * This method is used to delete the user record from User Table based on id.
	 */
	public void delete(Integer id) {
		userRepo.delete(id);
	}
	/*
	 * (non-Javadoc)
	 * @see com.apeamcet.dao.UserDao#get(java.lang.Integer)
	 * This method is used to get the user record from User Table based on id.
	 */
	public User get(Integer id) {
		User user= new User();
		user =userRepo.findOne(id);
		return user;
	}
	/*
	 * (non-Javadoc)
	 * @see com.apeamcet.dao.UserDao#edit(com.apeamcet.domain.User)
	 * This method is used to update the data of user in User Table.
	 */
	public void edit(User user) {
		userRepo.saveAndFlush(user);
	}

	public int getByUsername(String username) {
		User user = new User();
		user=userRepo.findByUsername(username);
		int check=user.getId();
		return check;
	}

}
