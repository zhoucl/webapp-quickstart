package com.eboji.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eboji.dao.HomeMapper;
import com.eboji.pojo.Home;
import com.eboji.pojo.HomeExample;
import com.eboji.service.HomeService;
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
	@Transactional
	public List<Home> selectHomeByPager(HomeExample he, PageBounds pageBounds) {
		return homeMapper.selectByExample(he, pageBounds);
	}

	@Override
	public void insertHome(Home home) throws Exception {
		int count = homeMapper.insertSelective(home);
		System.out.println(count);
		throw new Exception("产生异常，需要进行回滚!");
	}
}
