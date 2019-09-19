package com.hroa.service;

import com.hroa.model.JobRecord;
import com.hroa.util.Page;

public interface JobRecordService {
	public void addJobRecord(JobRecord JobRecord);
	public void updateJobRecord(JobRecord JobRecord);
	public void deleteJobRecord(Integer companyId);
	public JobRecord findByCompanyId(Integer companyId);
	public Page<JobRecord>findByPage(Page<JobRecord>JobRecord);
}
