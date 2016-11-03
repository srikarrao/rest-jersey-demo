package com.poc.webservices.rest.jersey.resources;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

/**
 * JAVA Progam to implement loading all the resources
 * 
 * @author SrikarRao
 *
 */
public class MyApplication extends Application {
	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(RestWSResources.class);
		return s;
	}
}