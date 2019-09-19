package com.hroa.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hroa.model.JobRecord;
import com.hroa.service.JobRecordService;
import com.hroa.util.Page;


/**
 * 企业录入
 * @author qiuwenqiol
 *
 */
@Controller
@RequestMapping("JobRecord")
public class JobRecordController extends BaseController {

	@Resource
	private JobRecordService JobRecordService;

	@RequestMapping("addUI")
	public String addUI() {
		return "/jobrecord/addUI";
	}

	@RequestMapping("add")
	public String addJobRecord(HttpServletRequest  request,JobRecord JobRecord) throws IOException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format(new Date());
		JobRecord.setRegisterdate(date);
		JobRecord.setIsFinish(1);
		JobRecordService.addJobRecord(JobRecord);
		 return "redirect:/JobRecord/listUI.html"; 
	}

	@RequestMapping("delete")
	public String deleteJobRecord(HttpServletRequest request, Page<JobRecord> page, JobRecord JobRecord) {
		JobRecordService.deleteJobRecord(JobRecord.getId());
		 return "redirect:/JobRecord/listUI.html"; 
	}

	@RequestMapping("editUI")
	public String editJobRecordUI(HttpServletRequest request, Integer companyId) {
		JobRecord jobRecord = JobRecordService.findByCompanyId(companyId);
		request.setAttribute("jobRecord", jobRecord);
		return "/jobrecord/editUI";
	}
	
	@RequestMapping("edit")
	public String editJobRecord(HttpServletRequest request, JobRecord JobRecord) {
		System.out.println(JobRecord.getNumber());
		JobRecordService.updateJobRecord(JobRecord);
		return "redirect:/JobRecord/listUI.html";
	}
	
	@RequestMapping("selectUI")
	public String showJobRecordUI(HttpServletRequest request, Integer companyId) {
		JobRecord jobRecord = JobRecordService.findByCompanyId(companyId);
		request.setAttribute("jobRecord", jobRecord);
		return "/jobrecord/selectUI";
	}

	@RequestMapping("listUI")
	public String listCompanyUI(HttpServletRequest request, Page<JobRecord> page, JobRecord JobRecord) {
		page.setParamEntity(JobRecord);
		page = JobRecordService.findByPage(page);
		request.setAttribute("page", page);
		return "/jobrecord/listUI";
	}
	
	@RequestMapping("finish")
	public String finish(HttpServletRequest request, Integer id) {
		JobRecord jobRecord = JobRecordService.findByCompanyId(id);
		jobRecord.setIsFinish(0);
		JobRecordService.updateJobRecord(jobRecord);
		request.setAttribute("jobRecord", jobRecord);
		return "redirect:/JobRecord/listUI.html";
	}

}
