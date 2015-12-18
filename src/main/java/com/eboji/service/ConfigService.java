package com.eboji.service;

import java.util.List;

import com.eboji.pojo.CfgServers;

public interface ConfigService {
	public List<CfgServers> listMemcacheServers(int type);
}
