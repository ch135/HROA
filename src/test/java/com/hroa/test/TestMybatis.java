package com.hroa.test;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hroa.model.EnterCom;
import com.hroa.service.EnterComService;
import com.hroa.util.Page;
import com.hroa.util.ServerTool;
public class TestMybatis {
	@Test
	public void test() { 
		Logger.getLogger(TestMybatis.class).info("test");
    }  
	
	@Test
	public  void Test1(){
//		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
//		EnterComService bean = (EnterComService)context.getBean("EnterComService");
//		bean.findById(1);
		try {
			ServerTool.connection();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
