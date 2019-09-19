package com.hroa.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hroa.model.Agent;
import com.hroa.service.AgentService;
import com.hroa.util.Page;



@Controller
@RequestMapping("Agent")
public class AgentController {
	@Resource
	private AgentService AgentService;
	
	@RequestMapping("listAgentUI")
	public String listAgentUI(HttpServletRequest request,Agent Agent,Page<Agent>page){
		String searchType = request.getParameter("searchType");
		String searchValue = request.getParameter("searchValue");
		Map<String, Object> map = page.getPageMap();
		map.put("searchType", searchType);
		map.put("searchValue", searchValue);
		request.setAttribute("searchType", searchType);
		request.setAttribute("searchValue", searchValue);
		page.setParamEntity(Agent);
		page = AgentService.findByPage(page);
		request.setAttribute("page", page);
		return "/agent/agent_listUI";
	}
	
	@RequestMapping("listAgentUserUI")
	public String listAgentUserUI(HttpServletRequest request,Agent Agent,Page<Agent>page){
		page.setParamEntity(Agent);
		page = AgentService.findByPage(page);
		request.setAttribute("page", page);
		return "/Agent/Agent_user_listUI";
	}
	
	
	@RequestMapping("editAgentUI")
	public String editAgentUI(ModelMap model, HttpServletRequest request,Agent Agent){
		Agent = AgentService.findById(Agent.getId());
		model.addAttribute("agent", Agent);
		return "/agent/agent_edit";
	}
	
	@RequestMapping("showAgentUI")
	public String showAgentUI(ModelMap model, HttpServletRequest request,Agent Agent){
		Agent = AgentService.findById(Agent.getId());
		model.addAttribute("agent", Agent);
		return "/agent/agent_show";
	}
	
	@RequestMapping("saveAgentUI")
	public String saveAgentUI(ModelMap model, HttpServletRequest request,Agent Agent){
		AgentService.updateAgent(Agent);
		return listAgentUI(request, new Agent(), new Page<Agent>());
	}
	
	@RequestMapping("addAgent")
	public String addAgentUI(ModelMap model, HttpServletRequest request,Agent Agent){
		AgentService.addAgent(Agent);
		return listAgentUI(request, new Agent(), new Page<Agent>());
	}
	
	@RequestMapping("saveAgent")
	public String saveAgent(ModelMap model, HttpServletRequest request,Agent Agent){
		AgentService.updateAgent(Agent);
		return listAgentUI(request, new Agent(), new Page<Agent>());
	}
	
	@RequestMapping("deleteAgent")
	public String deleteAgent(ModelMap model, HttpServletRequest request,Agent Agent){
		AgentService.deleteAgent(Agent.getId());
		return listAgentUI(request, new Agent(), new Page<Agent>());
	}
}
