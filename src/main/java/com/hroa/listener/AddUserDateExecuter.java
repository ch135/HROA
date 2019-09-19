package com.hroa.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hroa.controller.UserSignController;

/**
 * @author chenhao
 * @date 2017/6/30 上午 10：17
 * 零晨三点添加用户数据
 */

public class AddUserDateExecuter implements Executer{
	
	private static Logger log = LoggerFactory.getLogger(AddUserDateExecuter.class);

	@Override
	public void executer() {
		log.debug("begin add user date");
		boolean flag=UserSignController.AddUserDate(); //责行的操作
		log.debug("finish add user date,flag:"+flag);
	}
}
