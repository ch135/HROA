package com.hroa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hroa.model.AdminModel;
import com.hroa.model.DeptModel;
import com.hroa.model.RoleModel;
import com.hroa.service.RbacService;
import com.hroa.util.CalcPageUtils;
import com.hroa.util.StringMD5;
@Controller
@RequestMapping("rbac")
public class RbacController {
	private static Logger logger = Logger.getLogger("RbacController");   
	@Resource
	RbacService rbacService;
	/**
	 * author qwc
	 * 2017年6月13日下午7:10:23
	 * 添加系统用户
	 * @throws IOException 
	 */
	@RequestMapping("adduser")
	public void addUser(HttpServletResponse response,@ModelAttribute AdminModel userModel,@RequestParam(value="account")String account,
			@RequestParam(value="password")String password,@RequestParam(value="nickname")String nickname,@RequestParam(value="dpId")String deptId) throws IOException{
		int addStatus=0;
		PrintWriter out=response.getWriter();
		ObjectMapper mapper = new ObjectMapper(); 
	    ObjectNode addJson = mapper.createObjectNode();
		userModel.setAccount(account);//账号
		password=StringMD5.MD5Digest(password);//密码
		userModel.setPassword(password);
		userModel.setNickname(nickname);//昵称
		userModel.setDeptid(Integer.parseInt(deptId));//部门ID
		if(rbacService.checkAccount(account)==0){
			addStatus=rbacService.addUser(userModel);
			if(addStatus>0){//添加成功
				addJson.put("status","1");
				out.write(addJson.toString());
			}else{//添加失败
				addJson.put("status","0");
				out.write(addJson.toString());
			}
		}else{//账号已存在
			addJson.put("status","2");
			out.write(addJson.toString());
		}
	}
	
	/**
	 * author qwc
	 * 2017年6月22日上午12:55:36
	 * @return
	 * 跳转到添加用户界面
	 */
	@RequestMapping("jpToAddUr")
	public ModelAndView rendirToAddUr(){
		ModelAndView rendirAddUrModelAndView=new ModelAndView();
		List<DeptModel> deptList = new ArrayList<DeptModel>();
		deptList=getDeptList();
		rendirAddUrModelAndView.addObject("deptList", deptList);
		rendirAddUrModelAndView.setViewName("rbac/add");
		return rendirAddUrModelAndView;
	}
	
	public void addRole(){
		
	}
	
	/**
	 * author qwc
	 * 2017年6月18日下午8:32:30
	 * @return
	 * 根据ID修改用户信息
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("alertUrInfo") 
	public ModelAndView alertUserInfo(@ModelAttribute DeptModel deptInfoModel,@ModelAttribute RoleModel roleInfoModel,@ModelAttribute AdminModel infoModel,HttpSession session,HttpServletRequest request){
		ModelAndView userInfoModelAndView=new ModelAndView();
		String userId=request.getParameter("userId");
		String roleName=null;
		Map<String,String> userPowerMap = new HashMap<String,String>();//权限集合
		List<RoleModel> roleList = new ArrayList<RoleModel>();//角色列表roleList
		List<DeptModel> deptList = new ArrayList<DeptModel>();//部门列表集合deptList
		logger.info("userId:"+Integer.parseInt(userId));
		infoModel=rbacService.getUserInfoById(Integer.parseInt(userId));
		if(session.getAttribute("userPowerMap")!=null){
			userPowerMap=(Map<String, String>) session.getAttribute("userPowerMap");
		}
		roleList=rbacService.getRoleList();//保存角色列表
		deptList=getDeptList();//保存部门列表
		/*if(userPowerMap.get("p24")!=null){//判断用户是否有角色分配权
			
			logger.info("有角色分配权！");
		}else{
			logger.info("没有角色分配权！");
		}*/
		roleInfoModel=rbacService.gtRoleInfo(infoModel.getRole_id());//角色信息
		roleName=roleInfoModel.getRole_name();
		userInfoModelAndView.addObject("userInfoRoleName",roleName);//用户的角色名称
		userInfoModelAndView.addObject("userInfo", infoModel);//用户基本信息
		userInfoModelAndView.addObject("roleList",roleList);//角色集合
		userInfoModelAndView.addObject("deptList",deptList);//部门集合
		userInfoModelAndView.setViewName("rbac/userInfo");
		return userInfoModelAndView;
	}
	
	/**
	 * author qwc
	 * 2017年6月16日下午9:32:00
	 * @param request
	 * @return
	 * 分页获取所有用户信息
	 */
	@RequestMapping("gtUserList")
	public ModelAndView getUserList(HttpServletRequest request){
		String stPg=request.getParameter("startPage");
		String pgSize=request.getParameter("pageSize");
		int totalAmount=0;//用户总数量
		int totalPage=0;
		int startPage=Integer.parseInt(stPg);
		int pageSize=Integer.parseInt(pgSize);
		ModelAndView userListModelAndView=new ModelAndView();
		List<AdminModel> userList = new ArrayList<AdminModel>();
		totalAmount=rbacService.getAdminAmount();
		if(startPage==0){
			startPage=1;
		}
		userList=rbacService.getAllAdmin((startPage-1)*pageSize, pageSize);
		totalPage=CalcPageUtils.totalPage(pageSize, totalAmount);//计算总页数
		logger.info("totalPage:"+totalPage);
		logger.info("stPg:"+stPg);
		logger.info("userList.size():"+userList.size());
		userListModelAndView.addObject("perPageAmount", userList.size());//一次获取的数量
		userListModelAndView.addObject("userList", userList);
		userListModelAndView.addObject("totalPage", totalPage);
		userListModelAndView.addObject("currentPage", stPg);
		userListModelAndView.setViewName("/rbac/list");//跳转页面
		return userListModelAndView;
	}
	/*{"account":"15768616002","deptInfo":null,"deptid":0,"id":1,"login_time":"","nickname":"15768616002","password":"12b1e3e0f658b86d2ab478029fe0462a","roleInfoList":[{"deptId":0,"id":1,"role_describes":"","role_name":"超级管理员","role_powers":"p1,p11,p12"}],"role_id":1,"status":0}*/
	public ModelAndView getRoleList(){
		return null;
	}
	
/*----------------------------------------部门操作-------------------------------------------*/
	/**
	 * author qwc
	 * 2017年6月17日下午11:51:29
	 * 添加部门
	 * @throws IOException 
	 */
	@RequestMapping("adDept")
	public void addDept(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out=response.getWriter();
		ObjectMapper mapper = new ObjectMapper(); 
	    ObjectNode addDeptJson = mapper.createObjectNode();
	    int addStatus=0;
		String deptName=request.getParameter("deptName");
		addStatus=rbacService.addDept(deptName);
		if(addStatus==1){
			addDeptJson.put("status","1");
			out.write(addDeptJson.toString());
			logger.info("部门添加成功！"+addDeptJson.toString());
		}else{
			addDeptJson.put("status","0");
			out.write(addDeptJson.toString());
		}
	}
	
	/**
	 * author qwc
	 * 2017年6月18日下午2:18:57
	 * @param request
	 * @param deptInfoModel
	 * @return
	 * 根据ID获取部门信息/修改部门信息
	 * @throws IOException 
	 */
	@RequestMapping("gtAlDeptInfo")
	public  ModelAndView alertDeptList(HttpServletResponse response,HttpServletRequest request,@ModelAttribute DeptModel deptInfoModel) throws IOException{
		String dpId=request.getParameter("dpId");
		String dpName=request.getParameter("dpName");
		String method=request.getParameter("method");
		PrintWriter out=response.getWriter();
		ObjectMapper mapper = new ObjectMapper(); 
	    ObjectNode alertDeptJson = mapper.createObjectNode();
		if(method!=null&&method.equals("gtInfo")){
			ModelAndView deptModelAndView=new ModelAndView();
			deptInfoModel=rbacService.getDeptInfoById(Integer.parseInt(dpId));
			deptModelAndView.addObject("deptInfo", deptInfoModel);
			deptModelAndView.setViewName("rbac/department/add");
			return deptModelAndView;
		}else if(method!=null&&method.equals("alert")){//修改部门信息
			deptInfoModel.setId(Integer.parseInt(dpId));
			deptInfoModel.setDpname(dpName);
			int alertStatus=rbacService.alertDept(deptInfoModel);//修改状态
			if(alertStatus>0){
				alertDeptJson.put("status", "1");//修改成功
			}else{
				alertDeptJson.put("status", "0");//修改失败
			}
			out.write(alertDeptJson.toString());
		}
		return null;
	}
	
	/**
	 * author qwc
	 * 2017年6月22日上午12:48:54
	 * @return
	 * 获取部门集合
	 */
	public List<DeptModel> getDeptList(){
		List<DeptModel> deptList=new ArrayList<DeptModel>();
		deptList=rbacService.getDeptList();
		return deptList;
	}
	
	/**
	 * author qwc
	 * 2017年6月18日上午12:12:05
	 * @return
	 * 分页获取所有部门信息
	 */
	@RequestMapping("gtDpList")
	public ModelAndView getDeptList(HttpServletRequest request){
		String stPg=request.getParameter("startPage");
		String pgSize=request.getParameter("pageSize");
		int totalAmount=0;//用户总数量
		int totalPage=0;
		int startPage=Integer.parseInt(stPg);
		int pageSize=Integer.parseInt(pgSize);
		ModelAndView deptListModelAndView=new ModelAndView();
		List<DeptModel> deptList = new ArrayList<DeptModel>();
		totalAmount=rbacService.getDeptAmount();
		if(startPage==0){
			startPage=1;
		}
		deptList=rbacService.getAllDept((startPage-1)*pageSize, pageSize);
		totalPage=CalcPageUtils.totalPage(pageSize, totalAmount);//计算总页数
		deptListModelAndView.addObject("perPageAmount", deptList.size());//一次获取的数量
		deptListModelAndView.addObject("deptList", deptList);
		deptListModelAndView.addObject("currentPage", stPg);
		deptListModelAndView.addObject("totalPage", totalPage);
		deptListModelAndView.setViewName("rbac/department/list");//跳转页面
		logger.info("部门总页数："+totalPage);
		return deptListModelAndView;
	}
	
/*---------------------------------------------角色操作----------------------------------*/
	/**
	 * author qwc
	 * 2017年6月22日下午7:31:20
	 * @return
	 * 跳转到添加角色界面
	 */
	@RequestMapping("jpToAddRl")
	public ModelAndView jumpToAddRl(){
		ModelAndView jpToAddRlView=new ModelAndView();
		List<DeptModel> deptList=new ArrayList<DeptModel>();
		deptList=getDeptList();
		jpToAddRlView.addObject("deptList", deptList);
		jpToAddRlView.setViewName("rbac/role/add");
		return jpToAddRlView;
	}
	
	/**
	 * author qwc
	 * 2017年6月22日下午7:41:29
	 * @param request
	 * 添加角色
	 * @throws IOException 
	 */
	@RequestMapping("addRole") 
	public void addRole(HttpServletRequest request,HttpServletResponse response,@ModelAttribute RoleModel roleModel) throws IOException{
		String roleName=request.getParameter("roleName");
		String roleIntro=request.getParameter("roleIntro");
		String dpId=request.getParameter("dpId");
		PrintWriter out=response.getWriter();
		ObjectMapper mapper = new ObjectMapper(); 
	    ObjectNode addRoleJson = mapper.createObjectNode();
		int addRoleStatus=0;
		int checkRoleHasStatus=5;
		roleModel.setRole_name(roleName);//角色名称
		roleModel.setDeptid(Integer.parseInt(dpId));
		roleModel.setRole_describes(roleIntro);//角色描述
		checkRoleHasStatus=rbacService.checkRoleHasByNa(roleName);
		if(checkRoleHasStatus==0){
			addRoleStatus=rbacService.addRole(roleModel);
			if(addRoleStatus==1){
				addRoleJson.put("status", "1");
				logger.info("角色添加成功！"+"\n");
				out.write(addRoleJson.toString());
			}else if(addRoleStatus==0){
				addRoleJson.put("status", "0");
				logger.info("角色添加失败！"+"\n");
				out.write(addRoleJson.toString());
			}
		}else{
			addRoleJson.put("status", "2");
			logger.info("角色已存在！"+"\n");
			out.write(addRoleJson.toString());
		}
	}
	
	/**
	 * author qwc
	 * 2017年6月22日下午9:44:59
	 * @param request
	 * @param rlInfoModel
	 * @return
	 * 修改角色信息
	 */
	@RequestMapping("altRole") 
	public ModelAndView altRole(HttpServletRequest request,@ModelAttribute RoleModel rlInfoModel){
		String rlId=request.getParameter("roleId");
		ModelAndView altRoleModelAndView=new ModelAndView();
		List<DeptModel> deptList = new ArrayList<DeptModel>();
		deptList=getDeptList();
		rlInfoModel=rbacService.gtRoleInfo(Integer.parseInt(rlId));
		altRoleModelAndView.addObject("roleInfo", rlInfoModel);//部门信息
		altRoleModelAndView.addObject("deptList", deptList);//部门集合
		altRoleModelAndView.setViewName("rbac/role/update");//跳转到修改角色界面
		return altRoleModelAndView;
	}
	
	/**
	 * author qwc
	 * 2017年6月24日下午12:09:04
	 * 角色授权
	 * @throws IOException 
	 */
	@RequestMapping("assignRole")
	public void assignPrev(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String roleId=null;
		String rolePowers=null;
		int assginStatus=0;
		PrintWriter out=response.getWriter();
		ObjectMapper mapper = new ObjectMapper(); 
	    ObjectNode assignRoleJson = mapper.createObjectNode();
		roleId=request.getParameter("roleId");
		rolePowers=request.getParameter("rolePowers");
		logger.info("roleId>>>>>>"+roleId);
		assginStatus=rbacService.assignPrev(Integer.parseInt(roleId), rolePowers);
		logger.info("assginStatus>>>>>>"+assginStatus);
		if(assginStatus>0){
			assignRoleJson.put("status", "1");
			out.write(assignRoleJson.toString());
		}else{
			assignRoleJson.put("status", "0");
			out.write(assignRoleJson.toString());
		}
	}
	
	/**
	 * author qwc
	 * 2017年6月26日下午1:11:03
	 * @return
	 * 根据角色ID获取角色信息
	 * @throws IOException 
	 */
	@RequestMapping("getPrev") 
	public ModelAndView prevRole(HttpServletRequest reqeust,HttpServletResponse response) throws IOException{
		ModelAndView prevModelAndView =new ModelAndView();
		PrintWriter out=response.getWriter();
		ObjectMapper mapper = new ObjectMapper(); 
	    ObjectNode gtPreJson = mapper.createObjectNode();
		String method=reqeust.getParameter("method");
		String roleId=reqeust.getParameter("roleId");
		if(method!=null&&method.equals("jumpPrev")){
			prevModelAndView.addObject("roleId", roleId);
			prevModelAndView.setViewName("rbac/role/prev");//跳转到角色授权界面
			logger.info("roleId>>>"+roleId);
			return prevModelAndView;
		}else if(method!=null&&method.equals("alertPrev")){//
			String role_powers=rbacService.getPrevById(Integer.parseInt(roleId));
			gtPreJson.put("pre", role_powers);
			out.write(gtPreJson.toString());
		}
		return null;
	}
	
	/**
	 * author qwc
	 * 2017年6月22日下午8:17:49
	 * @param request
	 * @return
	 * 分页获取角色集合
	 */
	@RequestMapping("getRlList")
	public ModelAndView getRoleList(HttpServletRequest request){
		String stPg=request.getParameter("startPage");
		String pgSize=request.getParameter("pageSize");
		int totalAmount=0;//用户总数量
		int totalPage=0;
		int startPage=Integer.parseInt(stPg);
		int pageSize=Integer.parseInt(pgSize);
		ModelAndView roleListModelAndView=new ModelAndView();
		List<RoleModel> roleList = new ArrayList<RoleModel>();
		totalAmount=rbacService.getRoleAmount();
		if(startPage==0){
			startPage=1;
		}
		roleList=rbacService.getAllRole((startPage-1)*pageSize, pageSize);
		totalPage=CalcPageUtils.totalPage(pageSize, totalAmount);//计算总页数
		roleListModelAndView.addObject("perPageAmount", roleList.size());//每一页的角色数量
		roleListModelAndView.addObject("roleList", roleList);
		roleListModelAndView.addObject("currentPage", stPg);
		roleListModelAndView.addObject("totalPage", totalPage);//总共有几页角色数据
		roleListModelAndView.setViewName("rbac/role/list");//跳转角色列表页面
		logger.info("部门总页数："+totalPage);
		return roleListModelAndView;
	}
}
