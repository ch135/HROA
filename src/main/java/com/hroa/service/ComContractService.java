package com.hroa.service;

import java.util.List;

import com.hroa.model.AgentContract;
import com.hroa.model.ComContract;
import com.hroa.util.Page;

public interface ComContractService {
	public boolean addComContract(ComContract comContract);
	
	 //显示所有代理的合同*
  /*  public List<ComContract> showAllComContract();*/
    
	public Page<ComContract>findByPage(Page<ComContract> page);
	
	//删除代理合同
    public boolean deleteComContract(ComContract comContract);
    
  //显示具体的合同信息
  	public ComContract showDetails(int id);
  	
  	//编辑企业合同信息
  	public boolean editComContract(ComContract comContract);
  	
  	//查看自己的企业合同信息
  	public Page<ComContract>findByPageToCom(Page<ComContract> page);
  	

}
