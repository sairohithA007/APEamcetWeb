package com.apeamcet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
/*
 * Entity class which is used to update the database table(Role).
 */
@Entity
public class Role {
	@Id
	int roleid;
	@Column
	String rolename;
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getRollname() {
		return rolename;
	}
	public void setRollname(String rolename) {
		this.rolename = rolename;
	}
	public Role(int roleid, String rolename) {
		super();
		this.roleid = roleid;
		this.rolename = rolename;
	}
	public Role() {
		super();
	}
	
}
