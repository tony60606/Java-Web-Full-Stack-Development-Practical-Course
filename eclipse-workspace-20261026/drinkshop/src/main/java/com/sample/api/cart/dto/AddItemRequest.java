package com.sample.api.cart.dto;

public class AddItemRequest {

	public String sku ;
	public int qty ;
	
	public AddItemRequest() {
		super();
	}

	public AddItemRequest(String sku, int qty) {
		super();
		this.sku = sku;
		this.qty = qty;
	}
	
	
}
