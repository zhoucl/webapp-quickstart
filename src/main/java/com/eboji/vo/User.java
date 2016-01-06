package com.eboji.vo;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 8420800627951994715L;
	private String name;
	private String email;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", address="
				+ address + "]";
	}
}
