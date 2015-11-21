package com.eboji.basic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eboji.basic.dao.CfgServersMapper;
import com.eboji.basic.pojo.CfgServers;
import com.eboji.basic.pojo.CfgServersExample;
import com.eboji.basic.service.ConfigService;

@Service("configService")
public class ConfigServiceImpl implements ConfigService {
	@Autowired
	private CfgServersMapper cfgServersMapper;
	
	@Override
	public List<CfgServers> listMemcacheServers(int type) {
		CfgServersExample cse = new CfgServersExample();
		cse.createCriteria().andTypeEqualTo(type);
		return cfgServersMapper.selectByExample(cse);
	}

}
