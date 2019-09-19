package com.hroa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hroa.model.Lang;
import com.hroa.service.BorrowService;
import com.hroa.service.LeaveService;
import com.hroa.service.MoneyService;
import com.hroa.service.TripService;
/**
 * @author chenhao
 * @time 2017/6/29
 * 菜单栏信息推送
 */
@Controller
@RequestMapping("/num")
public class LangController {
	
	@Resource private LeaveService leaveservice;
	@Resource private TripService tripService;
	@Resource private MoneyService moneyservice;
	@Resource private BorrowService borrowService;
	
	@RequestMapping("/getnum")
	public @ResponseBody Lang getNum(HttpServletRequest request,HttpServletResponse esponse) throws ParseException{
		int power=1;//判断当前用户的权限数，1为上级；2为上上级;3为财务
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("power", power);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(new Date().getTime());
		Date day=sdf.parse(date);
		map.put("day", day);
		Lang lang=new Lang();
		lang.setLeavenum(leaveservice.getDayNum(map));
		lang.setTripnum(tripService.getDayNum(map));
		lang.setMoneynum(moneyservice.getDayNum(map));
		lang.setBorrownum(borrowService.getDayNum(map));
		return lang;
	}
}
