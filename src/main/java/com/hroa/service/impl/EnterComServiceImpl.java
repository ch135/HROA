package com.hroa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hroa.dao.EnterComDao;
import com.hroa.model.EnterCom;
import com.hroa.service.EnterComService;
import com.hroa.util.Page;

@Service("EnterComService")
public class EnterComServiceImpl implements EnterComService {
	@Resource
	private EnterComDao EnterComDao;

	@Override
	public void addEnterCom(EnterCom EnterCom) {
		EnterComDao.insert(EnterCom);
	}

	@Override
	public void updateEnterCom(EnterCom EnterCom) {
		
		EnterComDao.updateByPrimaryKeySelective(EnterCom);
	}

	@Override
	public void deleteEnterCom(Integer EnterComId) {
		EnterComDao.deleteByPrimaryKey(EnterComId);
	}

	@Override
	public EnterCom findById(Integer EnterComId) {
		return EnterComDao.selectByPrimaryKey(EnterComId);
	}

	@Override
	public Page<EnterCom> findByPage(Page<EnterCom> page) {
		System.out.println(page.getParamEntity().getLeaveDate());
		List<EnterCom> list = EnterComDao.datagridEnterCom(page);
		int total = EnterComDao.selectEnterComTotal(page);
		page.setTotalRecord(total);
		page.setList(list);
		return page;
	}

	@Override
	public EnterCom findByTelephone(String telephone) {
		return EnterComDao.selectByTelephone(telephone);
	}
	
	@Override 
	public Integer[] getReadNum(EnterCom enterCom) {
		Integer[]num=new Integer[1];
		int count = EnterComDao.selectCount(enterCom);
		num[0]=count;
		return num;
	}

}
