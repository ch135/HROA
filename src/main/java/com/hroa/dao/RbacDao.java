package com.hroa.dao;

import java.util.List;

import com.hroa.model.AdminModel;
import com.hroa.model.DeptModel;
import com.hroa.model.RoleModel;

public interface RbacDao {
/*----------------------------------------用户模块---------------------------------------------------*/	
	/*添加用户*/
	int addUser(AdminModel user);
	/*检测账号是否存在*/
	int checkAccIsOn(String account);
	/*获取管理员的总数量*/
	int getAdminAmount();
	/*根据用户ID获取用户信息*/
	AdminModel getUserInfoById(int userId);
	/*分页获取管理员的信息*/
	List<AdminModel> getAllAdmin(int startPage, int pageSize);
	
	
/*----------------------------------------角色模块---------------------------------------------------*/
	/*添加角色*/
	int addRole(RoleModel roleModel);
	/*根据角色ID获取角色信息*/
	RoleModel gtRoleInfo(int roleId);
	/*分页获取所有的角色*/
	List<RoleModel> getAllRole(int startPage, int pageSize);
	/*获取所有角色集合*/
	List<RoleModel> getRoleList();
	/*根据角色名字判断角色是否存在*/
	int checkRoleHasByNa(String roleName);
	/*获取角色的总数量*/
	int getRoleAmount();
	/*角色授权*/
	int assignPrev(RoleModel roleModel);
	/*根据角色ID获取角色信息*/
	String getPrevById(int roleId);
	
/*----------------------------------------部门模块---------------------------------------------------*/
	/*添加部门*/
	int addDept(String deptName);
	/*获取部门的总数量*/
	int getDeptAmount();
	/*根据部门ID获取部门信息*/
	DeptModel getDeptInfoById(int dpId);
	/*分页获取部门的信息*/
	List<DeptModel> getAllDept(int startPage, int pageSize);
	/*获取所有的部门集合*/
	List<DeptModel> getDeptList();
	/*修改部门信息*/
	int alertDept(DeptModel deptInfoModel);
}
