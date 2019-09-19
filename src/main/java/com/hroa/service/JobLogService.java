package com.hroa.service;

import java.util.List;

import com.hroa.model.JobLogModel;

public interface JobLogService {
	/*添加日志*/
	public int addJobLog(JobLogModel jobLogModel);
	/*获取日志总数量*/
	public int gtJbLgAmount();
	/*分页获取日志*/
	public List<JobLogModel> gtJbLgByPages(int startPage,int pageSize);
}
