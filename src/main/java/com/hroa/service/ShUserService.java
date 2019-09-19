package com.hroa.service;

import com.hroa.model.ShUser;
import com.hroa.util.Page;

public interface ShUserService {
	public void addShUser(ShUser ShUser);
	public void updateShUser(ShUser ShUser);
	public void deleteShUser(Integer shUserId);
	public ShUser findByUserId(Integer companyId);
	public ShUser findByTelephone(String telephone);
	public Page<ShUser>findByPage(Page<ShUser>ShUser);
}
