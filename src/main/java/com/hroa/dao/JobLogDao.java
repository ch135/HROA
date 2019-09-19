package com.hroa.dao;

import java.util.List;

import com.hroa.model.JobLogModel;

public interface JobLogDao {
	/*添加日志*/
	int addJobLog(JobLogModel jobLogModel);
	/*获取日志总数量*/
	int gtJbLgAmount();
	/*分页获取日志*/
	List<JobLogModel> gtJbLgByPages(int startPage,int pageSize);
}
