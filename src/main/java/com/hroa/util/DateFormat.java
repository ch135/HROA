package com.hroa.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/*日期转换类*/

public class DateFormat {
	public String format(Date source) {
		// 格式化日期（格式是yyyy-MM-dd）
		try{
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			return simpleDateFormat.format(source);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
