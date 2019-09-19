package com.hroa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hroa.model.JobLogModel;
import com.hroa.model.TaskModel;
import com.hroa.service.JobLogService;
import com.hroa.util.CalcPageUtils;
@Controller
@RequestMapping("jbLog")
public class JobLogController {
	private static Logger logger = Logger.getLogger("JobLogController");
	@Resource
	JobLogService jbLgService;
	/**
	 * author qwc
	 * 2017年6月29日下午4:18:58
	 * @param response
	 * @param request
	 * @param jbLgModel
	 * @throws IOException
	 * 添加日志
	 */
	@RequestMapping("addJbLog")
	public void addJobLog(HttpServletResponse response,HttpServletRequest request,@ModelAttribute JobLogModel jbLgModel) throws IOException{
		int addStatus=0;
		PrintWriter out=response.getWriter();
		ObjectMapper mapper = new ObjectMapper(); 
	    ObjectNode addJson = mapper.createObjectNode();
		String classfy=request.getParameter("classfy");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		jbLgModel.setClassfy(Integer.parseInt(classfy));//日志类型，1:日报 2:周计划 3:月计划
		jbLgModel.setTitle(title);
		jbLgModel.setContent(content);
		addStatus=jbLgService.addJobLog(jbLgModel);
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
	 * 2017年6月29日下午2:47:35
	 * @param response
	 * @param request
	 * @return
	 * 分页获取任务
	 */
	@RequestMapping("gtJbLg")
	public ModelAndView gtJobLog(HttpServletResponse response,HttpServletRequest request){
		ModelAndView gtJbLgListModelAndView=new ModelAndView();
		List<JobLogModel> gtJbLgList = new ArrayList<JobLogModel>();
		String stPg=request.getParameter("startPage");
		String pgSz=request.getParameter("pageSize");
		int amount=0;
		int totalPage=0;
		int startPage=Integer.parseInt(stPg);
		int pageSize=Integer.parseInt(pgSz);
		amount=jbLgService.gtJbLgAmount();
		gtJbLgList=jbLgService.gtJbLgByPages((startPage-1)*pageSize, pageSize);
		totalPage=CalcPageUtils.totalPage(pageSize,amount);//总页数
		logger.info("totalPage:"+totalPage);
		gtJbLgListModelAndView.addObject("jgLgList", gtJbLgList);
		gtJbLgListModelAndView.addObject("currentPage", stPg);
		gtJbLgListModelAndView.addObject("perPageAmount", gtJbLgList.size());
		gtJbLgListModelAndView.addObject("totalPage", totalPage);
		gtJbLgListModelAndView.setViewName("joblog/allList");
		return gtJbLgListModelAndView;
	}
}
