package com.poc.webservices.rest.jersey2.resources;

import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/interceptor")
public class InterceptorResource {

	@Path("/postMessage")
	@POST
	public Response testInterceptor(String inputMessage) {
		System.out.println("Inside  InterceptorResource: " + inputMessage);

		Response response = Response.ok("\nOrder successfully placed")
				.status(Status.OK).build();

		return response;
	}
}