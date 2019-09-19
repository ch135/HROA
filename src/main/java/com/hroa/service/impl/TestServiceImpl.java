package com.hroa.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hroa.dao.TestDao;
import com.hroa.service.TestService;
@Service
public class TestServiceImpl implements TestService{
	@Resource
    TestDao testMybatisDao;
	@Override
	public int testMybatis() {
		// TODO Auto-generated method stub
		int amount=testMybatisDao.getAmount();
		return amount;
	}

}
