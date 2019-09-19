package com.hroa.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.naming.Binding;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.util.Streams;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;













import com.hroa.model.AgentContract;
import com.hroa.model.Officemanage;
import com.hroa.model.ShCompany;
import com.hroa.service.AgentContractService;
import com.hroa.util.DateFormat;
import com.hroa.util.Page;
import com.hroa.util.SerialUtil;

@Controller
@RequestMapping("AgentContract")
public class AgentContractController {
	@Resource AgentContractService agentContractService;
	
	@RequestMapping("add")
	public String add(HttpServletRequest request,Page<AgentContract> page,AgentContract agentContract) throws IllegalStateException, IOException{
		int agentId=Integer.parseInt(request.getParameter("agentId"));
		System.out.println(agentId);
		String name= request.getParameter("agentName");
		String province=request.getParameter("province");
		String city=request.getParameter("city");
		String county=request.getParameter("county");
		String details=request.getParameter("agentDetails");
		String 	school=request.getParameter("agentSchool");
		String phone =request.getParameter("agentPhone");
		String sign=request.getParameter("signDate"); //签订日期
		String temp=sign.substring(0, 4)+sign.substring(5, 7)+sign.substring(8,10);
		System.out.println(temp);
		String contractCode = "DHT" + temp+SerialUtil.serial4();
		String url= contractCode;
		if (request instanceof MultipartHttpServletRequest) {
		MultipartFile items =  ((MultipartHttpServletRequest) request).getFile("agentContract");
		DateFormat dateFormat = new DateFormat();
		String date = dateFormat.format(new Date());
		String path = "C:/HROA/upload/agentContract/"+date;
		File dir = new File(path);
		if(!dir.exists()){
			dir.mkdirs();
		}
		if(items!=null){
			//原始名称
			String oldName = items.getOriginalFilename();
			if(oldName.endsWith(".jpg")||oldName.endsWith(".png")||oldName.endsWith(".gif")||oldName.endsWith(".JPG")
					||oldName.endsWith(".PNG")||oldName.endsWith(".GIF")||oldName.endsWith(".doc")||oldName.endsWith(".DOC")
					||oldName.endsWith(".docx")||oldName.endsWith(".DOCX")||oldName.endsWith(".pdf")||oldName.endsWith(".PDF")){
				//新的名称，由随机码和文件后缀拼接而成
				String newName = url+oldName.substring(oldName.lastIndexOf("."));
				File file  = new File(path,newName);
				//文件上传
				items.transferTo(file);
				String url1  = "C:/HROA/upload/agentContract/"+date+"/"+newName;
				agentContract.setAgentId(agentId);
				agentContract.setName(name);
				agentContract.setProvince(province);
				agentContract.setCity(city);
				agentContract.setCounty(county);
				agentContract.setDetails(details);
				agentContract.setContractCode(contractCode);
				agentContract.setUrl(url1);
				agentContract.setSignDate(sign);
				agentContract.setSchool(school);
				agentContract.setPhone(phone);
				Boolean type = agentContractService.addAgentContract(agentContract);
				if(type==true){
				return "redirect:/AgentContract/showAgentContractList.html";
				}
				else
				{
					return "/index";
				}
				
			}else{
				
			}
		}
		
		}
		return "/index" ;
		
    }
	
	
	
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Page<AgentContract> page, AgentContract agentContract){
/*		agentContract.setId(1);
*/
		agentContract.setId(agentContract.getId());
		agentContract.setState(0);
		Boolean type = agentContractService.deleteAgentContract(agentContract);
		if(type==true){
			System.out.println("删除成功");
		return showAgentContractList(request, page, agentContract);
		}
		else
		{
			return "/index";
		}
    }
	
	
	/*@RequestMapping("deleteShCompany")
	public String deleteShCompany(HttpServletRequest request, Page<ShCompany> page, ShCompany shCompany) {
		System.out.println(shCompany.getId());
		shCompanyService.deleteShCompany(shCompany.getId());
		return listCompanyUI(request, page, shCompany);
	}
	*/
	
	@RequestMapping("showOneAgentContract")
	public String showOneAgentContract(HttpServletRequest request, Model model){
		AgentContract agentContract =new AgentContract();
		agentContract.setAgentId(1);
		List<AgentContract> agentList=agentContractService.showOneAgentContract(agentContract);
		return "/agent/agent_contract_list";
    }
	
	@RequestMapping("showAllAgentContract")
	public String showAllAgentContract(HttpServletRequest request, Model model){
		List<AgentContract> agentList=agentContractService.showAllAgentContract();
		model.addAttribute("agentList", agentList);
		return "/agent/agent_contract_list";
	}
	
	@RequestMapping("showAgentContractList")
	public String showAgentContractList(HttpServletRequest request, Page<AgentContract> page, AgentContract agentContract) {
		String searchType = request.getParameter("searchType");
		String searchValue = request.getParameter("searchValue");
		request.setAttribute("searchType", searchType);
		request.setAttribute("searchValue", searchValue);
		if (searchType != null) {
			if ("name".equals(searchType)) {
				agentContract.setName(searchValue);
			} else {
				
			}
		}
		page.setParamEntity(agentContract);
		Page<AgentContract> newpage = agentContractService.findByPage(page);
		if(newpage.getList().size()>0){
			for(int i=0;i<newpage.getList().size();i++){
				String temp=(newpage.getList().get(i).getUrl()).substring(29);
				newpage.getList().get(i).setUrl(temp);
			}
		}
		else{}
		newpage.setPage(page.getPage());
		request.setAttribute("page", newpage);
		return "/agent/agent_contract_list";
	}
	
	//显示具体的合同信息
	@RequestMapping("showDetails")
	public String showDetails (HttpServletRequest request,Integer id,Model model){
		AgentContract agentContract=agentContractService.showDetails(id);
		model.addAttribute("agentContract", agentContract);
		return "/agent/agent_contract_edit";
		
	}
	
	//编辑代理合同
	@RequestMapping("edit")
	public String edit(HttpServletRequest request,AgentContract agentContract) throws IllegalStateException, IOException{
		int id=Integer.parseInt(request.getParameter("id"));
		int agentId=Integer.parseInt(request.getParameter("agentId"));
		String name= request.getParameter("agentName");
		String province=request.getParameter("province");
		String city=request.getParameter("city");
		String county=request.getParameter("county");
		String details=request.getParameter("agentDetails");
		String 	school=request.getParameter("agentSchool");
		String phone =request.getParameter("agentPhone");
		String sign=request.getParameter("signDate"); //签订日期
		String temp=sign.substring(0, 4)+sign.substring(5, 7)+sign.substring(8,10);
		String contractCode = "DHT" + temp+SerialUtil.serial4();
		String url= contractCode;
		if (request instanceof MultipartHttpServletRequest) {
		MultipartFile items =  ((MultipartHttpServletRequest) request).getFile("agentContract");
		DateFormat dateFormat = new DateFormat();
		String date = dateFormat.format(new Date());
		String path = "C:/HROA/upload/agentContract/"+date;
		File dir = new File(path);
		if(!dir.exists()){
			dir.mkdirs();
		}
		if(items!=null){
			//原始名称
			String oldName = items.getOriginalFilename();
			if(oldName.endsWith(".jpg")||oldName.endsWith(".png")||oldName.endsWith(".gif")||oldName.endsWith(".JPG")
					||oldName.endsWith(".PNG")||oldName.endsWith(".GIF")||oldName.endsWith(".doc")||oldName.endsWith(".DOC")
					||oldName.endsWith(".docx")||oldName.endsWith(".DOCX")||oldName.endsWith(".pdf")||oldName.endsWith(".PDF")){
				//新的名称，由随机码和文件后缀拼接而成
				String newName = url+oldName.substring(oldName.lastIndexOf("."));
				File file  = new File(path,newName);
				//文件上传
				items.transferTo(file);
				String url1  = "C:/HROA/upload/agentContract/"+date+"/"+newName;
				agentContract.setAgentId(agentId);
				agentContract.setName(name);
				agentContract.setProvince(province);
				agentContract.setCity(city);
				agentContract.setCounty(county);
				agentContract.setDetails(details);
				agentContract.setContractCode(contractCode);
				agentContract.setUrl(url1);
				agentContract.setSignDate(sign);
				agentContract.setSchool(school);
				agentContract.setPhone(phone);
				agentContract.setId(id);
				Boolean type = agentContractService.editAgentContract(agentContract);
				if(type==true){
				return "redirect:/AgentContract/showAgentContractList.html";
				}
				else
				{
					return "/index";
				}
				
			}else{
				
				
			}
		}
		else{
			agentContract.setAgentId(agentId);
			agentContract.setName(name);
			agentContract.setProvince(province);
			agentContract.setCity(city);
			agentContract.setCounty(county);
			agentContract.setDetails(details);
			agentContract.setContractCode(contractCode);
			agentContract.setSchool(school);
			agentContract.setPhone(phone);
			agentContract.setId(id);
			Boolean type = agentContractService.editAgentContract(agentContract);
			if(type==true){
			return "redirect:/AgentContract/showAgentContractList.html";
			}
			else
			{
				return "/index";
			}
			
		}
		
		}
			agentContract.setAgentId(agentId);
			agentContract.setName(name);
			agentContract.setProvince(province);
			agentContract.setCity(city);
			agentContract.setCounty(county);
			agentContract.setDetails(details);
			agentContract.setContractCode(contractCode);
			agentContract.setSchool(school);
			agentContract.setPhone(phone);
			agentContract.setSignDate(sign);
			agentContract.setId(id);
			Boolean type = agentContractService.editAgentContract(agentContract);
			if(type==true){
			return "redirect:/AgentContract/showAgentContractList.html";
			}
			else
			{
				return "/index";
			}
	}

	
	//代理查看自己的合同列表
	@RequestMapping("showAgentContractListToAgent")
	public String showAgentContractListToAgent(HttpServletRequest request, Page<AgentContract> page, AgentContract agentContract) {
		String searchType = request.getParameter("searchType");
		String searchValue = request.getParameter("searchValue");
		request.setAttribute("searchType", searchType);
		request.setAttribute("searchValue", searchValue);
		if (searchType != null) {
			if ("name".equals(searchType)) {
				agentContract.setName(searchValue);
			} else {
				
			}
		}
		agentContract.setAgentId(1);//此处应该是获得保存在session中的代理id
		page.setParamEntity(agentContract);
		Page<AgentContract> newpage = agentContractService.findByPageToAgent(page);
		if(newpage.getList().size()>0){
			for(int i=0;i<newpage.getList().size();i++){
				String temp=(newpage.getList().get(i).getUrl()).substring(29);
				newpage.getList().get(i).setUrl(temp);
			}
		}
		else{}
		newpage.setPage(page.getPage());
		request.setAttribute("page", newpage);
		return "/agent/show_agent_contract_list";
	}
	
	//显示具体的合同信息
	@RequestMapping("showAgentDetails")
	public String showAgentDetails (HttpServletRequest request,Integer id,Model model){
		AgentContract agentContract=agentContractService.showDetails(id);
		String temp=agentContract.getUrl().substring(29);
		agentContract.setUrl(temp);
		model.addAttribute("agentContract", agentContract);
		return "/agent/show_agent_contract";
		
	}
	
	
	
	//经理查看所有合同列表
	@RequestMapping("showAgentContractListToManager")
	public String showAgentContractListToManager(HttpServletRequest request, Page<AgentContract> page, AgentContract agentContract) {
		String searchType = request.getParameter("searchType");
		String searchValue = request.getParameter("searchValue");
		request.setAttribute("searchType", searchType);
		request.setAttribute("searchValue", searchValue);
		if (searchType != null) {
			if ("name".equals(searchType)) {
				agentContract.setName(searchValue);
			} else {
				
			}
		}
		page.setParamEntity(agentContract);
		Page<AgentContract> newpage = agentContractService.findByPage(page);
		if(newpage.getList().size()>0){
			for(int i=0;i<newpage.getList().size();i++){
				String temp=(newpage.getList().get(i).getUrl()).substring(29);
				newpage.getList().get(i).setUrl(temp);
			}
		}
		else{}
		newpage.setPage(page.getPage());
		request.setAttribute("page", newpage);
		return "/agent/agent_contract_list_manager";
	}
	
	//经理查看具体的信息
	//显示具体的合同信息
		@RequestMapping("showAgentDetailsToManager")
		public String showAgentDetailsToManager (HttpServletRequest request,Integer id,Model model){
			AgentContract agentContract=agentContractService.showDetails(id);
			String temp=agentContract.getUrl().substring(29);
			agentContract.setUrl(temp);
			model.addAttribute("agentContract", agentContract);
			return "/agent/show_agent_contract_manager";
			
		}
	
	
	@RequestMapping("/downFile")  
	public void downFile(HttpServletRequest request,  
			        HttpServletResponse response,String filename) {  
			    // 得到要下载的文件名  
			    String fileName = filename.substring(11);
			    String date=filename.substring(0, 10);
			    try {  
			        fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");  
			        // 上传位置  
			        String fileSaveRootPath = "C:/HROA/upload/agentContract/"+date;   
			        // 得到要下载的文件  
			        File file = new File(fileSaveRootPath + "/" + fileName);  
			        // 如果文件不存在  
			        if (!file.exists()) {  
			            request.setAttribute("message", "您要下载的资源已被删除！！");  
			            System.out.println("您要下载的资源已被删除！！");  
			            return;  
			        }  
			        // 处理文件名  
			        String realname = fileName;
			        // 设置响应头，控制浏览器下载该文件  
			        response.setHeader("content-disposition", "attachment;filename="  
			                + URLEncoder.encode(realname, "UTF-8"));  
			        // 读取要下载的文件，保存到文件输入流  
			        FileInputStream in = new FileInputStream(fileSaveRootPath + "\\" + fileName);  
			        // 创建输出流  
			        OutputStream out = response.getOutputStream();  
			        // 创建缓冲区  
			        byte buffer[] = new byte[1024];  
			        int len = 0;  
			        // 循环将输入流中的内容读取到缓冲区当中  
			        while ((len = in.read(buffer)) > 0) {  
			            // 输出缓冲区的内容到浏览器，实现文件下载  
			            out.write(buffer, 0, len);  
			        }  
			        // 关闭文件输入流  
			        in.close();  
			        // 关闭输出流  
			        out.close();  
			    } catch (Exception e) {  
			  
			    }  
			}  
		
	
}
