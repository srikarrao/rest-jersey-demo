package com.poc.webservices.rest.jersey2.resources;

import javax.ws.rs.Path;

@Path("/parent")
public class ParentResource {

	// http://localhost:8080/rest-jersey-2.0/resources/parent/child/object
	@Path("/child")
	public Object getChildContent() {
		System.out.println("Inside Parent");
		return new AnyResource();
	}
}
