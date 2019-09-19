package com.hroa.dao;

import java.util.List;

import com.hroa.model.EnterCom;
import com.hroa.util.Page;

public interface EnterComDao {

	int deleteByPrimaryKey(Integer id);

	int insert(EnterCom record);

	EnterCom selectByPrimaryKey(Integer id);
	
	EnterCom selectByTelephone(String telephone);

	int updateByPrimaryKeySelective(EnterCom record);

	List<EnterCom> datagridEnterCom(Page<EnterCom> page);

	int selectEnterComTotal(Page<EnterCom> page);
	
	int selectCount(EnterCom enterCom);
}