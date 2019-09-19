package com.hroa.service;

import com.hroa.model.ShCompany;
import com.hroa.util.Page;

public interface ShCompanyService {
	public void addShCompany(ShCompany shCompany);
	public void updateShCompany(ShCompany shCompany);
	public void deleteShCompany(Integer companyId);
	public ShCompany findByCompanyId(Integer companyId);
	public Page<ShCompany>findByPage(Page<ShCompany>shCompany);
}
