package com.hroa.model;
public class RoleModel {
	private int id;
	private String role_name;//角色名称
	private String role_describes;//角色描述
	private String role_powers;//角色对应的权限集合
	private String dpname;
	private int deptid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_describes() {
		return role_describes;
	}
	public void setRole_describes(String role_describes) {
		this.role_describes = role_describes;
	}
	public String getRole_powers() {
		return role_powers;
	}
	public void setRole_powers(String role_powers) {
		this.role_powers = role_powers;
	}
	public String getDpname() {
		return dpname;
	}
	public void setDpname(String dpname) {
		this.dpname = dpname;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
}
