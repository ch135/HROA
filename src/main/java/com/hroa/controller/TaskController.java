package com.hroa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hroa.model.AdminModel;
import com.hroa.model.DeptModel;
import com.hroa.model.NoticeModel;
import com.hroa.model.TaskModel;
import com.hroa.service.RbacService;
import com.hroa.service.TaskService;
import com.hroa.util.CalcPageUtils;
import com.hroa.util.StringSplitUtils;

@Controller
@RequestMapping("task")
public class TaskController {
	private static Logger logger = Logger.getLogger("TaskController"); 
	@Resource
	TaskService taskService;
	@Resource
	RbacService rbacForTaskService;
	/**
	 * author qwc
	 * 2017年6月29日下午2:39:16
	 * 添加任务
	 * @throws IOException 
	 */
	@RequestMapping("addTask")
	public void addTask(HttpServletResponse response,HttpServletRequest request,@ModelAttribute TaskModel addTaskModel) throws IOException{
		int addStatus=0;
		PrintWriter out=response.getWriter();
		ObjectMapper mapper = new ObjectMapper(); 
	    ObjectNode addJson = mapper.createObjectNode();
		String deptId=request.getParameter("deptId");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		addTaskModel.setDept_id(Integer.parseInt(deptId));
		addTaskModel.setTitle(title);
		addTaskModel.setContent(content);
		addStatus=taskService.addTaskTxt(addTaskModel);//添加任务
		if(addStatus>0){
			addJson.put("status", 1);
			out.write(addJson.toString());
		}else{
			addJson.put("status", 0);
			out.write(addJson.toString());
		}
	}
	
	/**
	 * author qwc
	 * 2017年6月30日下午4:11:00
	 * @return
	 * 跳转到添加任务界面
	 */
	@RequestMapping("jpTs")
	public ModelAndView rendirToAddTs(){
		ModelAndView rendirAddTsModelAndView=new ModelAndView();
		List<DeptModel> deptList = new ArrayList<DeptModel>();
		deptList=rbacForTaskService.getDeptList();
		rendirAddTsModelAndView.addObject("deptList", deptList);
		rendirAddTsModelAndView.setViewName("task/add");
		return rendirAddTsModelAndView;
	}
	
	/**
	 * author qwc
	 * 2017年6月30日下午4:45:05
	 * @return
	 * 任务分配
	 */
	@RequestMapping("agTask")
	public ModelAndView arrangeTask(HttpServletRequest request,@ModelAttribute DeptModel deptInfo){
		String deptId=request.getParameter("deptId");
		String lineAmount=request.getParameter("lineAmount");
		String taskId=request.getParameter("taskId");
		String deptName=null;
		int totalAmount=0;//用户总数量
		int intg=0;
		int remaind=0;
		deptInfo=rbacForTaskService.getDeptInfoById(Integer.parseInt(deptId));
		deptName=deptInfo.getDpname();
		ModelAndView arrangeTsModelAndView=new ModelAndView();
		List<AdminModel> adminList = new ArrayList<AdminModel>();
		logger.info("deptId:"+deptId);
		adminList=taskService.gtAdByDeptId(Integer.parseInt(deptId));
		totalAmount=adminList.size();
		logger.info("totalAmount:"+totalAmount);
		intg=totalAmount/Integer.parseInt(lineAmount);
		remaind=totalAmount%Integer.parseInt(lineAmount);
		if(remaind!=0){
			intg=intg+1;
		}
		logger.info("LineAmount:"+intg);
		arrangeTsModelAndView.addObject("taskId",taskId);//
		arrangeTsModelAndView.addObject("lineAmount",intg);//行数量
		arrangeTsModelAndView.addObject("totalAmount", totalAmount);//总共数量
		arrangeTsModelAndView.addObject("adminList", adminList);
		arrangeTsModelAndView.addObject("deptName", deptName);
		arrangeTsModelAndView.setViewName("task/arrange");
		return arrangeTsModelAndView;
	}
	
	/**
	 * author qwc
	 * 2017年6月29日下午2:47:35
	 * @param response
	 * @param request
	 * @return
	 * 分页获取任务集合
	 */
	@RequestMapping("gtTask")
	public ModelAndView gtTask(HttpServletResponse response,HttpServletRequest request){
		ModelAndView gtTaskListModelAndView=new ModelAndView();
		List<TaskModel> gtTsList = new ArrayList<TaskModel>();
		String stPg=request.getParameter("startPage");
		String pgSz=request.getParameter("pageSize");
		int amount=0;
		int totalPage=0;
		int startPage=Integer.parseInt(stPg);
		int pageSize=Integer.parseInt(pgSz);
		amount=taskService.gtTaskAmount();
		gtTsList=taskService.gtTsByPages((startPage-1)*pageSize, pageSize);
		totalPage=CalcPageUtils.totalPage(pageSize,amount);//总页数
		logger.info("totalPage:"+totalPage);
		gtTaskListModelAndView.addObject("taskList", gtTsList);
		gtTaskListModelAndView.addObject("currentPage", stPg);
		gtTaskListModelAndView.addObject("perPageAmount", gtTsList.size());
		gtTaskListModelAndView.addObject("totalPage", totalPage);
		gtTaskListModelAndView.setViewName("task/list");
		return gtTaskListModelAndView;
	}
	
	/**
	 * author qwc
	 * 2017年7月1日下午12:01:47
	 * @param request
	 * 批量更新用户的任务集合
	 * @throws IOException 
	 */
	@RequestMapping("gtTsListByUsId") 
	public void getUsersTs(HttpServletRequest request,HttpServletResponse response,@ModelAttribute TaskModel taskModel) throws IOException{
		String taskId=request.getParameter("taskId");
		String users_id=request.getParameter("users_id");
		String[] usersId=null;
		PrintWriter out=response.getWriter();
		ObjectMapper mapper = new ObjectMapper(); 
	    ObjectNode upJson = mapper.createObjectNode();
		int upStatus=0;
		int upTsStatus=0;
		String task_id=null;
		List<AdminModel> gtTsList = new ArrayList<AdminModel>();
		taskModel.setId(Integer.parseInt(taskId));
		taskModel.setUsers_id(users_id);
		upTsStatus=taskService.upUsersId(taskModel);
		usersId=StringSplitUtils.split(users_id);
		gtTsList=taskService.getTaskIdList(usersId);//根据usersId获取出要分配的user的目前的任务
		for(int i=0;i<gtTsList.size();i++){
			if(gtTsList.get(i).getTask_id()!=null){
				task_id=gtTsList.get(i).getTask_id();
				if(task_id.indexOf(taskId+",")<0){
					gtTsList.get(i).setTask_id(task_id+taskId+",");
				}
			}else{
				gtTsList.get(i).setTask_id(taskId);
			}
		}
		upStatus=taskService.upTsId(gtTsList);//把任务id根据userId分配到oa_admin表的task_id字段中
		if(upStatus>0){
			upJson.put("status",1);
			out.write(upJson.toString());
		}else{
			upJson.put("status",0);
			out.write(upJson.toString());
		}
	}
	
	/**
	 * author qwc
	 * 2017年7月1日下午8:19:50
	 * @param request
	 * @param response
	 * @throws IOException
	 * 根据任务ID获取分配用户的usersId
	 */
	@RequestMapping("getUsersId")
	public void getUsersId(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out=response.getWriter();
		ObjectMapper mapper = new ObjectMapper(); 
	    ObjectNode usersIdJson = mapper.createObjectNode();
		String taskId=request.getParameter("taskId");
		String usersId=taskService.gtUsersId(Integer.parseInt(taskId));
		logger.info("usersId>>:"+usersId);
		usersIdJson.put("usersId", usersId);
		out.write(usersIdJson.toString());
	}
	
	/**
	 * author qwc
	 * 2017年7月1日下午8:22:05
	 * 根据任务ID批量获取任务集合
	 */
	@RequestMapping("gtTsByTsIds")
	public void gtTaskIdByUserId(HttpSession session,@ModelAttribute AdminModel adInfoModel){
		adInfoModel=(AdminModel)session.getAttribute("adminLgSession");
		int userId=adInfoModel.getId();
		String[] taskId=null;
		List<TaskModel> tsList=new ArrayList<TaskModel>();
		String task_id=taskService.getTaskId(userId);//根据userId获取出任务ID
		taskId=StringSplitUtils.split(task_id);
		tsList=taskService.gtTaskListByTsId(taskId);
		JSONArray json=JSONArray.fromObject(tsList);
		logger.info("taskJson>>:"+json);
	}
}
