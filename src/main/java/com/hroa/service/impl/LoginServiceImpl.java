package com.hroa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hroa.dao.LoginDao;
import com.hroa.model.AdminModel;
import com.hroa.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {
	@Resource
	LoginDao lgDao;
	/**
	 * author qwc
	 * 2017年6月13日下午8:56:02
	 * @param account
	 * @param password
	 * @return
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.LoginService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public AdminModel login(String account, String password) {
		// TODO Auto-generated method stub
        AdminModel lgModel=new AdminModel();
        lgModel=lgDao.login(account, password);
		return lgModel;
	}

}
