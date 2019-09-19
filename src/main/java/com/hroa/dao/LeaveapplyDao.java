package com.hroa.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hroa.model.Leaveapply;

public interface LeaveapplyDao {
    int deleteByPrimaryKey(String id);

    int insert(Leaveapply record);

    int insertSelective(Leaveapply record);

    Leaveapply selectByPrimaryKey(String id);

    List<Leaveapply> selectByPhone(String phone);
    
    List<Leaveapply> getLeave(Map<String,Integer> map);

    List<Leaveapply> getLeaveByname(Map<String, Object> map);
    
    List<Leaveapply> getHistoryLeave(Map<String,Integer> map);
    
    int updateByPrimaryKeySelective(Leaveapply record);

    int updateByPrimaryKey(Leaveapply record);
    
    int getCount(@Param(value="power")int power);
    
    int getCountByName(Map<String,Object> map);
    
    int getHistoryCount(@Param(value="power")int power);
    
    int getDayNum(Map<String,Object> map);
}