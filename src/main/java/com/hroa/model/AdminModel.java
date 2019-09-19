package com.hroa.model;

import java.util.List;

public class AdminModel {
	private int id;
	private String account;
	private String realname;
	private String password;
	private String nickname;
	private String login_time;//登录时间
    private int deptid;//所属部门
	private int status;//用户状态
	private int role_id;//角色ID
	private List<RoleModel> roleInfoList; 
	private DeptModel deptInfo;//部门
	private String task_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getLogin_time() {
		return login_time;
	}
	public void setLogin_time(String login_time) {
		this.login_time = login_time;
	}
    public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
    public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public List<RoleModel> getRoleInfoList() {
		return roleInfoList;
	}
	public void setRoleInfoList(List<RoleModel> roleInfoList) {
		this.roleInfoList = roleInfoList;
	}
	public DeptModel getDeptInfo() {
		return deptInfo;
	}
	public void setDeptInfo(DeptModel deptInfo) {
		this.deptInfo = deptInfo;
	}
	public String getTask_id() {
		return task_id;
	}
	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}
}
