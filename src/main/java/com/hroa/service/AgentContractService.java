package com.hroa.service;

import java.util.List;

import com.hroa.model.AgentContract;
import com.hroa.model.ShCompany;
import com.hroa.util.Page;


public interface AgentContractService {
	 //添加代理的合同
    public boolean addAgentContract(AgentContract agentContract);
    
    //删除代理合同
    public boolean deleteAgentContract(AgentContract agentContract);
    
    //显示当前代理的合同
    public List<AgentContract> showOneAgentContract(AgentContract agentContract);
    
    //显示所有代理的合同*
    public List<AgentContract> showAllAgentContract();
    
	public Page<AgentContract>findByPage(Page<AgentContract> page);
	
	//显示具体的合同信息
	public AgentContract showDetails(int id);
	
	//更新代理合同
	public boolean editAgentContract(AgentContract agentContract);
	
	//代理查看自己的合同列表
	public Page<AgentContract>findByPageToAgent(Page<AgentContract> page);
}
