package com.poc.webservices.rest.jersey2.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/")
public class ChildResource1 {

	@GET
	public Response getStatus() {
		System.out.println("Inside Child-1");
		String output = "REST-Child-1 Sub-Resource is invoked";
		return Response.status(200).entity(output).build();
	}
}
