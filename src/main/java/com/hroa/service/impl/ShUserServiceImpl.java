package com.hroa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hroa.dao.ShUserDao;
import com.hroa.model.ShUser;
import com.hroa.service.ShUserService;
import com.hroa.util.Page;

@Service("ShUserService")
public class ShUserServiceImpl implements ShUserService {
	@Resource
	private ShUserDao shUserDao;

	@Override
	public void addShUser(ShUser ShUser) {
		shUserDao.insert(ShUser);
	}

	@Override
	public void updateShUser(ShUser ShUser) {
		shUserDao.updateByPrimaryKeySelective(ShUser);
	}

	@Override
	public void deleteShUser(Integer shUserId) {
		shUserDao.deleteByPrimaryKey(shUserId);
	}

	@Override
	public ShUser findByUserId(Integer shUserId) {
		return shUserDao.selectByPrimaryKey(shUserId);
	}

	@Override
	public Page<ShUser> findByPage(Page<ShUser> page) {
		List<ShUser> list = shUserDao.datagridShUser(page);
		int total = shUserDao.selectShUserTotal(page);
		page.setTotalRecord(total);
		page.setList(list);
		return page;
	}

	@Override
	public ShUser findByTelephone(String telephone) {
		return shUserDao.selectByTelephone(telephone);
	}

}
