package com.sample.api.order.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderDetailDto {

	public long orderId ;
	public String orderNo ;
	public long memberId ;
	public String displayname ;
	public String status ;
	public BigDecimal totalAmount ;
	public LocalDateTime createAt ;
	public long orderItemId ;
	public String sku ;
	public String productName ;
	public BigDecimal unitprice ;
	public int quantity ;
	public BigDecimal lineAmount ;
}
