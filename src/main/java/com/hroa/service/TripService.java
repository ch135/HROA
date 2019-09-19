package com.hroa.service;

import java.util.List;
import java.util.Map;

import com.hroa.model.Tripapply;

public interface TripService {

	public int addTrip(Tripapply Trip);
	
	public List<Tripapply> getTrip(Map<String,Integer> map);
	
	public List<Tripapply> getHistoryTrip(Map<String,Integer> map);
	
	public List<Tripapply> getTripByPhone(String phone);
	
	public List<Tripapply> getTripByname(Map<String,Object> map);
	
	public int getTripCount();
	
	public int getCountByname(String name);
	
	public int getHistoryCount();
	
	public int upTrip(Tripapply Trip);
	
	public int getDayNum(Map<String,Object> map);
}
