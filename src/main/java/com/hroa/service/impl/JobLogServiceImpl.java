package com.hroa.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hroa.dao.JobLogDao;
import com.hroa.model.JobLogModel;
import com.hroa.service.JobLogService;
@Service
public class JobLogServiceImpl implements JobLogService {
	@Resource
	JobLogDao jobLogDao;
	/**
	 * author qwc
	 * 2017年6月29日下午4:08:00
	 * @param jobLogModel
	 * @return
	 * 添加日志
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.JobLogService#addJobLog(com.hroa.model.JobLogModel)
	 */
	@Override
	public int addJobLog(JobLogModel jobLogModel) {
		// TODO Auto-generated method stub
		int addStatus=0;
		addStatus=jobLogDao.addJobLog(jobLogModel);
		return addStatus;
	}
	
	/**
	 * author qwc
	 * 2017年6月29日下午4:14:28
	 * @return
	 * 获取日志总数量
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.JobLogService#gtJbLgAmount()
	 */
	@Override
	public int gtJbLgAmount() {
		// TODO Auto-generated method stub
		int amount=jobLogDao.gtJbLgAmount();
		return amount;
	}

	/**
	 * author qwc
	 * 2017年6月29日下午4:16:35
	 * @param startPage
	 * @param pageSize
	 * @return
	 * 分页获取日志
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.JobLogService#gtJbLgByPages(int, int)
	 */
	@Override
	public List<JobLogModel> gtJbLgByPages(int startPage, int pageSize) {
		// TODO Auto-generated method stub
		List<JobLogModel> jgLogList=new ArrayList<JobLogModel>();
		jgLogList=jobLogDao.gtJbLgByPages(startPage, pageSize);
		return jgLogList;
	}
	
}
