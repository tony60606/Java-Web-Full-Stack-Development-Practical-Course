package com.sample.api.order.dto;

public class OrderResult {

	private long orderId ;
	private String orderNo ;
	
	public OrderResult(long orderId, String orderNo) {
		super();
		this.orderId = orderId;
		this.orderNo = orderNo;
	}

	public long getOrderId() {
		return orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}
	
	
}
