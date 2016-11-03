package com.poc.webservices.rest.jersey2.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

@Path("/asyncResource")
public class AsynchronousResource {

	@GET
	public void asyncGet(@Suspended final AsyncResponse asyncResponse) {

		new Thread(new Runnable() {
			@Override
			public void run() {
				String result = veryExpensiveOperation();
				asyncResponse.resume(result);
			}

			private String veryExpensiveOperation() {
				return "AsynchronousResource Successful!";
			}
		}).start();
	}
}
