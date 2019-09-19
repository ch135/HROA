package com.hroa.service;

import java.util.List;
import java.util.Map;

import com.hroa.model.Borrow;


public interface BorrowService {
	
	public int addBorrow(Borrow borrow);
	
	public int delBorrow(String id);
	
	public int getBorrowCount(int power);
	
	public List<Borrow> getBorrow(Map<String,Integer> map);
	
	public int getHistoryCount(int power);
	
	public List<Borrow> getHistoryBorrow(Map<String,Integer> map);
	
	public List<Borrow> getBorrowByname(Map<String,Object> map);
	
	public int getCountByname(Map<String,Object> map);
	
	public List<Borrow> getBorrowByPhone(String phone);
	
	public int changeBorrow(Borrow borrow);
	
	public int getDayNum(Map<String,Object> map);

}
