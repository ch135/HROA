package com.hroa.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hroa.dao.MoneyapplyDao;
import com.hroa.model.Moneyapply;
import com.hroa.service.MoneyService;

@Service("MoneyService")
public class MoneyServiceImpl implements MoneyService{
	@Resource private MoneyapplyDao moneydao;
	
	@Override
	public int addmoney(Moneyapply money) {
		return moneydao.insertSelective(money);
	}

	@Override
	public int delMoney(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Moneyapply> getMoney(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return moneydao.getMoney(map);
	}

	@Override
	public List<Moneyapply> getHistoryMoney(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return moneydao.getHistoryMoney(map);
	}

	@Override
	public List<Moneyapply> getMoneyByPhone(String phone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Moneyapply> getMoneyByname(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return moneydao.getMoneyByname(map);
	}

	@Override
	public int getMoneyCount(int power) {
		
		return moneydao.getMoneyCount(power);
	}

	@Override
	public int getCountByname(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return moneydao.getCountByName(map);
	}

	@Override
	public int getHistoryCount(int person) {
		// TODO Auto-generated method stub
		return moneydao.getHistoryCount(person);
	}

	@Override
	public int upMoney(Moneyapply money) {
		return moneydao.updateByPrimaryKeySelective(money);
	}

	@Override
	public int getDayNum(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return moneydao.getDayNum(map);
	}

}
