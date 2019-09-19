package com.hroa.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hroa.service.TestService;
import com.hroa.util.LoggerManager;

@Controller
@RequestMapping("test")
public class TestController extends BaseController{
	@Resource  
    private TestService testMybatisService;  
    @RequestMapping("testMybatis")
    public String testMybatis(HttpServletRequest request,Model model){
    	int amount=testMybatisService.testMybatis();
    	/*LogManager.getLogger(TestController.class).log(Level.INFO,"amount");*/
    	/*Logger.getLogger(TestController.class).info("amount");*/
    	Logger log =LoggerManager.getLogger(TestController.class); 
        log.setLevel(Level.INFO); 
        log.info("amount:"+amount); 
        return Integer.toString(amount); 
    }
}
