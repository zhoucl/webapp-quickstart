package com.eboji.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eboji.dao.CfgServersMapper;
import com.eboji.pojo.CfgServers;
import com.eboji.pojo.CfgServersExample;
import com.eboji.service.ConfigService;

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
