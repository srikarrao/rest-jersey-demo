package com.poc.webservices.rest.jersey2.resources;

import javax.ws.rs.GET;
import javax.ws.rs.core.Response;

public class ChildResource2 {

	@GET
	public Response getStatus() {
		String output = "REST-Child-2 Sub-Resource is invoked";
		return Response.status(200).entity(output).build();
	}
}
