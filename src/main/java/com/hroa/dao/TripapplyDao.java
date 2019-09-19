package com.hroa.dao;

import java.util.List;
import java.util.Map;

import com.hroa.model.Tripapply;

public interface TripapplyDao {
    int deleteByPrimaryKey(String id);

    int insert(Tripapply record);

    int insertSelective(Tripapply record);

    Tripapply selectByPrimaryKey(String id);
    
    List<Tripapply> selectByPhone(String phone);
    
    List<Tripapply> getTrip(Map<String,Integer> map);
    
    List<Tripapply> getTripByname(Map<String, Object> map);
    
    List<Tripapply> getHistoryTrip(Map<String,Integer> map);
    
    int updateByPrimaryKeySelective(Tripapply record);

    int updateByPrimaryKey(Tripapply record);
    
    int getCount();
    
    int getCountByName(String name);
    
    int getHistoryCount();
    
    int getDayNum(Map<String,Object> map);
    
}