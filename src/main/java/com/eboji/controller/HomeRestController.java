package com.eboji.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eboji.pojo.Home;
import com.eboji.pojo.HomeExample;
import com.eboji.service.HomeService;

@RestController
@RequestMapping("/home/rest")
public class HomeRestController {
	@Autowired
	private HomeService homeService;
	
	@RequestMapping(value = "/all/{page}", method = RequestMethod.GET)
	@ResponseBody
	public List<Home> all(@PathVariable("page") String page) {
		List<Home> homes = new ArrayList<Home>();;
		try {
			homes = homeService.selectHomeByPager(null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return homes;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Home index(@PathVariable("id") String id) {
		HomeExample he = new HomeExample();
		he.createCriteria().andIdEqualTo(Integer.parseInt(id));

		List<Home> homeList = homeService
				.selectHomeByExample(he);
		if (homeList != null && !homeList.isEmpty()) {
			return homeList.get(0);
		} else {
			return null;
		}
	}
}
