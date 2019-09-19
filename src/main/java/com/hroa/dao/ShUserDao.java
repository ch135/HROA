package com.hroa.dao;

import java.util.List;

import com.hroa.model.EnterCom;
import com.hroa.model.ShUser;
import com.hroa.util.Page;

public interface ShUserDao {

    int deleteByPrimaryKey(Integer id);

    int insert(ShUser record);

    ShUser selectByPrimaryKey(Integer id);
    
    ShUser selectByTelephone(String telephone);

    int updateByPrimaryKeySelective(ShUser record);
    
    List<ShUser>datagridShUser(Page<ShUser>page);
    
    int selectShUserTotal(Page<ShUser> page);
}