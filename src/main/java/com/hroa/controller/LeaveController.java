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
import com.hroa.model.Leaveapply;
import com.hroa.service.LeaveService;
import com.hroa.util.LeaveUtil;

@Controller
@RequestMapping("/leave")
public class LeaveController extends BaseController{
	
	@Resource private LeaveService leaveservice;
	
	/**
	 * @time 2017/6/6
	 * @author chenhao
	 * 请假申请接口
	 */
	@RequestMapping("/addleave")
	public String addLeave(HttpServletRequest requesrt,Leaveapply leave,String start,String end,Model model) throws ParseException{
		if(leave!=null){
			leave=LeaveUtil.setValue(leave,start,end);
			leaveservice.addLeave(leave);
			model.addAttribute("result", "申请成功");
		}else{
			model.addAttribute("resulr", "申请失败,请联系管理员");
		}
		return "apply/admin_leave";
	}
	
	/**
	 * @time 2017/6/6
	 * @author chenhao
	 * 申请时自动填充信息接口
	 */
	@RequestMapping("/getleavep")
	public void getLeaveByhone(HttpServletRequest requesrt,HttpServletResponse response,String phone,Model model) throws IOException{
		PrintWriter out=response.getWriter();
		ObjectMapper object=new ObjectMapper();
		List<Leaveapply> leaves=leaveservice.getLeaveByPhone(phone);
		if(leaves.size()!=0){
			Leaveapply leave=leaves.get(leaves.size()-1);
			
			String result=object.writeValueAsString(leave);
			out.print(result);
		}else{
			out.print("");
		}
		if(out!=null){
			out.close();
		}
	}
	
	/**
	 * @time 2017/6/6
	 * @author chenhao
	 * 请假信息列表.name为空时,无条件获取列表；不为空时，按名字查找列表
	 */
	@RequestMapping("/getleave")
	public String getLeave(HttpServletRequest request,Model model,String name,int start) throws IOException{
		int power=1;//判断当前用户的权限数，1为上级；2为上上级
		 if("".equals(name)){
			 model=getLeaveByInt(request,model,name,start,power);
		 }else if("history".equals(name)){
			 model=getLeaveHistory(request,model,name,start,power);
		 }else{
			 model=getLeaveByName(request,model,name,start,power);
		 }
		 return "/apply/admin_leavelist";
	}
	
	
	public Model getLeaveByInt(HttpServletRequest request,Model model,String name,int start,int power) throws IOException{
		Map<String,Integer> map=new HashMap<String,Integer>();
		if(start!=0){
			int count=leaveservice.getLeaveCount(power);
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
				List<Leaveapply> leaves=leaveservice.getLeave(map);
				leaves=LeaveUtil.changeValue(leaves, power);
				model.addAttribute("count",count);
				model.addAttribute("leaves", leaves);
			}
		}else{
			model.addAttribute("count", -1);
		}
		model.addAttribute("name", name);
		return model;
	}
	
	public Model getLeaveByName(HttpServletRequest request,Model model,String name,int start,int power){
		Map<String,Object> map=new HashMap<String,Object>();
		if(start!=0){
			map.put("name", name);
			map.put("power", power);
			int count=leaveservice.getCountByname(map);
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
				List<Leaveapply> leaves=leaveservice.getLeaveByname(map);
				leaves=LeaveUtil.changeValue(leaves, power);
				model.addAttribute("count",count);
				model.addAttribute("leaves", leaves);
				model.addAttribute("name", name);
			}
		}else{
			model.addAttribute("count", -1);
			model.addAttribute("name", name);
		}
		return model;
	}
	
	public Model getLeaveHistory(HttpServletRequest request,Model model,String name,int start,int power) throws IOException{
		Map<String,Integer> map=new HashMap<String,Integer>();
		if(start!=0){
			int count=leaveservice.getHistoryCount(power);
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
				List<Leaveapply> leaves=leaveservice.getHistoryLeave(map);
				leaves=LeaveUtil.changeValue(leaves, power);
				model.addAttribute("count",count);
				model.addAttribute("leaves", leaves);
			}
		}else{
			model.addAttribute("count", -1);
		}
		model.addAttribute("name", name);
		return model;
	}
	
	/**
	 * @time 2017/6/6
	 * @author chenhao
	 * 请假审核接口.根据登陆人员的cookie或session判断他的权限数字总和，判断更改一次审核还是二次审核
	 * @throws IOException 
	 */
	@RequestMapping("/upleave")
	public void upLeave(HttpServletRequest request,HttpServletResponse response,String id,String result) throws IOException{
		PrintWriter out=response.getWriter();
		Leaveapply leave=new Leaveapply();
		int power=1;//判断当前用户的权限数，1为上级；2为上上级
		if(id!=null&&result!=null){
			if("success".equals(result)){
				leave.setId(id);
				if(power==1){
					leave.setFristcheck(1);
				}else if(power==2){
					leave.setSecondcheck(1);
				}
				leaveservice.upLeave(leave);
			}else if("fail".equals(result)){
				leave.setId(id);
				if(power==1){
					leave.setFristcheck(2);
				}else if(power==2){
					leave.setSecondcheck(2);
				}
				leaveservice.upLeave(leave);
			}else if("delete".equals(result)){
				leave.setId(id);
				leave.setResult(1);
				leaveservice.upLeave(leave);
			}
		}else{
			out.print("操作失败！");
		}
		if(out!=null){
			out.close();
		}
	}
}
