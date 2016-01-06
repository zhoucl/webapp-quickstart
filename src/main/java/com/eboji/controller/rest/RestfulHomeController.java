package com.eboji.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eboji.pojo.Home;
import com.eboji.pojo.HomeExample;
import com.eboji.service.HomeService;
import com.eboji.vo.BusinessLine;
import com.eboji.vo.RootVO;
import com.eboji.vo.User;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@RestController
@RequestMapping("/home/rest")
public class RestfulHomeController {
	private static final Logger logger = LoggerFactory.getLogger(RestfulHomeController.class.getPackage().getName());
	@Autowired
	private HomeService homeService;
	
	@RequestMapping(value = "/all/{page}", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<Home> all(@PathVariable("page") String page) {
		PageBounds pageBounds = new PageBounds(Integer.parseInt(page), 1, true);
		List<Home> homes = homeService.selectHomeByPager(null, pageBounds);
		
		logger.trace("index trace");
		logger.debug("index debug");
		logger.info("index info");
		logger.warn("index warn");
		logger.error("index error");
		if(homes != null && homes.size() > 0) {
			Home h = homes.get(0);
			for(int i = 0; i < 10000; i++) {
				homes.add(h);
			}
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
	
	@RequestMapping(value = "/xml", method = RequestMethod.GET)
	@ResponseBody
	public RootVO getRootVO() {
		RootVO rVo = new RootVO();
		List<BusinessLine> blList = new ArrayList<BusinessLine>();
		rVo.setBizLine(blList);
		for(int i = 0; i < 2; i++) {
			BusinessLine bl = new BusinessLine();
			bl.setId(String.valueOf(i));
			bl.setName("name" + i);
			blList.add(bl);
		}
		return rVo;
	}
	
	@RequestMapping(value = "/query", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public User query(@RequestParam String name, @RequestParam String email, 
			@RequestParam String address) {
		logger.info("query");
		
		logger.info(address);
		User u = new User();
		u.setName("NAME");
		u.setEmail("email@gmail.com");
		u.setAddress("北京");
		return u;
	}
	
	@RequestMapping(value = "/querybody", method = {RequestMethod.GET, RequestMethod.POST},
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public User queryBody(@RequestBody User body) {
		logger.info("querybody");
		
		logger.info(body.toString());
		
		logger.warn(body.getAddress());
		User u = new User();
		u.setName("NAME");
		u.setAddress("北京");
		return u;
	}
}