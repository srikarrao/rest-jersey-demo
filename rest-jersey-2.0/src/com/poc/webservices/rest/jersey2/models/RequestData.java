package com.poc.webservices.rest.jersey2.models;

import java.io.Serializable;

public class RequestData implements Serializable {

	private static final long serialVersionUID = 1144442844200L;

	private int age;
	private String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
