package com.sample.api.cart.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CartDto {

	public static class Item {
		
		public String sku ;
		public String name ;
		public BigDecimal price ;
		public int qty ;
		public BigDecimal subtotal ;
		
	}
	
	public List<Item> items = new ArrayList() ;
	public BigDecimal total = BigDecimal.ZERO ;
	
	
}
