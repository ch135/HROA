package com.hroa.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.hroa.model.Leaveapply;
import com.hroa.model.Moneyapply;

/**
 * @author chenhao
 * @since 费用报销处理工具类
 * @date 2017/6/18 23：43
 */
public class MoneyUtil {
	public static Moneyapply setValue(Moneyapply money,String usemoney,String usetime) throws ParseException{
		if(money!=null){
			SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
			Random ra=new Random();
			String date=sm.format(new Date().getTime());
			BigDecimal bc=new BigDecimal(usemoney);
			bc=bc.setScale(2, BigDecimal.ROUND_HALF_UP);//两位小数位，四舍五入
			money.setId("BX"+date.replace("-", "")+ra.nextInt(10000));
			money.setFreetime(sm.parse(date));
			money.setUsetime(sm.parse(usetime));
			money.setUsemoney(bc);
		}
		return money;
	}
	
	public static List<Moneyapply> changeValue(List<Moneyapply> moneys,int person){
		List<Moneyapply> money=new ArrayList<Moneyapply>();
		if(person==1){
			for(Moneyapply mo:moneys){
				mo.setSecondcheck(3);
				money.add(mo);
			}
		}else if(person==2){
			for(Moneyapply mo:moneys){
				mo.setFristcheck(3);
				money.add(mo);
			}
		}else if(person==3){
			for(Moneyapply mo:moneys){
				mo.setFristcheck(3);
				mo.setSecondcheck(3);
				money.add(mo);
			}
		}
		return money;
	}
}
