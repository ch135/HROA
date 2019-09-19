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
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hroa.model.Borrow;
import com.hroa.service.BorrowService;
import com.hroa.util.BorrowUtil;


//借资申请管理
@Controller
@RequestMapping("/borrow")
public class BorrowController extends BaseController{
	
	@Resource
	private BorrowService borrowService;
	
	//借资申请接口
	@RequestMapping("/addBorrow")
	public String addBorrow(HttpServletRequest request,Borrow borrow,String apply,String back,Model model) throws ParseException{
		
		if(borrow != null){
			borrow = BorrowUtil.setValue(borrow, apply, back);
			borrow.setUserrepay(0);
			borrowService.addBorrow(borrow);
			model.addAttribute("result", "申请成功");
		}else{
			model.addAttribute("result", "申请失败，请联系管理员");
		}
		return "apply/admin_borrow";
		
	}
	
	//借资申请列表
	@RequestMapping("/getborrow")
	public String getBorrow(HttpServletRequest request,Model model,String name,int start){
		 int power=1;//判断当前用户的权限数，1为上级；2为更上级
		 if("".equals(name)){
			 model=getBorrowByInt(request,model,name,start,power);
		 }else if("history".equals(name)){
			 model=getBorrowHistory(request,model,name,start,power);
		 }else{
			 model=getBorrowByName(request,model,name,start,power);
		 }
		 return "/apply/admin_borrowlist";
	}
	
	//通过页数查找
	public Model getBorrowByInt(HttpServletRequest request,Model model,String name,int start,int power){
		Map<String,Integer> map=new HashMap<String,Integer>();
		if(start!=0){
			int count=borrowService.getBorrowCount(power);
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
				map.put("power", power);
				List<Borrow> borrows=borrowService.getBorrow(map);
				borrows=BorrowUtil.changeValue(borrows, power);
				model.addAttribute("count",count);
				model.addAttribute("borrows", borrows);
			}
		}
		
		return model;
	}
	
	//返回历史记录
	public Model getBorrowHistory(HttpServletRequest request,Model model,String name,int start,int power){
		
		Map<String,Integer> map=new HashMap<String,Integer>();
		if(start!=0){
			int count=borrowService.getHistoryCount(power);
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
				map.put("power", power);
				List<Borrow> borrows=borrowService.getHistoryBorrow(map);
				borrows=BorrowUtil.changeValue(borrows, power);
				model.addAttribute("count",count);
				model.addAttribute("borrows", borrows);
			}
		}else{
			model.addAttribute("count", -1);
		}
		model.addAttribute("name", name);
		return model;
	
	}
	
	//通过名字查找
	public Model getBorrowByName(HttpServletRequest request,Model model,String name,int start,int power){
		Map<String,Object> map=new HashMap<String,Object>();
		if(start!=0){
			map.put("name", name);
			map.put("power", power);
			int count=borrowService.getCountByname(map);
			model.addAttribute("allcount",count);
			map.clear();
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
				map.put("power", power);
				List<Borrow> borrows=borrowService.getBorrowByname(map);
				borrows=BorrowUtil.changeValue(borrows, power);
				model.addAttribute("count",count);
				model.addAttribute("borrows", borrows);
				model.addAttribute("name", name);
			}
		}else{
			model.addAttribute("count", -1);
			model.addAttribute("name", name);
		}
		System.out.println("successsssssssssssss");
		return model;
	}
	
	//申请时自动填充信息接口
	@RequestMapping("/getborrowph")
	public void getBorrowByphone(HttpServletRequest request,HttpServletResponse response,String phone,Model model) throws IOException{
		PrintWriter out=response.getWriter();
		ObjectMapper object=new ObjectMapper();
		List<Borrow> borrows=borrowService.getBorrowByPhone(phone);
		if(borrows.size()!=0){
			Borrow borrow=borrows.get(borrows.size()-1);
			
			String result=object.writeValueAsString(borrow);
			out.print(result);
		}else{
			out.print("");
		}
		if(out!=null){
			out.close();
		}
	}
	
	//借资审核接口.根据登陆人员的cookie或session判断他的权限数字总和，判断更改一次审核还是二次审核
	@RequestMapping("/changeborrow")
	public void changeBorrow(HttpServletRequest request,HttpServletResponse response,String id,String result) throws IOException{
		PrintWriter out=response.getWriter();
		Borrow borrow=new Borrow();
		int power=1;//判断当前用户的权限数，1为上级；2为更上一级
		if(id!=null&&result!=null){
			if("success".equals(result)){
				borrow.setId(id);
				if(power==1){
					borrow.setFirstcheck(1);
				}else if(power==2){
					borrow.setSecondcheck(1);
				}
				borrowService.changeBorrow(borrow);
			}else if("fail".equals(result)){
				borrow.setId(id);
				if(power==1){
					borrow.setFirstcheck(2);
				}else if(power==2){
					borrow.setSecondcheck(2);
				}
				borrowService.changeBorrow(borrow);
			}else if("delete".equals(result)){
				borrow.setId(id);
				borrow.setResult(1);
				borrowService.changeBorrow(borrow);
			}
		}else{
			out.print("操作失败！");
		}
		if(out!=null){
			out.close();
		}
	}
	
//	@RequestMapping("/test")
//	public void test() throws ParseException{
//		Borrow borrow = new Borrow();
//		borrow.setName("晓文浩");
//		borrow.setPhone("13794589483");
//		String applytime = "2017-06-22";
//		String backtime = "2017-06-26";
//		borrow = BorrowUtil.setValue(borrow, applytime, backtime);
//		borrow.setUserrepay(0);
//		int result = borrowService.addBorrow(borrow);
//		System.out.println(result);
//	}

}
