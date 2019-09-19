package com.hroa.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hroa.dao.ShCompanyDao;
import com.hroa.model.ShCompany;
import com.hroa.service.ShCompanyService;
import com.hroa.util.Page;

@Service("ShCompanyService")
public class ShCompanyServiceImpl implements ShCompanyService {

	@Resource
	private ShCompanyDao shCompanyDao;

	@Override
	public void addShCompany(ShCompany shCompany) {
		shCompanyDao.insert(shCompany);
	}

	@Override
	public void updateShCompany(ShCompany shCompany) {
		shCompanyDao.updateByPrimaryKeySelective(shCompany);
	}

	@Override
	public void deleteShCompany(Integer companyId) {
		shCompanyDao.deleteByPrimaryKey(companyId);
	}

	@Override
	public ShCompany findByCompanyId(Integer companyId) {
		return shCompanyDao.selectByPrimaryKey(companyId);
	}

	@Override
	public Page<ShCompany> findByPage(Page<ShCompany> page) {
		List<ShCompany> list = shCompanyDao.datagridShCompany(page);
		int total = shCompanyDao.selectShCompanyTotal(page);
		page.setTotalRecord(total);
		page.setList(list);
		return page;
	}

}
