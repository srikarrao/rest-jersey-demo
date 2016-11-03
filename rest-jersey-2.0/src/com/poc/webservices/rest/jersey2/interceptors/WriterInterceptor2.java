package com.poc.webservices.rest.jersey2.interceptors;

import java.io.IOException;
import java.io.OutputStream;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

@Provider
public class WriterInterceptor2 implements WriterInterceptor {

	@Override
	public void aroundWriteTo(WriterInterceptorContext interceptorContext)
			throws IOException, WebApplicationException {
		System.out.println("WriterInterceptor2 invoked");
		System.out.println();
		OutputStream outputStream = interceptorContext.getOutputStream();
		String responseContent = "\nResponse changed in WriterInterceptor2.";
		outputStream.write(responseContent.getBytes());
		interceptorContext.setOutputStream(outputStream);
		interceptorContext.proceed();
	}
}
