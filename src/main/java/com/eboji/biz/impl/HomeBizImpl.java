package com.eboji.biz.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.eboji.biz.HomeBiz;
import com.eboji.config.Configuration;
import com.eboji.pojo.CfgServers;
import com.eboji.pojo.Home;
import com.eboji.service.ConfigService;
import com.eboji.service.HomeService;

@Component("homeBiz")
public class HomeBizImpl implements HomeBiz {
	private static final Logger logger = LoggerFactory
			.getLogger(HomeBizImpl.class.getName());

	@Autowired
	private HomeService homeService;

	@Autowired
	private ConfigService configService;
	
	@Autowired
	private Configuration configComp;

	@Override
	@Transactional
	public boolean index(String sessionID) {
		List<Home> homes = homeService.selectHomeByExample(null);
		List<CfgServers> cfgs = configService.listMemcacheServers(0);

		logger.info("loginBiz..." + (homes != null ? homes.size() : 0) + ""
				+ (cfgs != null ? cfgs.size() : 0));
		
		Home home = new Home();
		home.setId(10);
		home.setHomelink("http://www.baidu.com");
		home.setHomedesc("desc");
		home.setRemark("remark");
		
		try {
			Thread.sleep(5000);
			Home h = new Home();
			h.setHomedesc(home.getHomedesc());
			h.setHomelink(home.getHomelink());
			h.setRemark(home.getRemark());
			homeService.insertHome(h);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return true;
	}

	@Override
	public boolean main(String sessionID) {
		return true;
	}

}
