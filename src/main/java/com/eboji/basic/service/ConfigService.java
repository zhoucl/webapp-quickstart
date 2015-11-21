package com.eboji.basic.service;

import java.util.List;

import com.eboji.basic.pojo.CfgServers;

public interface ConfigService {
	public List<CfgServers> listMemcacheServers(int type);
}
