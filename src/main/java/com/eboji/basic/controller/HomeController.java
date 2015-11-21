package com.eboji.basic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eboji.basic.biz.HomeBiz;

@Controller
@RequestMapping("/home")
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class.getPackage().getName());

	@Autowired
	private HomeBiz homeBiz;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response) {
		logger.debug("execute " + Thread.currentThread().getStackTrace()[1].getMethodName());
		
		boolean issuccess = homeBiz.index(request.getSession().getId());
		if(issuccess)
			return "index";
		return "index";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(HttpServletRequest request, HttpServletResponse response) {
		logger.debug("execute " + Thread.currentThread().getStackTrace()[1].getMethodName());
		
		boolean issuccess = homeBiz.main(request.getSession().getId());
		if(issuccess) {
			return "biz/index";
		}
		return "biz/index";
	}
}
