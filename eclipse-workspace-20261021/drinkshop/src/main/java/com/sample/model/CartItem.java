package com.sample.model;

import java.math.BigDecimal;

public class CartItem {

	private String sku ;
	private String name ;
	private BigDecimal price ;
	private int qty ;
	
	public CartItem() {
		super();
	}

	public CartItem(String sku, String name, BigDecimal price, int qty) {
		super();
		this.sku = sku;
		this.name = name;
		this.price = price;
		this.qty = qty;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public BigDecimal subtotal() {
		return price.multiply(BigDecimal.valueOf(qty)) ;
	}
	
}
