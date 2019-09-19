package com.hroa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hroa.model.UserSign;
import com.hroa.service.UserSignService;
import com.hroa.util.UserSignUtil;

/**
 * @author chenhao
 * @date 2017/6/21 23:28
 * @see 用户签到可控制器
 */
@Controller
@RequestMapping("/sign")
public class UserSignController {
	
	@Resource private UserSignService signservice;
	/**添加签到记录 
	 * @throws ParseException 
	 * @throws IOException 
	 */
	@RequestMapping("/addsign")
	public void addSign(HttpServletRequest request,HttpServletResponse response,Model model,String area) throws ParseException, IOException{
		PrintWriter out=response.getWriter();
		String userid="";//登录用户的id
		Date day=UserSignUtil.getDate();
		UserSign us=signservice.getSign(day,userid);
		if(null!=us){
			if(null==us.getArea()){
				us.setArea(area);
				us.setSigntime(UserSignUtil.getTime());
				signservice.upUserSIgn(us);
				out.print("签到成功");
			}else{
				out.print("你今天已签到！");
			}
		}else{
			System.out.println("quartz 出错");
			out.println("系统出错，请重新尝试");
		}
		
		if(out!=null){
			out.close();
		}
	}
	/**
	 * webapp地址传输测试方法
	 */
	@RequestMapping("/text")
	public void text(HttpServletRequest request,Model model,String phone,String time,String area){
		System.out.println("测试位置"+phone+"  "+time+"  "+"  "+area);
	}
	
	public static boolean AddUserDate(){
		//添加所有用户的信息
		return true;
	}
}
