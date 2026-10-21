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



public class OrderDAO {

	public OrderResult createOrder(Connection conn , long memberId , Cart cart) throws SQLException {
		
		String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) ;
		String orderNo = ts + "-" + (memberId %10000) ;
		
		String sqlOrder = "INSERT INTO orders(order_id , member_id , status , total_amount) VALUES (? ,? ,'PAID' , ?)" ;
		
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
		
		return null ;
	}
}
