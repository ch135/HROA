package com.hroa.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.hroa.model.Tripapply;

/**
 * @author chenhao
 * @since 出差处理工具类
 * @date 2017/6/15 20:16
 */

public class TripUtil {
	public static Tripapply setValue(Tripapply trip,String start,String end) throws ParseException{
		if(trip!=null){
			SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
			Random ra=new Random();
			String date=sm.format(new Date().getTime());
			trip.setId("CC"+date.replace("-", "")+ra.nextInt(10000));
			trip.setApplytime(sm.parse(date));
			trip.setStarttime(sm.parse(start));
			trip.setEndtime(sm.parse(end));
		}
		return trip;
	}
}
