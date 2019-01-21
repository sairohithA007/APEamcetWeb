package com.apeamcet.service;

import java.util.List;		

import com.apeamcet.model.UserModel;

public interface UserService {
	public void add(UserModel userPojo);

	public List<UserModel> getAll();

	public void delete(Integer id);

	public UserModel get(Integer id);

	public void edit(UserModel userPojo);

	//public int getByUsername(String username);
}
