package com.eboji.basic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eboji.basic.dao.HomeMapper;
import com.eboji.basic.pojo.Home;
import com.eboji.basic.pojo.HomeExample;
import com.eboji.basic.service.HomeService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Service("homeService")
public class HomeServiceImpl implements HomeService {
	@Autowired
	private HomeMapper homeMapper;
	
	@Override
	public List<Home> selectHomeByExample(HomeExample he) {
		return homeMapper.selectByExample(he, new PageBounds());
	}

	@Override
	public List<Home> selectHomeByPager(HomeExample he, PageBounds pageBounds) {
		return homeMapper.selectByExample(he, pageBounds);
	}

}
