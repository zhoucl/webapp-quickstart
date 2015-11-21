package com.eboji.basic.biz.impl;

import java.util.List;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eboji.basic.biz.HomeBiz;
import com.eboji.basic.config.Configuration;
import com.eboji.basic.pojo.CfgServers;
import com.eboji.basic.pojo.Home;
import com.eboji.basic.service.ConfigService;
import com.eboji.basic.service.HomeService;

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
		
		String[] str = new String[1024000];
		configComp.getMemcacheUtil().add(sessionID, JSONObject.fromObject(home).toString());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		logger.info("success ===> " + str.length);
		
		return true;
	}

	@Override
	public boolean main(String sessionID) {
		Object obj = configComp.getMemcacheUtil().get(sessionID);
		if(obj != null) {
			String session = obj.toString();
			Home home = (Home)JSONObject.toBean(JSONObject.fromObject(session), Home.class);
			logger.info(home.getHomelink() + "===>" + home.getHomedesc());
		}
		
		return true;
	}

}
