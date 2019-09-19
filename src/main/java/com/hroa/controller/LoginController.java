package com.hroa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hroa.model.AdminModel;
import com.hroa.service.LoginService;
import com.hroa.util.StringMD5;
import com.hroa.util.StringSplitUtils;
@Controller
@RequestMapping("lg")
public class LoginController{
	private static Logger logger = Logger.getLogger("LoginController"); 
	@Resource
	LoginService lgService;
	/**
	 * author qwc
	 * 2017年6月13日下午8:58:32
	 * @param lgModle
	 * 用户登录
	 */
	@RequestMapping("userlg")
	public void login(@ModelAttribute AdminModel lgModel,HttpServletRequest request,HttpSession session,HttpServletResponse response){
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		JSONArray pwJsonArray = new JSONArray();
		Map<String,String> userPowerMap = new HashMap<String,String>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<AdminModel> lgInfoList = new ArrayList<AdminModel>();
		String pwString=null;
		String[] powerArray=null;//权限数组
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectMapper mapper = new ObjectMapper(); 
	    ObjectNode lgJson = mapper.createObjectNode();
		password=StringMD5.MD5Digest(password);
		lgModel=lgService.login(account, password);
		if(lgModel!=null){
			lgModel.setPassword(null);//密码置空
			session.setAttribute("adminLgSession",lgModel);//用户登录信息到session中
			lgInfoList.add(lgModel);
        	JSONObject lgModelJson = JSONObject.fromObject(lgModel);
        	pwJsonArray=(JSONArray) lgModelJson.get("roleInfoList");//获取用户角色信息
        	logger.info("登录信息："+lgModelJson.toString());
        	logger.info("权限串："+JSONObject.fromObject(pwJsonArray.get(0)).get("role_powers"));
        	pwString=(String) JSONObject.fromObject(pwJsonArray.get(0)).get("role_powers");
        	powerArray=StringSplitUtils.split(pwString);//获取用户的权限，转换成权限数组
	        int length=powerArray.length;
	        for(int i=0;i<length;i++){
	        	logger.info("权限数组的值："+powerArray[i]+"\n");
	        	userPowerMap.put(powerArray[i],powerArray[i]);//保存到userPowerMap集合中
	        }
	        session.setAttribute("userPowerMap",userPowerMap);/*保存用户权限集合到session中，名为userPowerMap*/
	        logger.info("用户权限集合："+userPowerMap.toString());
	        dataMap.put("lgstatus", "1");//登录成功
        	dataMap.put("lgInfo", lgInfoList);
        	JSONObject lgjson = JSONObject.fromObject(dataMap);
        	out.write(lgjson.toString());
		}else{
			lgJson.put("lgstatus", "0");//登录失败
        	out.write(lgJson.toString());
		}
	}
	
	/**
	 * author qwc
	 * 2017年7月1日下午4:08:54
	 * @param session
	 * @return
	 * 退出登录
	 */
	@RequestMapping("exit")
	public String exitlogin(HttpSession session){
		session.invalidate();
		return "login";
	}
}
