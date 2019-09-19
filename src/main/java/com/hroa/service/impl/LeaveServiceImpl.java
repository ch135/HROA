package com.hroa.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hroa.dao.LeaveapplyDao;
import com.hroa.model.Leaveapply;
import com.hroa.service.LeaveService;

@Service("LeaveService")
public class LeaveServiceImpl implements LeaveService{

	@Resource private LeaveapplyDao leavedao;
	@Override
	public int addLeave(Leaveapply leave) {
		return leavedao.insertSelective(leave);
	}

	@Override
	public int delLeave(String id) {
		
		return leavedao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Leaveapply> getLeave(Map<String,Integer> map) {
		
		return leavedao.getLeave(map);
	}

	@Override
	public int getLeaveCount(int power) {
		
		return leavedao.getCount(power);
	}

	@Override
	public List<Leaveapply> getLeaveByname(Map<String,Object> map) {
		
		return leavedao.getLeaveByname(map);
	}

	@Override
	public int upLeave(Leaveapply leave) {
		
		return leavedao.updateByPrimaryKeySelective(leave);
	}

	@Override
	public List<Leaveapply> getLeaveByPhone(String phone) {
		return leavedao.selectByPhone(phone);
	}

	@Override
	public int getCountByname(Map<String,Object> map) {
		
		return leavedao.getCountByName(map);
	}

	@Override
	public int getHistoryCount(int power) {
		
		return leavedao.getHistoryCount(power);
	}

	@Override
	public List<Leaveapply> getHistoryLeave(Map<String, Integer> map) {
		
		return leavedao.getHistoryLeave(map);
	}

	@Override
	public int getDayNum(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return leavedao.getDayNum(map);
	}

}
