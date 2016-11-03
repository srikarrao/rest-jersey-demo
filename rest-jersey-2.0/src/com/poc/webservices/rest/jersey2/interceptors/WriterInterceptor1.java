package com.poc.webservices.rest.jersey2.interceptors;

import java.io.IOException;
import java.io.OutputStream;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

@Provider
public class WriterInterceptor1 implements WriterInterceptor {

	@Override
	public void aroundWriteTo(WriterInterceptorContext interceptorContext)
			throws IOException, WebApplicationException {
		System.out.println("WriterInterceptor1 invoked");
		System.out.println();
		OutputStream outputStream = interceptorContext.getOutputStream();
		String responseContent = "\nResponse changed in WriterInterceptor1.";
		outputStream.write(responseContent.getBytes());
		interceptorContext.setOutputStream(outputStream);
		interceptorContext.proceed();
	}
}
