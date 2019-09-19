package com.hroa.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hroa.model.Moneyapply;

public interface MoneyapplyDao {
    int deleteByPrimaryKey(String id);

    int insert(Moneyapply record);

    int insertSelective(Moneyapply record);

    Moneyapply selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Moneyapply record);

    int updateByPrimaryKey(Moneyapply record);
    
    int getMoneyCount(@Param("person")int person);
    
    int getDayNum(Map<String,Object> map);
    
    int getCountByName(Map<String, Object> map);
    
    int getHistoryCount(@Param("person")int person);
    
    List<Moneyapply> getMoney(Map<String,Integer> map);
    
    List<Moneyapply> getMoneyByname(Map<String, Object> map);
    
    List<Moneyapply> getHistoryMoney(Map<String, Integer> map);
    
}