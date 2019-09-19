package com.hroa.service;

import com.hroa.model.AdminModel;

public interface LoginService {
	public AdminModel login(String account,String password);
}
