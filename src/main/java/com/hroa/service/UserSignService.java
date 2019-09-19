package com.hroa.service;

import java.util.Date;

import com.hroa.model.UserSign;

public interface UserSignService {
	
	public UserSign getSign(Date day,String userid);
	
	public int upUserSIgn(UserSign usersiagn);
	
}
