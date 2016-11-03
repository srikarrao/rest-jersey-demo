package com.poc.webservices.rest.jersey.resources;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 * JAVA Class representing the implementation of a REST sub-resource
 * 
 * @author SrikarRao
 *
 */
public class RestSubResource {

	/**
	 * method to implement sub resource GET
	 * http://localhost:8080/rest-jersey/rest/mainResource/content/
	 * 
	 * @return
	 */
	@GET
	public Response getStatus() {
		String output = "REST Sub-Resource is invoked";
		return Response.status(200).entity(output).build();
	}

	/**
	 * method to implement sub resource PUT
	 * http://localhost:8080/rest-jersey/resources/mainResource/content/2
	 * 
	 * @param version
	 * @param headers
	 * @param in
	 */
	@PUT
	@Path("/{version}")
	public void putData(@PathParam("version") int version,
			@Context HttpHeaders headers, byte[] in) {

		System.out.println("Path Param is: " + version);
		MultivaluedMap<String, String> headerParams = headers
				.getRequestHeaders();
		for (String key : headerParams.keySet()) {
			System.out.print(headerParams.get(key) + " ");
		}
	}
}