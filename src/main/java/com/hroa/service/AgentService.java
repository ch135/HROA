package com.hroa.service;

import com.hroa.model.Agent;
import com.hroa.util.Page;

public interface AgentService {
	public void addAgent(Agent Agent);

	public void updateAgent(Agent Agent);

	public void deleteAgent(Integer AgentId);

	public Agent findById(Integer companyId);
	
	public Agent findByTelephone(String telephone);

	public Page<Agent> findByPage(Page<Agent> Agent);
}
