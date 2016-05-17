package com.eboji.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eboji.dao.HomeMapper;
import com.eboji.pojo.Home;
import com.eboji.pojo.HomeExample;
import com.eboji.service.HomeService;
import com.github.pagehelper.PageHelper;

@Service("homeService")
public class HomeServiceImpl implements HomeService {
	@Autowired
	private HomeMapper homeMapper;
	
	@Override
	public List<Home> selectHomeByExample(HomeExample he) {
		return homeMapper.selectByExample(he);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public List<Home> selectHomeByPager(HomeExample he) throws Exception {
		PageHelper.startPage(1, 10);
		homeMapper.selectByExample(null);
		
		Home record0 = new Home();
		record0.setHomedesc("dsdfs");
		
		int row = homeMapper.insertSelective(record0);
		
		if(row > 0) {
			throw new Exception("测试回滚");
		} else {
			Home record = new Home();
			record.setId(1);
			homeMapper.insert(record);
		}
		return homeMapper.selectByExample(he);
	}

}
