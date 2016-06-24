package com.eboji.controller.jsonp;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JSONPController {
	@RequestMapping(value ="/jsonp1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Person jsonp1() {
		Person p = new Person();
		p.setId(1);
		p.setName("张三");
		p.setSex("M");
		System.out.println("=========");
		return p;
	}
}

class Person {
	private int id;
	private String name;
	private String sex;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
