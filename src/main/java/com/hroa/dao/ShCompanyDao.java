package com.hroa.dao;

import java.util.List;

import com.hroa.model.ShCompany;
import com.hroa.util.Page;

public interface ShCompanyDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ShCompany company);

    ShCompany selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(ShCompany record);
    
    int updateByPrimaryKeySelective(ShCompany record);
    
    List<ShCompany>datagridShCompany(Page<ShCompany>page);
    
    int selectShCompanyTotal(Page<ShCompany> page);
    
}