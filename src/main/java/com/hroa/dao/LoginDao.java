package com.hroa.dao;

import com.hroa.model.AdminModel;

public interface LoginDao {
	/*用户登录*/
	AdminModel login(String account,String password);
}
