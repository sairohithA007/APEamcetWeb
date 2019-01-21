package com.apeamcet.service;

import java.util.ArrayList;		
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.apeamcet.dao.RoleDao;
import com.apeamcet.dao.UserDao;
import com.apeamcet.domain.Role;
import com.apeamcet.domain.User;
import com.apeamcet.model.UserModel;
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
	
	UserDao userDao;
	RoleDao roleDao;
	@Inject
	public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
		this.userDao=userDao;
		this.roleDao=roleDao;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.apeamcet.service.UserService#add(com.apeamcet.model.UserModel)
	 * This method is used to add the admin/normal user.
	 */
	
	@Transactional
	public void add(UserModel userPojo) {
		User user= new User();
		
		user.setUsername(userPojo.getUsername());
		user.setPassword(userPojo.getPassword());
		user.setContact(userPojo.getContact());
		user.setEmail(userPojo.getEmail());
		
		int roleid=userPojo.getRole();
		Role role= new Role();
		role=roleDao.getUserRole(roleid);
		user.setRole(role);
		userDao.add(user);
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 * This method is implemented for login using spring security.
	 */

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		try {
			User xuser= new User();
			xuser=userDao.findByName(username);
			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
				authorities.add(new SimpleGrantedAuthority(xuser.getRole().getRollname()));
			return new org.springframework.security.core.userdetails.User(xuser.getUsername(),xuser.getPassword(),enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,authorities);
			}
			catch(Exception e){
				throw new RuntimeException(e);
			}

	}

	/*
	 * (non-Javadoc)
	 * @see com.apeamcet.service.UserService#getAll()
	 * This method is used to get the list of all users.
	 */
	@Transactional
	public List<UserModel> getAll() {
		List<User> userList= new ArrayList<User>();
		
		List<UserModel> userPojoList= new ArrayList<UserModel>();
		userList= userDao.getAll();
		for(User user:userList){
			UserModel userPojo= new UserModel();
			userPojo.setContact(user.getContact());
			userPojo.setEmail(user.getEmail());
			userPojo.setId(user.getId());
			userPojo.setUsername(user.getUsername());
			String rolename=user.getRole().getRollname();
			userPojo.setRolename(rolename);
			userPojoList.add(userPojo);
		}
		return userPojoList;
	}

	/*
	 * (non-Javadoc)
	 * @see com.apeamcet.service.UserService#delete(java.lang.Integer)
	 * This method is used to delete the user based on his id.
	 */
	@Transactional
	public void delete(Integer id) {
		User user = new User();
		user.setId(id);
		userDao.delete(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.apeamcet.service.UserService#get(java.lang.Integer)
	 * This method is used to get the record of user based on id.
	 */
	@Transactional
	public UserModel get(Integer id) {
		User user = new User();
		user=userDao.get(id);
		UserModel userPojo= new UserModel();
		userPojo.setContact(user.getContact());
		userPojo.setEmail(user.getEmail());
		userPojo.setId(user.getId());
		userPojo.setUsername(user.getUsername());
		 
		String rolename=user.getRole().getRollname();
		int roleid= user.getRole().getRoleid();
		userPojo.setRolename(rolename);
		userPojo.setRole(roleid);
		return userPojo;
		
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.apeamcet.service.UserService#edit(com.apeamcet.model.UserModel)
	 * This method is used to update the data of the user.
	 */
	@Transactional
	public void edit(UserModel userPojo) {
		User user= new User();
		
		user.setUsername(userPojo.getUsername());
		user.setPassword(userPojo.getPassword());
		user.setContact(userPojo.getContact());
		user.setEmail(userPojo.getEmail());
		user.setId(userPojo.getId());
		int roleid=userPojo.getRole();
		Role role= new Role();
		role=roleDao.getUserRole(roleid);
		user.setRole(role);
		userDao.edit(user);
	}


/*
	public int getByUsername(String username) {
		int check=userDao.getByUsername(username);
		if(check==0)
			return 0;
		else
			return 1;
	}
	*/
	

}
