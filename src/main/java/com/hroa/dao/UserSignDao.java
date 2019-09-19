package com.hroa.dao;

import java.util.Date;

import com.hroa.model.UserSign;

public interface UserSignDao {
    int deleteByPrimaryKey(Integer id);

    int insert(UserSign record);

    int insertSelective(UserSign record);

    UserSign selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserSign record);

    int updateByPrimaryKey(UserSign record);
    
    UserSign getUserSign(Date day,String userid);

}