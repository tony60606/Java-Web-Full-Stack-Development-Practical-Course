package com.sample.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.api.order.dto.OrderDetailDto;

public class OrderQueryDAO {

	public List<OrderDetailDto> findorders(Connection conn , long memberId) throws SQLException {
		
		String sql = "SELECT * FROM v_order_detail WHERE member_id = ? ORDER BY created_at DESC , order_item_id" ;
		
		List<OrderDetailDto> list = new ArrayList<>() ;
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setLong(1, memberId);
			
			try(ResultSet rs = pstmt.executeQuery()) {
				
				while(rs.next()) {
					list.add(map(rs)) ;	
				}
				
			}
		}
		
		return list ;
	} 
	
	public List<OrderDetailDto> findordernumber(Connection conn , long memberId , String orderNo) throws SQLException {
		
		String sql = "SELECT * FROM v_order_detail WHERE member_id = ? AND order_no = ? ORDER BY order_item_id" ;
		
		List<OrderDetailDto> list = new ArrayList<>() ;
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setLong(1, memberId);
			pstmt.setString(2, orderNo);
		
			try(ResultSet rs = pstmt.executeQuery()) {
				
				while(rs.next()) {
					list.add(map(rs)) ;	
				}
				
			}
		}
		return list ;
	}
	
	
	private OrderDetailDto map(ResultSet rs) throws SQLException {
		
		OrderDetailDto odd = new OrderDetailDto() ;
		odd.orderId = rs.getLong("order_id") ;
		odd.orderNo = rs.getString("order_no") ;
		odd.memberId = rs.getLong("member_id") ;
		odd.displayname = rs.getString("display_name") ;
		odd.status = rs.getString("status") ;
		odd.totalAmount = rs.getBigDecimal("total_amount") ;
		odd.createAt = rs.getTimestamp("created_at").toLocalDateTime() ;
		odd.orderItemId = rs.getLong("order_item_id") ;
		odd.sku = rs.getString("sku") ;
		odd.productName = rs.getString("product_name") ;
		odd.unitprice = rs.getBigDecimal("unit_price") ;
		odd.quantity = rs.getInt("quantity") ;
		odd.lineAmount = rs.getBigDecimal("line_amount") ;
		return odd ;
		
	}
	
}
