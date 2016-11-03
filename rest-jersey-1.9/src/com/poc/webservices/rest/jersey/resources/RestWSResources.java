package com.poc.webservices.rest.jersey.resources;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import com.poc.webservices.rest.jersey.exceptions.NotFoundException;
import com.poc.webservices.rest.jersey.models.RestDB;

/**
 * JAVA Class representing rest-jersey-1.9 implementation
 * 
 * @author SrikarRao
 *
 */
@Path("/ws")
public class RestWSResources {

	/**
	 * Method to return Response setting status to 200
	 * 
	 * http://localhost:8080/rest-jersey-1.9/resources/ws/getPath/loop1
	 * 
	 * @param pathName
	 * @return
	 */
	@GET
	@Path("getPath/{pathName: [a-zA-Z][a-zA-Z_0-9]*}")
	public Response getPath(@PathParam("pathName") String pathName) {
		String output = "Service invoked by " + pathName;
		return Response.status(200).entity(output).build();
	}

	/**
	 * Method to return a hello world message
	 * 
	 * http://localhost:8080/rest-jersey-1.9/resources/ws/
	 * 
	 * @return
	 */
	@GET
	@Produces({ "text/plain", "application/json" })
	public String getMessage() {
		return "Welcome to Hello World!";
	}

	/**
	 * Method to post a message
	 * http://localhost:8080/rest-jersey-1.9/resources/ws/postMessage
	 * 
	 * @param message
	 */
	@POST
	@Path("/postMessage")
	@Consumes("text/plain")
	public void postClichedMessage(String message) {
		System.out.println("Successfully posted message: " + message);
	}

	/**
	 * Method to implement Query param with default values
	 * http://localhost:8080/
	 * rest-jersey-1.9/resources/ws/colors?has-color=true&color
	 * =white&orderBy=age&orderBy=name
	 * 
	 * @return
	 */
	@Path("/colors")
	@GET
	public Response getAColor(
			@DefaultValue("false") @QueryParam("has-color") boolean hasColor,
			@DefaultValue("red") @QueryParam("color") String color,
			@QueryParam("orderBy") List<String> orderBy) {
		System.out.println("has Color? " + hasColor);
		String output = "Color: " + color + "; OrderBy: " + orderBy.toString();
		return Response.status(200).entity(output).build();
	}

	/**
	 * method implementing QueryParam; input as list
	 * http://localhost:8080/rest-jersey-1.9
	 * /resources/ws/getList?list=1&list=20&list=1221
	 * 
	 * @param integerList
	 * @return
	 */
	@Path("/getList")
	@GET
	public Response getListData(@QueryParam("list") List<Integer> integerList) {
		int sum = 0;
		for (Integer i : integerList) {
			sum += i;
		}
		String output = "Sum from IntegerList is: " + sum;
		System.out.println(output);
		return Response.status(200).entity(output).build();
	}

	/**
	 * method to get query and path params using UriInfo
	 * http://localhost:8080/rest-jersey-1.9/resources/ws/contextDetails
	 * ?parameter1=JCG&parameter2=abcd&parameter2=abcd2
	 * 
	 * @param ui
	 * @return
	 */
	@Path("/contextDetails")
	@GET
	public String get(@Context UriInfo ui) {
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		MultivaluedMap<String, String> pathParams = ui.getPathParameters();
		String output = "output-->";
		for (String key : pathParams.keySet()) {
			System.out.println(pathParams.get(key));
			output = output + " : " + pathParams.get(key);
		}
		System.out.println("----------------------");

		// Incomplete and to-do
		for (String key : queryParams.keySet()) {
			System.out.println(queryParams.get(key));
			output = output + " : " + queryParams.get(key);
		}
		return output;
	}

	/**
	 * Method to get HttpHeaders using Context
	 * http://localhost:8080/rest-jersey-1.9/resources/ws/httpHeaders
	 * 
	 * @param headers
	 * @return
	 */
	@GET
	@Path("/httpHeaders")
	public Response getHttpHeaders(@Context HttpHeaders headers) {

		MultivaluedMap<String, String> headerParams = headers
				.getRequestHeaders();

		for (String key : headerParams.keySet()) {
			System.out.print(headerParams.get(key) + " ");
		}
		Map<String, Cookie> pathParams = headers.getCookies();

		System.out.println();
		System.out.println("--------COOKIES------");

		for (String key : pathParams.keySet()) {
			System.out.println(headerParams.get(key) + " ");
		}
		System.out.println("--------ALL Headers------------");
		System.out.println(headers.getRequestHeaders().toString());
		String userAgent = headers.getRequestHeader("user-agent").get(0);
		return Response.status(200)
				.entity("user is called, userAgent : " + userAgent).build();
	}

	/**
	 * Method to get header params
	 * http://localhost:8080/rest-jersey-1.9/resources/ws/headerParams
	 * 
	 * @param userAgent
	 * @return
	 */
	@GET
	@Path("/headerParams")
	public Response addUser(@HeaderParam("user-agent") String userAgent) {
		return Response.status(200)
				.entity("User is called, userAgent : " + userAgent).build();
	}

	/**
	 * Method to post multi valued form param
	 * http://localhost:8080/rest-jersey-1.9/formParamMultiVal.html
	 * 
	 * @param parameter1
	 * @return
	 */
	@POST
	@Path("/mutliValFormParam")
	public Response mutliValuedFormParam(
			MultivaluedMap<String, String> parameter1) {
		String output = " Form parameters :\n";
		for (String key : parameter1.keySet()) {
			output += key + " : " + parameter1.getFirst(key) + "\n";
		}
		return Response.status(200).entity(output).build();
	}

	/**
	 * method to post form params and URL:
	 * http://localhost:8080/rest-jersey-1.9/formParam.html
	 * 
	 * @param fname
	 * @param lname
	 * @return
	 */
	@POST
	@Path("/formParams")
	public Response responseMsg(@FormParam("fname") String fname,
			@FormParam("lname") String lname) {
		String output = "This all the info about " + fname + " " + lname;
		return Response.status(200).entity(output).build();
	}

	/**
	 * Method to get/download images
	 * http://localhost:8080/rest-jersey-1.9/resources/ws/getImage/style5
	 * 
	 * @param imageName
	 * @return
	 */
	@GET
	@Path("/getImage/{imageName}")
	@Produces("image/*")
	public Response getImage(@PathParam("imageName") String imageName) {
		String FILE_PATH = "C:\\Users\\SrikarRao\\Dropbox\\Styles\\"
				+ imageName + ".jpg";
		File file = new File(FILE_PATH);
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
				"attachment; filename=image_from_server.png");
		return response.build();
	}

	/**
	 * method implementing the customized exceptions
	 * http://localhost:8080/rest-jersey-1.9/resources/ws/exception/102
	 * 
	 * @param index
	 * @return
	 */
	@GET
	@Path("/exception/{index}")
	public String getRestData(@PathParam("index") int index) {
		RestDB restDB = new RestDB();
		String responseData = restDB.getData(index);
		if (responseData == null) {
			throw new NotFoundException("ResponseData for index: " + index
					+ " is not found");
		}
		return responseData;
	}
}