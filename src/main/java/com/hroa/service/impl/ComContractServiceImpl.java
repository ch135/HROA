package com.hroa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hroa.dao.ComContractDao;
import com.hroa.model.AgentContract;
import com.hroa.model.ComContract;
import com.hroa.service.ComContractService;
import com.hroa.util.Page;

@Service("ComContractService")
public class ComContractServiceImpl implements ComContractService  {
	@Resource
	private ComContractDao comContractDao;
	@Override
	public boolean addComContract(ComContract comContract) {
		int i= comContractDao.insertComContract(comContract);
		if(i==1){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public Page<ComContract> findByPage(Page<ComContract> page) {
		List<ComContract> list=comContractDao.datagridComContract(page);
		int total=comContractDao.selectComContractTotal(page);
		page.setTotalRecord(total);
		page.setList(list);
		return page;
	}

	@Override
	public boolean deleteComContract(ComContract comContract) {
		int i=comContractDao.deleteComContract(comContract);
		 if(i==1){
			 return true;
		 }
		 else{
		return false;
		 }
	}

	@Override
	public ComContract showDetails(int id) {
		return comContractDao.showDetails(id);
	}

	@Override
	public boolean editComContract(ComContract comContract) {
		 int i=comContractDao.editComContract(comContract);
		 if(i==1){
			 return true;
		 }
		 else{
		return false;
		 }
	}
	

	@Override
	public Page<ComContract> findByPageToCom(Page<ComContract> page) {
		List<ComContract> list=comContractDao.datagridComContractToCom(page);
		int total=comContractDao.selectComContractTotalToCom(page);
		page.setTotalRecord(total);
		page.setList(list);
		return page;
	}

}
