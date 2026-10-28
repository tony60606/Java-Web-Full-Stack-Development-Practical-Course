package com.sample.model;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {

	private final Map<String , CartItem> items = new LinkedHashMap<>() ;

	public Map<String , CartItem> getItems() {
		return items ;
	}
	
	public void addItem(Product p , int qty) {
		CartItem it = items.get(p.getSku()) ;
		
		if(it == null) {
			it = new CartItem(p.getSku(),p.getName(),p.getPrice(),0) ;
			items.put(p.getSku(),it) ;
		}
		
		it.setQty(it.getQty() + qty) ; 
	}
	
	public void UpdateQty(String sku , int qty) {
		if(qty <= 0) {
			items.remove(sku) ;
			return ;
		}
		
		CartItem it = items.get(sku) ;
		if(it != null) {
			it.setQty(qty);
		}
	}
	
	public void RemoveItem(String sku) {
		items.remove(sku) ;
	}
	
	public BigDecimal gettotal() {
		BigDecimal total = BigDecimal.ZERO ;
		for (CartItem it : items.values()) {
			total = total.add(it.subtotal()) ;
		}
		return total ;
	}
	
}
