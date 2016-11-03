package com.poc.webservices.rest.jersey2.resources;

import javax.ws.rs.GET;
import javax.ws.rs.WebApplicationException;

public class AnyResource {

	@GET
	public Object getContent() {
		int x = 10;
		System.out.println("Inside Any-Resource");
		if (x == 10) {
			return new ChildResource1();
		} else {
			new ChildResource2();
		}
		throw new WebApplicationException("Unauthroized resource");
	}

}