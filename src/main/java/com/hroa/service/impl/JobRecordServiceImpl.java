package com.hroa.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hroa.dao.JobRecordDao;
import com.hroa.dao.JobinfoDao;
import com.hroa.dao.ShCompanyDao;
import com.hroa.model.JobRecord;
import com.hroa.model.JobRecordExample;
import com.hroa.model.JobRecordExample.Criteria;
import com.hroa.model.Jobinfo;
import com.hroa.model.ShCompany;
import com.hroa.service.JobRecordService;
import com.hroa.util.Page;

@Service("JobRecordService")
public class JobRecordServiceImpl implements JobRecordService {

	@Resource
	private JobRecordDao JobRecordDao;

	@Override
	public void addJobRecord(JobRecord JobRecord) {
		JobRecordDao.insert(JobRecord);
	}

	@Override
	public void updateJobRecord(JobRecord JobRecord) {
		JobRecordDao.updateByPrimaryKeySelective(JobRecord);
	}

	@Override
	public void deleteJobRecord(Integer companyId) {
		JobRecordDao.deleteByPrimaryKey(companyId);
	}

	@Override
	public JobRecord findByCompanyId(Integer companyId) {
		return JobRecordDao.selectByPrimaryKey(companyId);
	}

	@Override
	public Page<JobRecord> findByPage(Page<JobRecord> page) {
		JobRecordExample example = new JobRecordExample();
		example.setLimitStart(page.getStart());
		example.setLimitEnd(page.getRows());
		Criteria criteria = example.createCriteria();
		JobRecord jobRecord = page.getParamEntity();
		if(jobRecord!=null)
		{
			if(jobRecord.getName()!=null&&jobRecord.getName()!=""){
				criteria.andNameLike("%"+jobRecord.getName()+"%");
			}
			if(jobRecord.getLinkMan()!=null&&jobRecord.getLinkMan()!=""){
				criteria.andLinkManLike(jobRecord.getLinkMan());
			}
			if(jobRecord.getDevelopMan()!=null&&jobRecord.getDevelopMan()!=""){
				criteria.andDevelopManLike(jobRecord.getDevelopMan());
			}
			if(jobRecord.getFactoryMan()!=null&&jobRecord.getFactoryMan()!=""){
				criteria.andFactoryManLike(jobRecord.getFactoryMan());
			}
			if(jobRecord.getJob()!=null&&jobRecord.getJob()!=""){
				criteria.andJobLike("%"+jobRecord.getJob()+"%");
			}
			if(jobRecord.getFactoryMan()!=null&&jobRecord.getFactoryMan()!=""){
				criteria.andFactoryManLike(jobRecord.getFactoryMan());
			}
			if(jobRecord.getClassify()!=null&&jobRecord.getClassify()!=""){
				criteria.andClassifyLike(jobRecord.getClassify());
			}
			if(jobRecord.getIsFinish()!=null){
				criteria.andIsFinishEqualTo(jobRecord.getIsFinish());
			}
			if(jobRecord.getProvince()!=null&&jobRecord.getProvince()!=""){
				criteria.andProvinceEqualTo(jobRecord.getProvince());
			}
			if(jobRecord.getCity()!=null&&jobRecord.getCity()!=""){
				criteria.andCityEqualTo(jobRecord.getCity());
			}
			if(jobRecord.getRegion()!=null&&jobRecord.getRegion()!=""){
				criteria.andRegionEqualTo(jobRecord.getRegion());
			}
			if(jobRecord.getType()!=null){
				criteria.andTypeEqualTo(jobRecord.getType());
			}
		}
		example.setOrderByClause("id desc");
		List<JobRecord> list = JobRecordDao.selectByExample(example);
		page.setList(list);
		page.setTotalRecord(JobRecordDao.countByExample(example));
		return page;
	}

}
