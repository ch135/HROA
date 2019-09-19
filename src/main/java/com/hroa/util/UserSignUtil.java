package com.hroa.util;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chenhao
 * @time 2017/6/21 23:40
 * 用户签到工具表
 */
public class UserSignUtil {
	
	//获取当前日期
	public static Date getDate() throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(new Date().getTime());
		return sdf.parse(date);
	}
	
	//获取当前时间
	public static Time getTime(){
		SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
		String time=sdf.format(new Date().getTime());
		return Time.valueOf(time);
	}
}
