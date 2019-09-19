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

import com.hroa.model.Moneyapply;
import com.hroa.service.MoneyService;
import com.hroa.util.MoneyUtil;

@Controller
@RequestMapping("/money")
public class MoneyController extends BaseController {
	@Resource private MoneyService moneyservice;
	/**
	 * @time 2017/6/18
	 * @author chenhao
	 * 费用报销申请接口
	 */
	@RequestMapping("/addmoney")
	public String addmoney(HttpServletRequest requesrt,Moneyapply money,String time,String umoney,Model model) throws ParseException{
		if(money!=null){
			String vouchername="李四";//当前用户名
			money.setVouchername(vouchername);
			money=MoneyUtil.setValue(money,umoney,time);
			moneyservice.addmoney(money);
			model.addAttribute("result", "申请成功");
		}else{
			model.addAttribute("resulr", "申请失败,请联系管理员");
		}
		return "apply/admin_money";
	}
	
	/**
	 * @time 2017/6/20
	 * @author chenhao
	 * 费用报销审核接口.根据登陆人员的cookie或session判断他的权限数字，判断更改一次审核还是二次审核
	 * @throws IOException 
	 */
	@RequestMapping("/upmoney")
	public void upLeave(HttpServletRequest request,HttpServletResponse response,String id,String result) throws IOException{
		PrintWriter out=response.getWriter();
		Moneyapply money=new Moneyapply();
		int person=1;//判断当前用户，上级为1，上上级为2，财务为3
		String name="张华";//当前财务的名字
		if(id!=null&&result!=null){
			if("success".equals(result)){
				money.setId(id);
				if(person==1){
					money.setFristcheck(1);
				}else if(person==2){
					money.setSecondcheck(1);
				}else if(person==3){
					money.setAgreenname(name);
					money.setThirdcheck(1);
				}
				moneyservice.upMoney(money);
			}else if("fail".equals(result)){
				money.setId(id);
				if(person==1){
					money.setFristcheck(2);
				}else if(person==2){
					money.setSecondcheck(2);
				}else if(person==3){
					money.setAgreenname(name);
					money.setThirdcheck(2);
				}
				moneyservice.upMoney(money);
			}else if("delete".equals(result)){
				if(person==3){
					money.setAgreenname(name);
				}
				money.setId(id);
				money.setResult(1);
				moneyservice.upMoney(money);
			}
		}else{
			out.print("操作失败！");
		}
		if(out!=null){
			out.close();
		}
	}
	
	/**
	 * @time 2017/6/20
	 * @author chenhao
	 * 费用报销信息列表.name为空时,无条件获取列表；不为空时，按名字查找列表
	 */
	@RequestMapping("/getmoney")
	public String getLeave(HttpServletRequest request,Model model,String name,int start) throws IOException{
		int person=1;//判断当前用户，上级为1，上上级为2，财务为3
		 if("".equals(name)){
			 model=getLeaveByInt(request,model,name,start,person);
		 }else if("history".equals(name)){
			 model=getLeaveHistory(request,model,name,start,person);
		 }else{
			 model=getLeaveByName(request,model,name,start,person);
		 }
		 return "/apply/admin_moneylist";
	}
	
	
	public Model getLeaveByInt(HttpServletRequest request,Model model,String name,int start,int person) throws IOException{
		Map<String,Integer> map=new HashMap<String,Integer>();
		if(start!=0){
			int count=moneyservice.getMoneyCount(person);
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
				map.put("person", person);
				List<Moneyapply> moneys=moneyservice.getMoney(map);
				moneys=MoneyUtil.changeValue(moneys, person);
				model.addAttribute("count",count);
				model.addAttribute("moneys", moneys);
			}
		}else{
			model.addAttribute("count", -1);
		}
		model.addAttribute("name", name);
		return model;
	}
	
	public Model getLeaveByName(HttpServletRequest request,Model model,String name,int start,int person){
		Map<String,Object> map=new HashMap<String,Object>();
		if(start!=0){
			map.put("name", name);
			map.put("person", person);
			int count=moneyservice.getCountByname(map);
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
				List<Moneyapply> moneys=moneyservice.getMoneyByname(map);
				moneys=MoneyUtil.changeValue(moneys, person);
				model.addAttribute("count",count);
				model.addAttribute("moneys", moneys);
				model.addAttribute("name", name);
			}
		}else{
			model.addAttribute("count", -1);
			model.addAttribute("name", name);
		}
		model.addAttribute("name", name);
		return model;
	}
	
	public Model getLeaveHistory(HttpServletRequest request,Model model,String name,int start,int person) throws IOException{
		Map<String,Integer> map=new HashMap<String,Integer>();
		if(start!=0){
			int count=moneyservice.getHistoryCount(person);
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
				map.put("person", person);
				List<Moneyapply> moneys=moneyservice.getHistoryMoney(map);
				moneys=MoneyUtil.changeValue(moneys, person);
				model.addAttribute("count",count);
				model.addAttribute("moneys", moneys);
			}
		}else{
			model.addAttribute("count", -1);
		}
		model.addAttribute("name", name);
		return model;
	}
}
