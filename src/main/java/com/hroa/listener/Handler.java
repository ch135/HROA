package com.hroa.listener;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 计数器操作类，负责责行executer
 */
public class Handler {
	private static Logger log=LoggerFactory.getLogger(Handler.class);

	private AddUserDateExecuter adduserdate;

	public void setAdduserdate(AddUserDateExecuter adduserdate) {
		this.adduserdate = adduserdate;
	}

	public void executer(){
		try{
			adduserdate.executer();
			log.debug(String.format("success exxcute:%s", adduserdate.toString()));
		}catch(Exception e){
			e.printStackTrace();
			log.debug("exception executiing:"+adduserdate.toString());
			StringWriter sw=new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			log.error(sw.toString());
		}
	}
}
