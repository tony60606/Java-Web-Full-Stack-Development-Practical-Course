package com.sample.api.order;

import java.sql.Connection;
import java.sql.SQLException;

import com.sample.DAO.OrderDAO;
import com.sample.api.order.dto.OrderResult;
import com.sample.model.Cart;
import com.sample.model.Member;
import com.sample.util.DButil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

	private OrderDAO dao = new OrderDAO() ;
	
	@POST
	@Path("/checkout")
	public Response checkout(@Context HttpServletRequest req) {
		
		//需先登入
		HttpSession session = req.getSession(false) ;
		if(session == null) {
			return Response.status(404).entity("未登入").build() ;
		}
		
		//若有登入,取的Member物件
		Member member = (Member)session.getAttribute("loginMember") ;
		if(member == null) {
			return Response.status(404).entity("未登入").build() ;
		}
		
		long memberId = member.getMemberID() ;
		
		//取得購物車
		Cart cart = (Cart) session.getAttribute("cart") ;
		if(cart == null || cart.getItems().isEmpty()) {
			return Response.status(400).entity("購物車為空").build() ;
		}
		
		try(Connection conn = DButil.getConnection()) {
			conn.setAutoCommit(false) ; //關閉自動提交
			OrderResult result = dao.createOrder(conn, memberId, cart) ;
			conn.commit() ;
			
			//清空購物車
			cart.getItems().clear() ;
			
			//WebSocket通知
			
			return Response.ok(result).build() ;
			
		} catch (SQLException ex) {
			ex.printStackTrace() ;
			return Response.serverError().entity("結帳失敗").build() ;
		}	
		
	}
	
	
}
