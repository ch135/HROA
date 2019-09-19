package com.hroa.dao;

import java.util.List;

import com.hroa.model.AgentContract;
import com.hroa.model.ComContract;
import com.hroa.util.Page;

public interface ComContractDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ComContract record);

    int insertSelective(ComContract record);

    ComContract selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ComContract record);

    int updateByPrimaryKey(ComContract record);
    
    int insertComContract(ComContract comContract);
    
    //查询所有的公司合同
    List<ComContract>datagridComContract(Page<ComContract>page);
    
    int selectComContractTotal(Page<ComContract> page);
    
    //删除企业合同
    int deleteComContract(ComContract ComContract);
    
    //查看具体的企业合同信息
    ComContract showDetails(int id);
    
    //编辑企业合同信息
    int editComContract(ComContract ComContract);
    
    
    //查询自己的公司合同
    List<ComContract>datagridComContractToCom(Page<ComContract>page);
    
    int selectComContractTotalToCom(Page<ComContract> page);
}