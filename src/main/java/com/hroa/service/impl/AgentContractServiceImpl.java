package com.hroa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hroa.dao.AgentContractDao;
import com.hroa.model.AgentContract;
import com.hroa.service.AgentContractService;
import com.hroa.util.Page;
@Service("AgentContractService")
public class AgentContractServiceImpl implements AgentContractService {
	@Resource
	private AgentContractDao agentContractDao;
	@Override
	public boolean addAgentContract(AgentContract agentContract) {
		int i= agentContractDao.insertAgentContract(agentContract);
		if(i==1){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public boolean deleteAgentContract(AgentContract agentContract) {
		 int i=agentContractDao.deleteAgentContract(agentContract);
		 if(i==1){
			 return true;
		 }
		 else{
		return false;
		 }
	}
	@Override
	public List<AgentContract> showOneAgentContract(AgentContract agentContract) {
		return agentContractDao.selectAgentContractByAgentId(agentContract);
	}
	@Override
	public List<AgentContract> showAllAgentContract() {
		return agentContractDao.selectAllAgentContract();
	}
	
	
	@Override
	public Page<AgentContract> findByPage(Page<AgentContract> page) {
		List<AgentContract> list=agentContractDao.datagridAgentContract(page);
		int total=agentContractDao.selectAgentContractTotal(page);
		page.setTotalRecord(total);
		page.setList(list);
		return page;
	}
	@Override
	public AgentContract showDetails(int id) {
		return agentContractDao.showDetails(id);
	}
	@Override
	public boolean editAgentContract(AgentContract agentContract) {
		 int i=agentContractDao.editAgentContract(agentContract);
		 if(i==1){
			 return true;
		 }
		 else{
		return false;
		 }
	}
	@Override
	public Page<AgentContract> findByPageToAgent(Page<AgentContract> page) {
		List<AgentContract> list=agentContractDao.datagridAgentContractToAgent(page);
		int total=agentContractDao.selectAgentContractTotalToAgent(page);
		page.setTotalRecord(total);
		page.setList(list);
		return page;
	}
}
