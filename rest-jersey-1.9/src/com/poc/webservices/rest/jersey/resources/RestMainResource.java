package com.poc.webservices.rest.jersey.resources;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * JAVA Class implementing a REST web service resource
 * 
 * @author SrikarRao
 *
 */
@Path("/mainResource")
public class RestMainResource {
	@Context
	UriInfo uriInfo;

	/**
	 * method to redirect the access to the sub resource
	 * 
	 * @return
	 */
	@Path("/content")
	public RestSubResource getRestSubResource() {
		System.out.println("Inside RestSubResource");
		return new RestSubResource();
	}
}