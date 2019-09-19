package com.hroa.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hroa.dao.UserSignDao;
import com.hroa.model.UserSign;
import com.hroa.service.UserSignService;

@Service("UserSignService")
public class UserSignServiceImpl implements UserSignService{
	
	@Resource private UserSignDao signdao;

	@Override
	public UserSign getSign(Date day,String userid) {
		
		return signdao.getUserSign(day,userid);
	}

	@Override
	public int upUserSIgn(UserSign usersiagn) {
		// TODO Auto-generated method stub
		return signdao.updateByPrimaryKeySelective(usersiagn);
	}

}
