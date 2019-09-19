package com.hroa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hroa.model.Tripapply;
import com.hroa.service.TripService;
import com.hroa.util.TripUtil;


@Controller
@RequestMapping("/trip")
public class TripController extends BaseController{

	@ExceptionHandler
	public String exception(HttpServletRequest request, Exception e) { 
		return "/admin-404";
	}
@Resource private TripService tripService;

	/**
	 * @time 2017/6/15
	 * @author chenhao
	 * 出差申请接口
	 */
	@RequestMapping("/addtrip")
	public String addtrip(HttpServletRequest requesrt,Tripapply trip,String start,String end,Model model) throws ParseException{
		if(trip!=null){
			trip=TripUtil.setValue(trip,start,end);
			tripService.addTrip(trip);
			model.addAttribute("result", "申请成功");
		}else{
			model.addAttribute("resulr", "申请失败,请联系管理员");
		}
		return "apply/admin_trip";
	}
	
	/**
	 * @time 2017/6/15
	 * @author chenhao
	 * 申请时自动填充信息接口
	 */
	@RequestMapping("/gettripByphone")
	public void gettripByhone(HttpServletRequest requesrt,HttpServletResponse response,String phone,Model model) throws IOException{
		PrintWriter out=response.getWriter();
		ObjectMapper object=new ObjectMapper();
		List<Tripapply> trips=tripService.getTripByPhone(phone);
		if(trips.size()!=0){
			Tripapply trip=trips.get(trips.size()-1);
			String result=object.writeValueAsString(trip);
			out.print(result);
		}else{
			out.print("");
		}
		if(out!=null){
			out.close();
		}
	}
	
	/**
	 * @time 2017/6/15
	 * @author chenhao
	 * @throws IOException 
	 */
	@RequestMapping("/uptrip")
	public void uptrip(HttpServletRequest request,HttpServletResponse response,String id,String result) throws IOException{
		PrintWriter out=response.getWriter();
		Tripapply trip=new Tripapply();
		if(id!=null&&result!=null){
			if("success".equals(result)){
				trip.setId(id);
				trip.setFristcheck(1);
				tripService.upTrip(trip);
			}else if("fail".equals(result)){
				trip.setId(id);
				trip.setFristcheck(2);
				tripService.upTrip(trip);
			}else if("delete".equals(result)){
				trip.setId(id);
				trip.setResult(1);
				tripService.upTrip(trip);
			}
		}else{
			out.print("操作失败！");
		}
		if(out!=null){
			out.close();
		}
	}
	
	/**
	 * @time 2017/6/6
	 * @author chenhao
	 * 原理：（1）列表->fristcheck=0 result!=1
	 * 		 （2）历史纪录->fristcheck!=0 result!=1
	 * 		 (3)名字搜索->fristcheck=0 result!=1
	 * 
	 */
	@RequestMapping("/gettrip")
	public String getTrip(HttpServletRequest request,Model model,String name,int start) throws IOException{
		 if("".equals(name)){
			 model=getTripByInt(request,model,name,start);
		 }else if("history".equals(name)){
			 model=getTripHistory(request,model,name,start);
		 }else{
			 model=getTripByName(request,model,name,start);
		 }
		 return "/apply/admin_triplist";
	}
	
	
	public Model getTripByInt(HttpServletRequest request,Model model,String name,int start) throws IOException{
		Map<String,Integer> map=new HashMap<String,Integer>();
		if(start!=0){
			int count=tripService.getTripCount();
			model.addAttribute("allcount",count);
			if(count==0){
				model.addAttribute("count", 0);
			}else{
				if(count%10!=0){
					count=count/10+1;
				}else{
					count=count/10;
				}
				map.put("start", (start-1)*10);
				map.put("pagesize", 10);
				List<Tripapply> trips=tripService.getTrip(map);
				model.addAttribute("count",count);
				model.addAttribute("trips", trips);
			}
		}else{
			model.addAttribute("count", -1);
		}
		model.addAttribute("name", name);
		return model;
	}
	
	public Model getTripByName(HttpServletRequest request,Model model,String name,int start){
		Map<String,Object> map=new HashMap<String,Object>();
		if(start!=0){
			int count=tripService.getCountByname(name);
			model.addAttribute("allcount",count);
			if(count==0){
				model.addAttribute("count", 0);
			}else{
				if(count%10!=0){
					count=count/10+1;
				}else{
					count=count/10;
				}
				map.put("start", (start-1)*10);
				map.put("pagesize", 10);
				map.put("name", name);
				List<Tripapply> trips=tripService.getTripByname(map);
				model.addAttribute("count",count);
				model.addAttribute("trips", trips);
			}
		}else{
			model.addAttribute("count", -1);
		}
		model.addAttribute("name", name);
		return model;
	}
	
	public Model getTripHistory(HttpServletRequest request,Model model,String name,int start) throws IOException{
		Map<String,Integer> map=new HashMap<String,Integer>();
		if(start!=0){
			int count=tripService.getHistoryCount();
			model.addAttribute("allcount",count);
			if(count==0){
				model.addAttribute("count", 0);
			}else{
				if(count%10!=0){
					count=count/10+1;
				}else{
					count=count/10;
				}
				map.put("start", (start-1)*10);
				map.put("pagesize", 10);
				List<Tripapply> trips=tripService.getHistoryTrip(map);
				model.addAttribute("count",count);
				model.addAttribute("trips", trips);
			}
		}else{
			model.addAttribute("count", -1);
		}
		model.addAttribute("name", name);
		return model;
	}
}
