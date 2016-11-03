package com.poc.webservices.rest.jersey2.resources;

import javax.annotation.ManagedBean;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptors;
import javax.interceptor.InvocationContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * JAVA Class implementing REST resource for ManagedBeans
 * 
 * @author SrikarRao
 *
 */
@ManagedBean
@Path("/managedbean")
public class ManagedBeanResource {

	public static class MyInterceptor {
		@AroundInvoke
		public String around(InvocationContext ctx) throws Exception {
			System.out.println("around() called");
			return (String) ctx.proceed();
		}
	}

	@GET
	@Produces("text/plain")
	@Interceptors(MyInterceptor.class)
	public String getIt() {
		System.out.println("getIt() called");
		return "Hi managed bean!";
	}
}