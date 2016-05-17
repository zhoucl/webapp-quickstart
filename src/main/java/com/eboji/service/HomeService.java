package com.eboji.service;

import java.util.List;

import com.eboji.pojo.Home;
import com.eboji.pojo.HomeExample;

public interface HomeService {
	List<Home> selectHomeByExample(HomeExample he);
	
	List<Home> selectHomeByPager(HomeExample he) throws Exception;
}
