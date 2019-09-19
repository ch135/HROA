package com.hroa.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hroa.dao.RbacDao;
import com.hroa.model.AdminModel;
import com.hroa.model.DeptModel;
import com.hroa.model.RoleModel;
import com.hroa.service.RbacService;
@Service("rbacSerivce")
public class RbacServiceImpl implements RbacService {
	@Resource
	RbacDao rbacDao;
	/**
	 * author qwc
	 * 2017年6月13日下午6:39:13
	 * @param user
	 * @return
	 * 添加系统用户
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.RbacService#addUser(com.hroa.model.AdminModel)
	 */
	@Override
	public int addUser(AdminModel user) {
		// TODO Auto-generated method stub
		int addStatus=0;
		addStatus=rbacDao.addUser(user);
		return addStatus;
	}
	
	/**
	 * author qwc
	 * 2017年6月13日下午8:39:59
	 * @param account
	 * @return
	 * 检测账号是否存在
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.RbacService#checkAccount(java.lang.String)
	 */
	@Override
	public int checkAccount(String account) {
		// TODO Auto-generated method stub
		int checkStatus=0;
		checkStatus=rbacDao.checkAccIsOn(account);
		return checkStatus;
	}
	
	/**
	 * author qwc
	 * 2017年6月16日下午9:12:31
	 * @return
	 * 获取管理员的总数量
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.RbacService#getAdminAmount()
	 */
	@Override
	public int getAdminAmount() {
		// TODO Auto-generated method stub
		int totalAmount=0;
		totalAmount=rbacDao.getAdminAmount();
		return totalAmount;
	}
	
	/**
	 * author qwc
	 * 2017年6月18日下午8:38:39
	 * @param userId
	 * @return
	 * 根据ID获取用户信息
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.RbacService#getUserInfoById(int)
	 */
	@Override
	public AdminModel getUserInfoById(int userId) {
		// TODO Auto-generated method stub
		AdminModel userInfoModel=rbacDao.getUserInfoById(userId);
		return userInfoModel;
	}
	
	/**
	 * author qwc
	 * 2017年6月16日下午8:56:00
	 * @param startPage
	 * @param pageSize
	 * @return
	 * 分页获取管理员信息
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.RbacService#getAllAdmin(int, int)
	 */
	@Override
	public List<AdminModel> getAllAdmin(int startPage, int pageSize) {
		// TODO Auto-generated method stub
		List<AdminModel> list = new ArrayList<AdminModel>();
		list=rbacDao.getAllAdmin(startPage, pageSize);
		return list;
	}
	
/*------------------------------------------角色操作模块-------------------------------------------*/
	/**
	 * author qwc
	 * 2017年6月22日下午7:54:06
	 * @param roleModel
	 * @return
	 * 添加角色
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.RbacService#addRole(com.hroa.model.RoleModel)
	 */
	@Override
	public int addRole(RoleModel roleModel) {
		// TODO Auto-generated method stub
		int addStatus=rbacDao.addRole(roleModel);
		return addStatus;//返回添加状态
	}
	
	/**
	 * author qwc
	 * 2017年6月15日下午5:37:32
	 * @return
	 * 获取角色信息
	 */
	@Override
	public RoleModel gtRoleInfo(int roleId) {
		// TODO Auto-generated method stub
		/*List<RoleModel> roleList=rbacDao.gtRoleInfo(roleId);*/
		return rbacDao.gtRoleInfo(roleId);
	}
    
	/**
	 * author qwc
	 * 2017年6月16日下午8:26:39
	 * @return
	 * 分页获取所有的角色信息
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.RbacService#getAllRole()
	 */
	@Override
	public List<RoleModel> getAllRole(int startPage, int pageSize) {
		// TODO Auto-generated method stub
		List<RoleModel> list = new ArrayList<RoleModel>();
		list=rbacDao.getAllRole(startPage,pageSize);
		return list;
	}
	
	/**
	 * author qwc
	 * 2017年6月23日下午8:09:34
	 * @return
	 * 获取角色列表
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.RbacService#getRoleList()
	 */
	@Override
	public List<RoleModel> getRoleList() {
		// TODO Auto-generated method stub
		List<RoleModel> roleList = new ArrayList<RoleModel>();
		roleList=rbacDao.getRoleList();
		return roleList;
	}
	
	/**
	 * author qwc
	 * 2017年6月22日下午8:05:00
	 * @param roleName
	 * @return
	 * 通过角色名称判断角色是否存在
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.RbacService#checkRoleHasByNa(java.lang.String)
	 */
	@Override
	public int checkRoleHasByNa(String roleName) {
		// TODO Auto-generated method stub
		int checkStatus=rbacDao.checkRoleHasByNa(roleName);
		return checkStatus;
	}

	/**
	 * author qwc
	 * 2017年6月24日下午12:12:56
	 * @param roleId
	 * @return
	 * 角色授权
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.RbacService#assignPrev(int)
	 */
	@Override
	public int assignPrev(int roleId, String role_powers) {
		// TODO Auto-generated method stub
		int assignStatus=0;
		RoleModel roleModel=new RoleModel();
		roleModel.setId(roleId);
		roleModel.setRole_powers(role_powers);
		assignStatus=rbacDao.assignPrev(roleModel);
		return assignStatus;
	}
    
	/**
	 * author qwc
	 * 2017年6月26日下午1:17:45
	 * @param roleId
	 * @return
	 * 根据角色ID获取角色信息
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.RbacService#getPrevById(int)
	 */
	@Override
	public String getPrevById(int roleId) {
		// TODO Auto-generated method stub
		String role_powers=null;
		role_powers=rbacDao.getPrevById(roleId);
		return role_powers;
	}
	

	/*-----------------------------------------------部门模块---------------------------------*/
	/**
	 * author qwc
	 * 2017年6月18日上午12:05:45
	 * @param deptName
	 * @return
	 * 添加部门
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.RbacService#addDept(java.lang.String)
	 */
	@Override
	public int addDept(String deptName) {
		// TODO Auto-generated method stub
		int addStatus=0;
		addStatus=rbacDao.addDept(deptName);
		return addStatus;
	}
    
	/**
	 * author qwc
	 * 2017年6月18日上午12:18:14
	 * @return
	 * 获取部门的总数量
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.RbacService#getDeptAmount()
	 */
	@Override
	public int getDeptAmount() {
		// TODO Auto-generated method stub
		int amount=0;
		amount=rbacDao.getDeptAmount();
		return amount;
	}
	
	/**
	 * author qwc
	 * 2017年6月18日下午2:15:44
	 * @param dpId
	 * @return
	 * 根据ID获取部门信息
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.RbacService#getDeptInfoById(int)
	 */
	@Override
	public DeptModel getDeptInfoById(int dpId) {
		// TODO Auto-generated method stub
		DeptModel deptInfoModel= new DeptModel();
		deptInfoModel=rbacDao.getDeptInfoById(dpId);
		return deptInfoModel;
	}
	
    /**
     * author qwc
     * 2017年6月18日上午12:18:57
     * @param startPage
     * @param pageSize
     * @return
     * 分页获取部门的信息
     */
    /* (non-Javadoc)
     * @see com.hroa.service.RbacService#getAllDept(int, int)
     */
	@Override
	public List<DeptModel> getAllDept(int startPage, int pageSize) {
		// TODO Auto-generated method stub
		List<DeptModel> deptList = new ArrayList<DeptModel>();
		deptList=rbacDao.getAllDept(startPage, pageSize);
		return deptList;
	}
	
	/**
	 * author qwc
	 * 2017年6月21日下午10:38:58
	 * @return
	 * 获取部门集合
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.RbacService#getDeptList()
	 */
	@Override
	public List<DeptModel> getDeptList() {
		// TODO Auto-generated method stub
		List<DeptModel> deptList = new ArrayList<DeptModel>();
		deptList=rbacDao.getDeptList();
		return deptList;
	}

	/**
	 * author qwc
	 * 2017年6月18日下午2:32:00
	 * @param deptInfoModel
	 * @return
	 * 修改部门信息
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.RbacService#alertDept(com.hroa.model.DeptModel)
	 */
	@Override
	public int alertDept(DeptModel deptInfoModel) {
		// TODO Auto-generated method stub
		int alertStatus=rbacDao.alertDept(deptInfoModel);
		return alertStatus;
	}

	@Override
	public int getRoleAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
