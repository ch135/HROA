package com.hroa.service;

import com.hroa.model.Jobinfo;
import com.hroa.util.Page;

public interface JobinfoService {
	public void addJobinfo(Jobinfo Jobinfo);

	public void updateJobinfo(Jobinfo Jobinfo);

	public void deleteJobinfo(Integer JobinfoId);

	public Jobinfo findById(Integer companyId);
	
	public Jobinfo findByTelephone(String telephone);

	public Page<Jobinfo> findByPage(Page<Jobinfo> Jobinfo);
}
