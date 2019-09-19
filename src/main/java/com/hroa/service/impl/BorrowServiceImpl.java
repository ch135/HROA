package com.hroa.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hroa.dao.BorrowDao;
import com.hroa.model.Borrow;
import com.hroa.service.BorrowService;


@Service("BorrowService")
public class BorrowServiceImpl implements BorrowService{
	
	@Autowired
	private BorrowDao borrowDao;
	
	public int addBorrow(Borrow borrow){
		return borrowDao.insertSelective(borrow);
	}
	
	public int getBorrowCount(int power){
		return borrowDao.getCount(power);
	}
	
	public List<Borrow> getBorrow(Map<String,Integer> map){
		return borrowDao.getBorrow(map);
	}
	
	public int getHistoryCount(int power){
		return borrowDao.getHistoryCount(power);
	}
	
	public List<Borrow> getHistoryBorrow(Map<String,Integer> map){
		return borrowDao.getHistoryBorrow(map);
	}
	
	public List<Borrow> getBorrowByname(Map<String,Object> map){
		return borrowDao.getBorrowByname(map);
	}
	
	public int getCountByname(Map<String,Object> map){
		return borrowDao.getCountByname(map);
	}
	
	public List<Borrow> getBorrowByPhone(String phone){
		return borrowDao.getBorrowByPhone(phone);
	}
	
	public int changeBorrow(Borrow borrow){
		return borrowDao.changeBorrow(borrow);
	}
	
	public int delBorrow(String id){
		return borrowDao.deleteByPrimaryKey(id);
	}

	@Override
	public int getDayNum(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return borrowDao.getDayNum(map);
	}
}
	


