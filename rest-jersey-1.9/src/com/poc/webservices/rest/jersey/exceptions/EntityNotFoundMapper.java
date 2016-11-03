/*package com.poc.webservices.rest.jersey.exceptions;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

*//**
 * JAVA Class to implement EntityNotFoundException
 * 
 * @author SrikarRao
 *
 *//*
@Provider
public class EntityNotFoundMapper implements
		ExceptionMapper<javax.persistence.EntityNotFoundException> {

	*//**
	 * method overridden to return the exception as response
	 *//*
	@Override
	public Response toResponse(EntityNotFoundException ex) {
		return Response.status(404).entity(ex.getMessage()).type("text/plain")
				.build();
	}
}*/