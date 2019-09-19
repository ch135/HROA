package com.hroa.service;

import java.util.List;
import java.util.Map;

import com.hroa.model.Leaveapply;

public interface LeaveService {
	public int addLeave(Leaveapply leave);
	
	public int delLeave(String id);
	
	public List<Leaveapply> getLeave(Map<String,Integer> map);
	
	public List<Leaveapply> getHistoryLeave(Map<String,Integer> map);
	
	public List<Leaveapply> getLeaveByPhone(String phone);
	
	public List<Leaveapply> getLeaveByname(Map<String,Object> map);
	
	public int getLeaveCount(int power);
	
	public int getCountByname(Map<String,Object> map);
	
	public int getHistoryCount(int power);
	
	public int upLeave(Leaveapply leave);
	
	public int getDayNum(Map<String,Object> map);
}
