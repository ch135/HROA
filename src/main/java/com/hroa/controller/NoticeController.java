package com.hroa.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hroa.model.AdminModel;
import com.hroa.model.NoticeModel;
import com.hroa.service.NoticeService;
import com.hroa.util.CalcPageUtils;
import com.hroa.util.DateUtils;
import com.hroa.util.dateUtil;
@Controller
@RequestMapping("notice")
public class NoticeController {
	private static Logger logger = Logger.getLogger("NoticeController");   
	@Resource
	NoticeService noticeService;
	/**
	 * author qwc
	 * 2017年6月27日下午6:33:01
	 * 添加公告
	 * @throws IOException 
	 */
	@RequestMapping("addNotice")
	public void addNotice(@ModelAttribute AdminModel lgInfoModel,HttpSession session,HttpServletResponse response,HttpServletRequest request,@ModelAttribute NoticeModel noticeModel) throws IOException{
		String noticeTitle=request.getParameter("noticeTitle");
		String noticeTxt=request.getParameter("noticeTxt");
		logger.info("noticeTxt:"+noticeTxt);
		int addStatus=0;
		PrintWriter out=response.getWriter();
		ObjectMapper mapper = new ObjectMapper(); 
	    ObjectNode addJson = mapper.createObjectNode();
	    lgInfoModel=(AdminModel) session.getAttribute("adminLgSession");
	    noticeModel.setTitle(noticeTitle);
		noticeModel.setTxt(noticeTxt);
		noticeModel.setAdduser( lgInfoModel.getNickname());
		noticeModel.setAddtime(DateUtils.dateToStr(new Date(),DateUtils.DATE_TIME_LINE ));//添加时间
		addStatus=noticeService.addNotice(noticeModel);
		if(addStatus>0){//添加成功
			addJson.put("status", 1);
			out.write(addJson.toString());
		}else{//添加失败
			addJson.put("status", 0);
			out.write(addJson.toString());
		}
	}
	
	/**
	 * author qwc
	 * 2017年6月28日上午10:20:03
	 * @return
	 * 分页获取公告信息
	 */
	@RequestMapping("gtNtList") 
	public ModelAndView getNoticeList(HttpServletRequest request){
		ModelAndView gtNtListModelAndView=new ModelAndView();
		List<NoticeModel> gtNtList = new ArrayList<NoticeModel>();
		String stPg=request.getParameter("startPage");
		String pgSz=request.getParameter("pageSize");
		int amount=0;
		int totalPage=0;
		int startPage=Integer.parseInt(stPg);
		int pageSize=Integer.parseInt(pgSz);
		amount=noticeService.getNtAmount();
		gtNtList=noticeService.gtNtByPage((startPage-1)*pageSize, pageSize);
		totalPage=CalcPageUtils.totalPage(pageSize,amount);//总页数
		logger.info("totalPage:"+totalPage);
		gtNtListModelAndView.addObject("ntList", gtNtList);
		gtNtListModelAndView.addObject("currentPage", stPg);
		gtNtListModelAndView.addObject("perPageAmount", gtNtList.size());
		gtNtListModelAndView.addObject("totalPage", totalPage);
		gtNtListModelAndView.setViewName("notice/list");
		return gtNtListModelAndView;
	} 
	
	/**
	 * author qwc
	 * 2017年6月28日下午1:19:17
	 * 根据公告Id获取公告信息
	 * @throws IOException 
	 */
	@RequestMapping("gtNtInfoById")
	public void gtNtInfoById(@ModelAttribute NoticeModel noticeInfoModel,HttpServletResponse response,HttpServletRequest request) throws IOException{
		String noticeId=request.getParameter("noticeId");
		PrintWriter out=response.getWriter();
		ObjectMapper mapper = new ObjectMapper(); 
	    ObjectNode ntInfoJson = mapper.createObjectNode();
		noticeInfoModel=noticeService.gtNtInfoById(Integer.parseInt(noticeId));
		if(noticeInfoModel!=null){
			ntInfoJson.put("status",1);//成功获取
			ntInfoJson.put("title",noticeInfoModel.getTitle());//公告标题
			ntInfoJson.put("centent",noticeInfoModel.getTxt());//公告内容
			out.write(ntInfoJson.toString());
		}else{
			ntInfoJson.put("status",0);
			out.write(ntInfoJson.toString());
		}
	}
	
	/**
	 * author qwc
	 * 2017年6月27日下午3:19:50
	 * @param response
	 * @param mrequest
	 * @param request
	 * @param files
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 * layer组件上传图片返回json数据
	 */
	@RequestMapping("upImg")
	public String addNoPic(HttpServletResponse response,MultipartRequest mrequest,MultipartFile items) throws IllegalStateException, IOException{
		HashMap<String,Object> uploadJson=new HashMap<String,Object>();
		HashMap<String,Object> uploadData=new HashMap<String,Object>();
		String url=uploadFile(mrequest);
		PrintWriter out=response.getWriter();
		if(url!=null&&url!="end"){
			uploadData.put("src",url);
			uploadJson.put("code", 0);//图片上传成功
			uploadJson.put("msg", "图片上传成功！");
			uploadJson.put("data", uploadData);
			JSONObject json = JSONObject.fromObject(uploadJson);
			out.write(json.toString());
		}else{
			uploadData.put("src",url);
			uploadJson.put("code", 1);//图片上传成功
			uploadJson.put("msg", "图片上传失败！");
			uploadJson.put("data", uploadData);
			JSONObject json = JSONObject.fromObject(uploadJson);
			out.write(json.toString());
		}
		return null;
	}
	
	/**
	 * author qwc
	 * 2017年6月28日下午5:13:51
	 * @param mrequest
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 * 图片保存方法
	 */
	public static String uploadFile(MultipartRequest mrequest) throws IllegalStateException, IOException{
		Date date = dateUtil.currentDate();
		String path = "C:/HROA/upload/noticeImg/"+date;
		File dir = new File(path);
		if(!dir.exists()){
			dir.mkdirs();
		}
		Map<String, MultipartFile> files=mrequest.getFileMap();
		if(files!=null){
			String url=null;
			for (MultipartFile file : files.values()) {
				//原始名称
				String name = file.getOriginalFilename();
				System.out.println("图片名称："+name);
				if(name.endsWith(".jpg")||name.endsWith(".png")||name.endsWith(".gif")||name.endsWith(".JPG")
						||name.endsWith(".PNG")||name.endsWith(".GIF")){
					//新的名称，由随机码和文件后缀拼接而成
					String newName =  UUID.randomUUID() + name.substring(name.lastIndexOf("."));
					File targetfile  = new File(path,newName);
					//文件上传
					file.transferTo(targetfile);
					url  = "/HROA/upload/noticeImg/"+date+"/"+newName;
				}
			}
			return url;
		}else{
			return null;
		}
	}
}