package com.hroa.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hroa.model.Jobinfo;
import com.hroa.model.ShCompany;
import com.hroa.service.JobinfoService;
import com.hroa.util.Page;

@Controller
@RequestMapping("Jobinfo")
public class JobinfoController {
	@Resource
	private JobinfoService JobinfoService;
	@Resource
	private com.hroa.service.ShCompanyService ShCompanyService;

	@RequestMapping("listJobinfoUI")
	public String listJobinfoUI(HttpServletRequest request, Jobinfo Jobinfo, Page<Jobinfo> page) {
		String searchType = request.getParameter("searchType");
		String searchValue = request.getParameter("searchValue");
		Map<String, Object> map = page.getPageMap();
		map.put("searchType", searchType);
		map.put("searchValue", searchValue);
		request.setAttribute("searchType", searchType);
		request.setAttribute("searchValue", searchValue);
		page.setParamEntity(Jobinfo);
		page = JobinfoService.findByPage(page);
		request.setAttribute("page", page);
		if (Jobinfo.getcId() != null) {
			ShCompany company = ShCompanyService.findByCompanyId(Jobinfo.getcId());
			request.setAttribute("company", company);
		}
		return "/jobinfo/jobinfo_listUI";
	}


	@RequestMapping("editJobinfoUI")
	public String editJobinfoUI(ModelMap model, HttpServletRequest request, Jobinfo Jobinfo) {
		Jobinfo = JobinfoService.findById(Jobinfo.getId());
		ShCompany company = ShCompanyService.findByCompanyId(Jobinfo.getcId());
		model.addAttribute("company", company);
		model.addAttribute("jobinfo", Jobinfo);
		return "/jobinfo/jobinfo_edit";
	}

	@RequestMapping("showJobinfoUI")
	public String showJobinfoUI(ModelMap model, HttpServletRequest request, Jobinfo Jobinfo) {
		Jobinfo = JobinfoService.findById(Jobinfo.getId());
		ShCompany company = ShCompanyService.findByCompanyId(Jobinfo.getcId());
		model.addAttribute("company", company);
		model.addAttribute("jobinfo", Jobinfo);
		return "/jobinfo/jobinfo_show";
	}

	@RequestMapping("saveJobinfoUI")
	public String saveJobinfoUI(ModelMap model, HttpServletRequest request, Jobinfo Jobinfo) {
		JobinfoService.updateJobinfo(Jobinfo);
		return listJobinfoUI(request, new Jobinfo(), new Page<Jobinfo>());
	}
	
	@RequestMapping("addJobinfoUI")
	public String addJobinfoUI(ModelMap model, HttpServletRequest request, Jobinfo Jobinfo) {
		ShCompany company = ShCompanyService.findByCompanyId(Jobinfo.getcId());
		request.setAttribute("company", company);
		return "/jobinfo/jobinfo_add";
	}

	@RequestMapping("addJobinfo")
	public String addJobinfo(ModelMap model, HttpServletRequest request, Jobinfo Jobinfo) {
		Jobinfo.setIsFinish(1);
		JobinfoService.addJobinfo(Jobinfo);
		return listJobinfoUI(request, new Jobinfo(), new Page<Jobinfo>());
	}

	@RequestMapping("saveJobinfo")
	public String saveJobinfo(ModelMap model, HttpServletRequest request, Jobinfo Jobinfo) {
		JobinfoService.updateJobinfo(Jobinfo);
		Jobinfo.setId(null);
		return listJobinfoUI(request,Jobinfo, new Page<Jobinfo>());
	}

	@RequestMapping("deleteJobinfo")
	public String deleteJobinfo(ModelMap model, HttpServletRequest request, Jobinfo Jobinfo) {
		JobinfoService.deleteJobinfo(Jobinfo.getId());
		return listJobinfoUI(request, new Jobinfo(), new Page<Jobinfo>());
	}
}
