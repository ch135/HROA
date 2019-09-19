package com.hroa.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hroa.dao.TripapplyDao;
import com.hroa.model.Tripapply;
import com.hroa.service.TripService;

@Service("TripService")
public class TripServiceImpl implements TripService{

	@Resource private TripapplyDao tripdao;
	@Override
	public int addTrip(Tripapply trip) {
		return tripdao.insertSelective(trip);
	}

	@Override
	public List<Tripapply> getTrip(Map<String, Integer> map) {
		return tripdao.getTrip(map);
	}

	@Override
	public List<Tripapply> getHistoryTrip(Map<String, Integer> map) {
		return tripdao.getHistoryTrip(map);
	}

	@Override
	public List<Tripapply> getTripByPhone(String phone) {
		return tripdao.selectByPhone(phone);
	}

	@Override
	public List<Tripapply> getTripByname(Map<String, Object> map) {
		return tripdao.getTripByname(map);
	}

	@Override
	public int getTripCount() {
		return tripdao.getCount();
	}

	@Override
	public int getCountByname(String name) {
		
		return tripdao.getCountByName(name);
	}

	@Override
	public int getHistoryCount() {
		
		return tripdao.getHistoryCount();
	}

	@Override
	public int upTrip(Tripapply Trip) {
		return tripdao.updateByPrimaryKeySelective(Trip);
	}

	@Override
	public int getDayNum(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tripdao.getDayNum(map);
	}

}
