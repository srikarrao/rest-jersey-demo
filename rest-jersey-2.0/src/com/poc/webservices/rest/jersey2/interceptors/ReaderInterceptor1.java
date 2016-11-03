package com.poc.webservices.rest.jersey2.interceptors;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;

@Provider
public class ReaderInterceptor1 implements ReaderInterceptor {

	@Override
	public Object aroundReadFrom(ReaderInterceptorContext interceptorContext)
			throws IOException, WebApplicationException {
		System.out.println("ReaderInterceptor1 invoked");
		System.out.println();
		InputStream inputStream = interceptorContext.getInputStream();
		byte[] bytes = new byte[inputStream.available()];
		inputStream.read(bytes);
		String requestContent = new String(bytes);
		requestContent = requestContent
				+ "\nRequest changed in ReaderInterceptor1.";
		interceptorContext.setInputStream(new ByteArrayInputStream(
				requestContent.getBytes()));
		return interceptorContext.proceed();
	}
}
