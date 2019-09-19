package com.hroa.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hroa.dao.JobinfoDao;
import com.hroa.dao.ShCompanyDao;
import com.hroa.model.Jobinfo;
import com.hroa.model.JobinfoExample;
import com.hroa.model.JobinfoExample.Criteria;
import com.hroa.model.ShCompany;
import com.hroa.service.JobinfoService;
import com.hroa.util.Page;

@Service("JobinfoService")
public class JobinfoServiceImpl implements JobinfoService {
	@Resource
	private JobinfoDao JobinfoDao;
	@Resource
	private ShCompanyDao ShCompanyDao;

	@Override
	public void addJobinfo(Jobinfo Jobinfo) {
		JobinfoDao.insert(Jobinfo);
	}

	@Override
	public void updateJobinfo(Jobinfo Jobinfo) {
		JobinfoDao.updateByPrimaryKeySelective(Jobinfo);
	}

	@Override
	public void deleteJobinfo(Integer JobinfoId) {
		JobinfoDao.deleteByPrimaryKey(JobinfoId);
	}

	@Override
	public Jobinfo findById(Integer JobinfoId) {
		Jobinfo jobinfo = JobinfoDao.selectByPrimaryKey(JobinfoId);
		jobinfo.setShCompany(ShCompanyDao.selectByPrimaryKey(jobinfo.getcId()));
		return jobinfo;
	}

	@Override
	public Page<Jobinfo> findByPage(Page<Jobinfo> page) {
		JobinfoExample example = new JobinfoExample();
		example.setLimitStart(page.getStart());
		example.setLimitEnd(page.getRows());
		Criteria criteria = example.createCriteria();
		Map<String, Object> map = page.getPageMap();
		String searchType = (String) map.get("searchType");
		String searchValue = (String) map.get("searchValue");
		if (searchValue == null || "".equals(searchValue)) {
		} else if ("name".equals(searchType)) {
			//criteria.andNameLike("%" + searchValue + "%");
		}
		Jobinfo paramEntity = page.getParamEntity();
		if (paramEntity.getId() != null) {
			criteria.andIdEqualTo(paramEntity.getId());
		}
		if (paramEntity.getcId() != null) {
			criteria.andCIdEqualTo(paramEntity.getcId());
		}
		List<Jobinfo> list = JobinfoDao.selectByExample(example);
		for (Jobinfo jobinfo : list) {
			ShCompany company = ShCompanyDao.selectByPrimaryKey(jobinfo.getcId());
			jobinfo.setShCompany(company);
		}
		page.setList(list);
		page.setTotalRecord(JobinfoDao.countByExample(example));
		return page;
	}

	@Override
	public Jobinfo findByTelephone(String telephone) {
		return null;
	}

}
