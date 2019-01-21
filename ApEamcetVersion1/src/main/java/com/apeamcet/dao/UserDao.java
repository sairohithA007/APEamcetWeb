package com.apeamcet.dao;

import java.util.List;	

import com.apeamcet.domain.User;

public interface UserDao {
	public void add(User user);
	public User findByName(String username);
	public List<User> getAll();
	public void delete(Integer id);
	public User get(Integer id);
	public void edit(User user);
	public int getByUsername(String username);
}
