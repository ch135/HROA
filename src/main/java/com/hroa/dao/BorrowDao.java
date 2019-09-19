package com.hroa.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hroa.model.Borrow;

@Repository
public interface BorrowDao {
    int deleteByPrimaryKey(String id);

    int insert(Borrow record);

    int insertSelective(Borrow record);

    Borrow selectByPrimaryKey(int id);

    int updateByPrimaryKeySelective(Borrow record);

    int updateByPrimaryKey(Borrow record);
    
    int getCount(@Param(value="power")int power);
    
    List<Borrow> getBorrow(Map<String,Integer> map);
    
    int getHistoryCount(@Param(value="power")int power);
    
    List<Borrow> getHistoryBorrow(Map<String,Integer> map);
    
    List<Borrow> getBorrowByname(Map<String,Object> map);
    
     int getCountByname(Map<String,Object> map);
     
     List<Borrow> getBorrowByPhone(String phone);
     
     int changeBorrow(Borrow borrow);

     int getDayNum(Map<String,Object> map);
}