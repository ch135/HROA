package com.hroa.listener;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.hroa.util.ServerTool;

public class SystemInit implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("系统停止");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("系统初始化");
		try {
			ServerTool.connection();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("系统初始化完成");
	}

}
