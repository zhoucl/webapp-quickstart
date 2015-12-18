package com.eboji.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.eboji.BaseTestCase;
import com.eboji.pojo.Home;
import com.eboji.pojo.HomeExample;
import com.eboji.service.HomeService;

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
