package com.hroa.service;

import java.util.List;

import com.hroa.model.AdminModel;
import com.hroa.model.DeptModel;
import com.hroa.model.RoleModel;

public interface RbacService {
/*---------------------------------------------------用户模块----------------------------------------*/
	/*添加系统用户*/
	public int addUser(AdminModel user);
	/*检测账号是否存在*/
	public int checkAccount(String account);
	/*获取管理员的总数量*/
	public int getAdminAmount();
	/*根据用户ID获取用户信息*/
	public AdminModel getUserInfoById(int userId);
	/*分页获取管理员的信息*/
	public List<AdminModel> getAllAdmin(int startPage,int pageSize);
	
/*---------------------------------------------------角色模块------------------------------------------*/
	/*添加角色*/
	public int addRole(RoleModel roleModel);
	/*根据ID获取角色信息*/
    public RoleModel gtRoleInfo(int roleId);
    /*分页获取所有的角色信息*/
    public List<RoleModel> getAllRole(int startPage,int pageSize);
    /*获取所有角色集合*/
    public List<RoleModel> getRoleList();
    /*根据角色名字判断角色是否存在*/
	public int checkRoleHasByNa(String roleName);
	/*获取角色的总数量*/
	public int getRoleAmount();
	/*角色授权*/
	public int assignPrev(int roleId,String role_powers);
	/*根据角色ID获取角色信息*/
	public String getPrevById(int roleId);
    
    
/*---------------------------------------------------部门模块---------------------------------------*/
    /*添加部门*/
    public int addDept(String deptName);
    /*获取部门的总数量*/
	public int getDeptAmount();
	/*根据ID获取部门的信息*/
	public DeptModel getDeptInfoById(int dpId);
	/*分页获取部门的信息*/
	public List<DeptModel> getAllDept(int startPage,int pageSize);
	/*获取部门集合*/
	public List<DeptModel> getDeptList();
	/*修改部门信息*/
	public int alertDept(DeptModel deptInfoModel);
}
