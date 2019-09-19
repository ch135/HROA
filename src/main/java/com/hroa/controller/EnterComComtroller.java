package com.hroa.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hroa.model.EnterCom;
import com.hroa.model.ShUser;
import com.hroa.service.EnterComService;
import com.hroa.service.ShUserService;
import com.hroa.util.Page;



@Controller
@RequestMapping("EnterCom")
public class EnterComComtroller {
	@Resource
	private EnterComService enterComService;
	@Resource
	private ShUserService shUserService;
	
	/**
	 *	录入记录列表
	 * @param request
	 * @param enterCom
	 * @param page
	 * @return
	 */
	@RequestMapping("listEnterComUI")
	public String listEnterComUI(HttpServletRequest request,EnterCom enterCom,Page<EnterCom>page){
		String leave = request.getParameter("leave");
		if(leave!=null&&leave!=""){
			request.setAttribute("leave", "leave");
			return listLeaveComUI(request, enterCom, page);
		}
		page.setParamEntity(enterCom);
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		Map<String, Object> map = page.getPageMap();
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		page = enterComService.findByPage(page);
		request.setAttribute("page", page);
		request.setAttribute("enterCom", enterCom);
		return "/entercom/entercom_listUI";
	}
	/**
	 * 个人列表
	 * @param request
	 * @param enterCom
	 * @param page
	 * @return
	 */
	@RequestMapping("listEnterComUserUI")
	public String listEnterComUserUI(HttpServletRequest request,EnterCom enterCom,Page<EnterCom>page){
		page.setParamEntity(enterCom);
		page = enterComService.findByPage(page);
		request.setAttribute("page", page);
		ShUser user = shUserService.findByUserId(enterCom.getShUser().getId());
		request.setAttribute("user", user);
		return "/entercom/entercom_user_listUI";
	}
	
	
	@RequestMapping("listEnterComAgentUI")
	public String listEnterComAgentUI(HttpServletRequest request,EnterCom enterCom,Page<EnterCom>page){
		page.setParamEntity(enterCom);
		page = enterComService.findByPage(page);
		request.setAttribute("page", page);
		return "/entercom/entercom_agent_listUI";
	}
	
	/**
	 * 编辑页面
	 * @param model
	 * @param request
	 * @param enterCom
	 * @return
	 */
	@RequestMapping("editEnterComUI")
	public String editEnterComUI(ModelMap model, HttpServletRequest request,EnterCom enterCom){
		String leave = request.getParameter("leave");
		if(leave!=null&&leave!=""){
			request.setAttribute("leave", "leave");
		}
		enterCom = enterComService.findById(enterCom.getEnterComid());
		model.addAttribute("enterCom", enterCom);
		model.addAttribute("user", enterCom.getShUser());
		return "/entercom/entercom_edit";
	}
	/**
	 * 离职
	 * @param request
	 * @param enterCom
	 * @param page
	 * @return
	 */
	@RequestMapping("confirmEnterCom")
	public String confirmEnterCom(HttpServletRequest request,EnterCom enterCom,Page<EnterCom>page){
		String date = request.getParameter("dateTime");
		String enterComId=request.getParameter("id");
		EnterCom com = new EnterCom();
		com.setEnterComid(Integer.parseInt(enterComId));
		com.setLeaveDate(date);
		com.setIsWork(false);
		enterComService.updateEnterCom(com);
		enterCom.setEnterComid(null);
		return listEnterComUI(request, enterCom,page);
	}
	/**
	 * 显示单条信息
	 * @param model
	 * @param request
	 * @param enterCom
	 * @return
	 */
	@RequestMapping("showEnterComUI")
	public String showEnterComUI(ModelMap model, HttpServletRequest request,EnterCom enterCom){
		String leave = request.getParameter("leave");
		if(leave!=null&&leave!=""){
			request.setAttribute("leave", "leave");
		}
		enterCom = enterComService.findById(enterCom.getEnterComid());
		model.addAttribute("enterCom", enterCom);
		model.addAttribute("user", enterCom.getShUser());
		return "/entercom/entercom_show";
	}
	
	/**
	 * 更改录入信息
	 * @param model
	 * @param request
	 * @param enterCom
	 * @return
	 */
	@RequestMapping("saveEnterComUI")
	public String saveEnterComUI(ModelMap model, HttpServletRequest request,EnterCom enterCom){
		enterComService.updateEnterCom(enterCom);
		model.addAttribute("enterCom", new EnterCom());
		return listEnterComUI(request, new EnterCom(), new Page<EnterCom>());
	}
	/**
	 * 删除
	 * @param model
	 * @param request
	 * @param enterCom
	 * @return
	 */
	@RequestMapping("deleteEnterCom")
	public String deleteEnterCom(ModelMap model, Page<EnterCom>page,HttpServletRequest request,EnterCom enterCom){
		String id = request.getParameter("id");
		EnterCom com = new EnterCom();
		com.setEnterComid(Integer.parseInt(id));
		com.setIsDelete(true);
		enterComService.updateEnterCom(com);
		return listEnterComUI(request, enterCom,page);
	}
	
	/**
	 * 离职记录
	 * @param request
	 * @param enterCom
	 * @param page
	 * @return
	 */
	@RequestMapping("listLeaveComUI")
	public String listLeaveComUI(HttpServletRequest request,EnterCom enterCom,Page<EnterCom>page){
		page.setParamEntity(enterCom);
		enterCom.setLeaveDate("离职");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		Map<String, Object> map = page.getPageMap();
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		page = enterComService.findByPage(page);
		request.setAttribute("page", page);
		request.setAttribute("enterCom", enterCom);
		return "/entercom/leavecom_listUI";
	}
	
	/**
	 * 获取未读信息数目
	 * @param enterCom
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getNum")
	public Object getNum(EnterCom enterCom){
		Integer[] num = enterComService.getReadNum(enterCom);
		return num;
	}
	
	
}
