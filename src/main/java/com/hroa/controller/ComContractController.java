package com.hroa.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hroa.model.AgentContract;
import com.hroa.model.ComContract;
import com.hroa.service.ComContractService;
import com.hroa.util.DateFormat;
import com.hroa.util.Page;
import com.hroa.util.SerialUtil;

@Controller
@RequestMapping("ComContract")
public class ComContractController {
	@Resource ComContractService comContractService;
	//添加企业合同
	@RequestMapping("add")
	public String add(HttpServletRequest request,Page<ComContract> page,ComContract comContract) throws IllegalStateException, IOException{
		int cId=Integer.parseInt(request.getParameter("cId"));
		System.out.println(cId);
		String cName= request.getParameter("cName");
		String officeHolder=request.getParameter("officeHolder");
		int officeId=Integer.parseInt(request.getParameter("officeId"));
		String officePhone=request.getParameter("officePhone");
		String cDate=request.getParameter("cDate");//签订日期
		String temp=cDate.substring(0, 4)+cDate.substring(5, 7)+cDate.substring(8,10);
		String contractCode = "QHT" + temp+SerialUtil.serial4();
		String url= contractCode;
		
		if (request instanceof MultipartHttpServletRequest) {
		MultipartFile items =  ((MultipartHttpServletRequest) request).getFile("comContract");
		DateFormat dateFormat = new DateFormat();
		String date = dateFormat.format(new Date());
		String path = "C:/HROA/upload/comContract/"+date;
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
				String url1  = "C:/HROA/upload/comContract/"+date+"/"+newName;
				comContract.setcId(cId);
				comContract.setCname(cName);
				comContract.setWriter(officeHolder);
				comContract.setPhone(officePhone);
				comContract.setSignDate(cDate);
				comContract.setContractCode(contractCode);
				comContract.setUrl(url1);
				comContract.setWriterId(officeId);
				
				Boolean type = comContractService.addComContract(comContract);
				if(type==true){
				return "redirect:/ComContract/showComContractList.html";
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
	
	//编辑企业合同

	//编辑代理合同
	@RequestMapping("edit")
	public String edit(HttpServletRequest request,ComContract comContract) throws IllegalStateException, IOException{
		int id=Integer.parseInt(request.getParameter("id"));
		int cId=Integer.parseInt(request.getParameter("cId"));
		System.out.println(cId);
		String cName= request.getParameter("cName");
		String officeHolder=request.getParameter("officeHolder");
		int officeId=Integer.parseInt(request.getParameter("officeId"));
		String officePhone=request.getParameter("officePhone");
		String cDate=request.getParameter("cDate");//签订日期
		String temp=cDate.substring(0, 4)+cDate.substring(5, 7)+cDate.substring(8,10);
		String contractCode = "QHT" + temp+SerialUtil.serial4();
		String url= contractCode;
		
		if (request instanceof MultipartHttpServletRequest) {
		MultipartFile items =  ((MultipartHttpServletRequest) request).getFile("comContract");
		DateFormat dateFormat = new DateFormat();
		String date = dateFormat.format(new Date());
		String path = "C:/HROA/upload/comContract/"+date;
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
				String url1  = "C:/HROA/upload/comContract/"+date+"/"+newName;
				comContract.setcId(cId);
				comContract.setCname(cName);
				comContract.setWriter(officeHolder);
				comContract.setPhone(officePhone);
				comContract.setSignDate(cDate);
				comContract.setContractCode(contractCode);
				comContract.setUrl(url1);
				comContract.setId(id);
				comContract.setWriterId(officeId);
				
				Boolean type = comContractService.editComContract(comContract);
				if(type==true){
				return "redirect:/ComContract/showComContractList.html";
				}
				else
				{
					return "/index";
				}
				
			}else{
				
				
			}
		}
		else{
			comContract.setcId(cId);
			comContract.setCname(cName);
			comContract.setWriter(officeHolder);
			comContract.setPhone(officePhone);
			comContract.setSignDate(cDate);
			comContract.setId(id);
			comContract.setContractCode(contractCode);
			comContract.setWriterId(officeId);
			
			Boolean type = comContractService.editComContract(comContract);
			if(type==true){
			return "redirect:/ComContract/showComContractList.html";
			}
			else
			{
				return "/index";
			}
		}
		
		}
		
		comContract.setcId(cId);
		comContract.setCname(cName);
		comContract.setWriter(officeHolder);
		comContract.setPhone(officePhone);
		comContract.setSignDate(cDate);
		comContract.setId(id);
		comContract.setContractCode(contractCode);
		comContract.setWriterId(officeId);
		
		Boolean type = comContractService.editComContract(comContract);
		if(type==true){
		return "redirect:/ComContract/showComContractList.html";
		}
		else
		{
			return "/index";
		}
	}

	
	@RequestMapping("showComContractList")
	public String showComContractList(HttpServletRequest request, Page<ComContract> page, ComContract comContract) {
		String searchType = request.getParameter("searchType");
		String searchValue = request.getParameter("searchValue");
		request.setAttribute("searchType", searchType);
		request.setAttribute("searchValue", searchValue);
		if (searchType != null) {
			if ("cname".equals(searchType)) {
				comContract.setCname(searchValue);
			} else {
				
			}
		}
		page.setParamEntity(comContract);
		Page<ComContract> newpage = comContractService.findByPage(page);
		if(newpage.getList().size()>0){
			for(int i=0;i<newpage.getList().size();i++){
				String temp=(newpage.getList().get(i).getUrl()).substring(27);
				newpage.getList().get(i).setUrl(temp);
			}
		}
		else{}
		
		newpage.setPage(page.getPage());
		request.setAttribute("page", newpage);
		return "/company/company_contract_list";
	}
	
	//删除企业合同
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Page<ComContract> page, ComContract comContract){
/*		agentContract.setId(1);
*/
		System.out.println(comContract.getId());
		comContract.setId(comContract.getId());
		comContract.setState(0);
		Boolean type = comContractService.deleteComContract(comContract);
		if(type==true){
			System.out.println("删除成功");
		return showComContractList(request, page, comContract);
		}
		else
		{
			return "/index";
		}
    }
	
	
	//查看具体的企业合同信息
	//显示具体的合同信息
		@RequestMapping("showDetails")
		public String showDetails (HttpServletRequest request,Integer id,Model model){
			ComContract comContract=comContractService.showDetails(id);
			model.addAttribute("comContract", comContract);
			return "/company/company_contract_edit";
			
		}
		
   //

		
		@RequestMapping("showComContractListToCom")
		public String showComContractListToCom(HttpServletRequest request, Page<ComContract> page, ComContract comContract) {
			String searchType = request.getParameter("searchType");
			String searchValue = request.getParameter("searchValue");
			request.setAttribute("searchType", searchType);
			request.setAttribute("searchValue", searchValue);
			if (searchType != null) {
				if ("cname".equals(searchType)) {
					comContract.setCname(searchValue);
				} else {
					
				}
			}
			comContract.setcId(1);//此处应该为获取保存在session中的企业id
			page.setParamEntity(comContract);
			Page<ComContract> newpage = comContractService.findByPageToCom(page);
			if(newpage.getList().size()>0){
				for(int i=0;i<newpage.getList().size();i++){
					String temp=(newpage.getList().get(i).getUrl()).substring(27);
					newpage.getList().get(i).setUrl(temp);
				}
			}
			else{}
			newpage.setPage(page.getPage());
			request.setAttribute("page", newpage);
			return "/company/show_company_contract_list";
		}
	
		//显示具体的合同信息
	@RequestMapping("showComDetails")
	  public String showComDetails (HttpServletRequest request,Integer id,Model model){
			ComContract comContract=comContractService.showDetails(id);
			String temp=comContract.getUrl().substring(27);
			comContract.setUrl(temp);
			model.addAttribute("comContract", comContract);
			return "/company/show_company_contract";
					
		}
				
				
		//经理查看查看企业合同记录
	@RequestMapping("showComContractListToManager")
	public String showComContractListToManager(HttpServletRequest request, Page<ComContract> page, ComContract comContract) {
		String searchType = request.getParameter("searchType");
		String searchValue = request.getParameter("searchValue");
		request.setAttribute("searchType", searchType);
		request.setAttribute("searchValue", searchValue);
		if (searchType != null) {
			if ("cname".equals(searchType)) {
				comContract.setCname(searchValue);
			} else {
				
			}
		}
		page.setParamEntity(comContract);
		Page<ComContract> newpage = comContractService.findByPage(page);
		if(newpage.getList().size()>0){
			for(int i=0;i<newpage.getList().size();i++){
				String temp=(newpage.getList().get(i).getUrl()).substring(27);
				newpage.getList().get(i).setUrl(temp);
			}
		}
		else{}
		
		newpage.setPage(page.getPage());
		request.setAttribute("page", newpage);
		return "/company/company_contract_list_manager";
	}
		
	//显示具体的合同信息
	@RequestMapping("showComDetailsToManager")
	  public String showComDetailsToManager (HttpServletRequest request,Integer id,Model model){
			ComContract comContract=comContractService.showDetails(id);
			String temp=comContract.getUrl().substring(27);
			comContract.setUrl(temp);
			model.addAttribute("comContract", comContract);
			return "/company/show_company_contract_manager";
					
		}

		@RequestMapping("/downFile")  
		public void downFile(HttpServletRequest request,  
				        HttpServletResponse response,String filename) {  
				    System.out.println("1");  
				    // 得到要下载的文件名  
				    String fileName = filename.substring(11);
				    String date=filename.substring(0, 10);
				    System.out.println(date);
				    System.out.println(fileName);
				    System.out.println("2");  
				    try {  
				        fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");  
				        System.out.println("3");  
				        // 获取上传文件的目录  
				        ServletContext sc = request.getSession().getServletContext();  
				        System.out.println("4");  
				        // 上传位置  
				        String fileSaveRootPath = "C:/HROA/upload/comContract/"+date;   
				          
				        System.out.println(fileSaveRootPath + "/" + fileName);  
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
