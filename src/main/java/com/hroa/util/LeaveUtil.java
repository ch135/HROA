package com.hroa.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.hroa.model.Leaveapply;

/**
 * @author chenhao
 * @since 请假处理工具类
 * @date 2017/6/4 16:08
 */
public class LeaveUtil {

	public static Leaveapply setValue(Leaveapply leave,String start,String end) throws ParseException{
		if(leave!=null){
			SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
			Random ra=new Random();
			String date=sm.format(new Date().getTime());
			leave.setId("QT"+date.replace("-", "")+ra.nextInt(10000));
			leave.setApplytime(sm.parse(date));
			leave.setStarttime(sm.parse(start));
			leave.setEndtime(sm.parse(end));
		}
		return leave;
	}
	
	public static List<Leaveapply> changeValue(List<Leaveapply> leaves,int power){
		List<Leaveapply> leave=new ArrayList<Leaveapply>();
		if(power==1){
			for(Leaveapply le:leaves){
				le.setSecondcheck(3);
				leave.add(le);
			}
		}else if(power==2){
			for(Leaveapply le:leaves){
				le.setFristcheck(3);
				leave.add(le);
			}
		}
		return leave;
	}
}
