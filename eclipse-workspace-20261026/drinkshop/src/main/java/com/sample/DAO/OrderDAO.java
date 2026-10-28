package com.sample.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.sample.api.order.dto.OrderResult;
import com.sample.model.Cart;
import com.sample.model.CartItem;



public class OrderDAO {

	public OrderResult createOrder(Connection conn , long memberId , Cart cart) throws SQLException {
		
		String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) ;
		String orderNo = ts + "-" + (memberId %10000) ;
		
		String sqlOrder = "INSERT INTO orders(order_no , member_id , status , total_amount) VALUES (? ,? ,'PAID' , ?)" ;
		
		long OrderId ;
		
		try(PreparedStatement pstmt = conn.prepareStatement(sqlOrder , Statement.RETURN_GENERATED_KEYS)) {
			
			pstmt.setString(1, orderNo);
			pstmt.setLong(2, memberId);
			pstmt.setBigDecimal(3, cart.gettotal());
			pstmt.executeUpdate() ;
			
			ResultSet rs = pstmt.getGeneratedKeys() ;
			rs.next() ;
			OrderId = rs.getLong(1) ;
		}
		
		//建立訂單明細
		String sqlitem = "INSERT INTO order_items(order_id , product_id , unit_price , quantity , line_amount) VALUES (? , ? , ? ,? ,?)" ;
		
		try(PreparedStatement pstmt = conn.prepareStatement(sqlitem)) {
			
			for (CartItem it : cart.getItems().values()) {
				long product_id = findproductID(conn, it.getSku()) ;
				pstmt.setLong(1, OrderId);
				pstmt.setLong(2, product_id);
				pstmt.setBigDecimal(3, it.getPrice());
				pstmt.setInt(4, it.getQty());
				pstmt.setBigDecimal(5, it.subtotal());
				pstmt.addBatch();
			}
			pstmt.executeBatch() ;
			
		}
		
		return new OrderResult(OrderId , orderNo) ;
	}
	
	//由sku找出ProductID
	private long findproductID(Connection conn ,String sku) throws SQLException {
		
		String sql = "SELECT product_id FROM products WHERE sku = ? " ;
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, sku);
			try (ResultSet rs = pstmt.executeQuery()) {
				if(!rs.next()) {
					throw new SQLException("找不到該商品sku" + sku) ;
				}
				return rs.getLong("product_id") ;
			}
			
		}
		
	}
}
