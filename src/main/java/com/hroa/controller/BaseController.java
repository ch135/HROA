package com.hroa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hroa.exception.HROAException;
public class BaseController {

	@ExceptionHandler(HROAException.class)
	public String handleException(Exception ex, HttpServletRequest request) {
		request.setAttribute("error", ex.getMessage());
		return "admin/error";
	}
	
}
