package com.poc.webservices.rest.jersey2.models;

import javax.ws.rs.FormParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

// Here the injection parameters can be used either on field or setter methods
public class OrderBean {

	// @QueryParam("id")
	private int orderId;
	// @PathParam("name")
	private String orderName;
	// @FormParam("item")
	private String itemName;
	// @MatrixParam("qty")
	private int orderQty;

	public int getOrderId() {
		return orderId;
	}

	@QueryParam("id")
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	@PathParam("name")
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public int getOrderQty() {
		return orderQty;
	}

	@MatrixParam("qty")
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	public String getItemName() {
		return itemName;
	}

	@FormParam("item")
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
}
