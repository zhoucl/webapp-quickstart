package com.eboji.basic.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.eboji.basic.BaseTestCase;
import com.eboji.basic.pojo.Home;
import com.eboji.basic.pojo.HomeExample;
import com.eboji.basic.service.HomeService;

public class ServiceOfHomeTest extends BaseTestCase {
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private HomeService homeService;
	
	@Test
	public void getHome() {
		HomeExample he = new HomeExample();
		he.createCriteria().andIdEqualTo(1);
		List<Home> home = homeService.selectHomeByExample(he);
		Assert.assertEquals(home.size() > 0,  true);
	}
}
