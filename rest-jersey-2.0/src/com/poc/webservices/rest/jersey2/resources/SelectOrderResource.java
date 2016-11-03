package com.poc.webservices.rest.jersey2.resources;

import javax.ws.rs.BeanParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import com.poc.webservices.rest.jersey2.models.OrderBean;

@Path("/beanParam")
// http://localhost:8080/rest-jersey-2.0/resources/beanParam/name/param;qty=100?id=1
public class SelectOrderResource {
	// Applies BeanParam annotation to the resource class property
	@BeanParam
	OrderBean orderBeanField;

	// Applies BeanParam annotation to the resource class bean property. This
	// can be applied to bean property or its setter method.
	@BeanParam
	private OrderBean orderBean;

	public OrderBean getOrderBean() {
		return orderBean;
	}

	// @BeanParam
	public void setOrderBean(OrderBean orderBean) {
		this.orderBean = orderBean;
	}

	// Applies BeanParam annotation to the method parameter
	@Path("{name}/param")
	@POST
	public String getOrderDetails(@BeanParam OrderBean orderBeanArg) {
		return printOrderDetails(orderBeanArg);
	}

	@Path("{name}/field")
	@POST
	public String getOrderDetails() {
		return printOrderDetails(orderBeanField);
	}

	@Path("{name}/method")
	@POST
	public String getOrderBeanDetails() {
		return printOrderDetails(getOrderBean());
	}

	private String printOrderDetails(OrderBean orderBeanArg) {
		StringBuilder builder = new StringBuilder();

		builder.append("Order ID:\t" + orderBeanArg.getOrderId());
		builder.append("\nOrder Name:\t" + orderBeanArg.getOrderName());
		builder.append("\nOrder Qty:\t" + orderBeanArg.getOrderQty());
		builder.append("\nItem Name:\t" + orderBeanArg.getItemName());

		return builder.toString();
	}
}