package com.eboji.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eboji.pojo.CfgServers;
import com.eboji.pojo.Home;
import com.eboji.pojo.HomeExample;
import com.eboji.service.ConfigService;
import com.eboji.service.HomeService;
import com.eboji.util.Constant;

@Component("configComp")
public class Configuration implements InitializingBean {
	private final static Logger logger = LoggerFactory.getLogger(Configuration.class.getPackage().getName());

	private String zookeeperURL = null;
	
	private Integer zookeeperTimeOut = null;
	
	private String zookeeperPath = null;
	
	@Autowired
	private HomeService homeService;
	
	@Autowired
	private ConfigService configService;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		//初始化bean后供调用的方法
		HomeExample he = new HomeExample();
		he.createCriteria().andIdEqualTo(1);
		List<Home> homeList = homeService.selectHomeByExample(he);
		logger.error(homeList.get(0).getHomedesc());
		
		List<CfgServers> cfgServers = configService.listMemcacheServers(Constant.ZOOKEEPER_TYPE);
		if(cfgServers != null && cfgServers.size() > 0) {
			zookeeperURL = cfgServers.get(0).getServer() + ":" + cfgServers.get(0).getPort();
			zookeeperTimeOut = cfgServers.get(0).getWeight();
			zookeeperPath = cfgServers.get(0).getServername();
		}
	}

	public String getZookeeperURL() {
		return zookeeperURL;
	}

	public Integer getZookeeperTimeOut() {
		return zookeeperTimeOut;
	}

	public String getZookeeperPath() {
		return zookeeperPath;
	}
}
