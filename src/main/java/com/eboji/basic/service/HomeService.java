package com.eboji.basic.service;

import java.util.List;

import com.eboji.basic.pojo.Home;
import com.eboji.basic.pojo.HomeExample;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface HomeService {
	List<Home> selectHomeByExample(HomeExample he);
	
	List<Home> selectHomeByPager(HomeExample he, PageBounds pageBounds);
	
	void insertHome(Home home) throws Exception;
}
