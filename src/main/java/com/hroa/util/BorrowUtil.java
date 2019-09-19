package com.hroa.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.hroa.model.Borrow;



public class BorrowUtil {
	
	public static Borrow setValue(Borrow borrow,String applytime,String backtime) throws ParseException{
		if(borrow!=null){
			SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
			Random ra=new Random();
			String date=sm.format(new Date().getTime());
			borrow.setId("QT"+date.replace("-", "")+ra.nextInt(10000));
			borrow.setApplytime(sm.parse(applytime));
			borrow.setBacktime(sm.parse(backtime));
			borrow.setRealtime(sm.parse(date));
			
		}
		return borrow;
	}

	public static List<Borrow> changeValue(List<Borrow> borrows, int power) {
		// TODO Auto-generated method stub
		List<Borrow> borrow=new ArrayList<Borrow>();
		if(power==1){
			for(Borrow br:borrows){
				br.setSecondcheck(3);
				borrow.add(br);
			}
		}else if(power==2){
			for(Borrow br:borrows){
				br.setFirstcheck(3);
				borrow.add(br);
			}
		}
		return borrow;
	}

}
