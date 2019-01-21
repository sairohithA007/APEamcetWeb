package com.apeamcet.model;


public class RoleModel {
	int roleid;
	String rollname;
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getRollname() {
		return rollname;
	}
	public void setRollname(String rollname) {
		this.rollname = rollname;
	}
	public RoleModel(int roleid, String rollname) {
		super();
		this.roleid = roleid;
		this.rollname = rollname;
	}
	public RoleModel() {
		super();
	}
	
	
}
