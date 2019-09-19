package com.hroa.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hroa.dao.AgentDao;
import com.hroa.model.Agent;
import com.hroa.model.AgentExample;
import com.hroa.model.AgentExample.Criteria;
import com.hroa.service.AgentService;
import com.hroa.util.Page;

@Service("AgentService")
public class AgentServiceImpl implements AgentService {
	@Resource
	private AgentDao AgentDao;

	@Override
	public void addAgent(Agent Agent) {
		AgentDao.insert(Agent);
	}

	@Override
	public void updateAgent(Agent Agent) {
		AgentDao.updateByPrimaryKeySelective(Agent);
	}

	@Override
	public void deleteAgent(Integer AgentId) {
		AgentDao.deleteByPrimaryKey(AgentId);
	}

	@Override
	public Agent findById(Integer AgentId) {
		return AgentDao.selectByPrimaryKey(AgentId);
	}

	@Override
	public Page<Agent> findByPage(Page<Agent> page) {
		AgentExample example = new AgentExample();
		example.setLimitStart(page.getStart());
		example.setLimitEnd(page.getRows());
		Criteria criteria = example.createCriteria();
		Map<String, Object> map = page.getPageMap();
		String searchType = (String) map.get("searchType");
		String searchValue = (String) map.get("searchValue");
		if (searchValue == null || "".equals(searchValue)) {
		} else if ("name".equals(searchType)) {
			criteria.andNameLike("%"+searchValue+"%");
		} else if ("telephone".equals(searchType)) {
			criteria.andTelephoneLike(searchValue);
		} else if ("idcardNum".equals(searchType)) {
			criteria.andIdcardNumEqualTo(searchValue);
		} else if ("manager".equals(searchType)) {
			criteria.andManagerLike("%"+searchValue+"%");
		} else if ("managerTel".equals(searchType)) {
			criteria.andManagerTelEqualTo(searchValue);
		}
		page.setList(AgentDao.selectByExample(example));
		page.setTotalRecord(AgentDao.countByExample(example));
		return page;
	}

	@Override
	public Agent findByTelephone(String telephone) {
		return null;
	}

}
