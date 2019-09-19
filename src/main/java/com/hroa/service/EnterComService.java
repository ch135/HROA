package com.hroa.service;

import com.hroa.model.EnterCom;
import com.hroa.util.Page;

public interface EnterComService {
	public void addEnterCom(EnterCom EnterCom);

	public void updateEnterCom(EnterCom EnterCom);

	public void deleteEnterCom(Integer EnterComId);

	public EnterCom findById(Integer companyId);
	
	public EnterCom findByTelephone(String telephone);

	public Page<EnterCom> findByPage(Page<EnterCom> EnterCom);

	Integer[] getReadNum(EnterCom enterCom);
}
