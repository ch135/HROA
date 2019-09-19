package com.hroa.dao;

import java.util.List;

import com.hroa.model.AgentContract;
import com.hroa.model.ShCompany;
import com.hroa.util.Page;

public interface AgentContractDao {
    int deleteByPrimaryKey(int id);

    int insert(AgentContract record);

    int insertSelective(AgentContract record);

    AgentContract selectByPrimaryKey(int id);

    int updateByPrimaryKeySelective(AgentContract record);

    int updateByPrimaryKey(AgentContract record);
    
    int insertAgentContract(AgentContract agentContract);
    
    int deleteAgentContract(AgentContract agentContract);
    
    List<AgentContract> selectAgentContractByAgentId(AgentContract agentContract);
    
    List<AgentContract> selectAllAgentContract();
    
    //查看所有代理合同
    List<AgentContract>datagridAgentContract(Page<AgentContract>page);
    
    int selectAgentContractTotal(Page<AgentContract> page);
    
    //查看详细的合同
    AgentContract showDetails(int id);
    //编辑合同
    int editAgentContract(AgentContract agentContract);
    
    //代理查看自己的所有合同
    List<AgentContract>datagridAgentContractToAgent(Page<AgentContract>page);
    
    int selectAgentContractTotalToAgent(Page<AgentContract> page);
    
    
}