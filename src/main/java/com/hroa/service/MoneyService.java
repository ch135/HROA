package com.hroa.service;

import java.util.List;
import java.util.Map;
import com.hroa.model.Moneyapply;

public interface MoneyService {
	public int addmoney(Moneyapply money);
	
	public int delMoney(String id);
	
	public List<Moneyapply> getMoney(Map<String,Integer> map);
	
	public List<Moneyapply> getHistoryMoney(Map<String,Integer> map);
	
	public List<Moneyapply> getMoneyByPhone(String phone);
	
	public List<Moneyapply> getMoneyByname(Map<String,Object> map);
	
	public int getMoneyCount(int power);
	
	public int getCountByname(Map<String,Object> map);
	
	public int getHistoryCount(int power);
	
	public int upMoney(Moneyapply money);
	
	public int getDayNum(Map<String,Object> map);
}
