package com.sample.api.cart;

import com.sample.DAO.ProductDAO;
import com.sample.api.cart.dto.AddItemRequest;
import com.sample.api.cart.dto.CartDto;
import com.sample.model.Cart;
import com.sample.model.CartItem;
import com.sample.model.Product;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cart")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CartResource {
	
	private final ProductDAO dao = new ProductDAO() ;
	
	//取得購物車(給badge使用)
	@GET
	public Response getCart(@Context HttpServletRequest req) {
		
		Cart cart = getOrCreateCart(req) ;
		return Response.ok(todto(cart)).build() ;
		
	}
	
	//加入購物車：POST /api/cart/items
	@Path("/items")
	@POST
	public Response additem(AddItemRequest body , @Context HttpServletRequest req) {
		if (body == null || body.sku == null || body.sku.isBlank() || body.qty <= 0) {
			return Response.status(Response.Status.BAD_REQUEST).entity(error("BAD_REQUEST","sku/qry inalid")).build() ;
		}
		Product p = dao.findBySku(body.sku) ;
		if(p == null) {
			return Response.status(Response.Status.NOT_FOUND).entity(error("NOT_FOUND","Product Not Found")).build() ;
		}
		
		Cart cart = getOrCreateCart(req) ;
		cart.addItem(p, body.qty) ;
		
		return Response.ok(todto(cart)).build() ;
 	}
	
	//更新數量：PUT /api/cart/items/(sku)
	@Path("/items/{sku}")
	@PUT
	public Response updateQTY(@PathParam("sku") String sku , AddItemRequest body , @Context HttpServletRequest req) {
		if (body == null || body.sku == null || body.sku.isBlank() || body.qty < 0) {
			return Response.status(Response.Status.BAD_REQUEST).entity(error("BAD_REQUEST","sku/qry inalid")).build() ;
		}
		
		Cart cart = getOrCreateCart(req) ;
		cart.UpdateQty(sku, body.qty) ;
		
		return Response.ok(todto(cart)).build() ;
	}
	
	//刪除數量：Delete /api/cart/items/(sku)
	@Path("/items/{sku}")
	@DELETE
	public Response deleteQTY(@PathParam("sku") String sku , @Context HttpServletRequest req) {
		Cart cart = getOrCreateCart(req) ;
		cart.RemoveItem(sku);
		
		return Response.ok(todto(cart)).build() ;
	}
	

	private CartDto todto(Cart cart) {
		CartDto dto = new CartDto() ;
		for (CartItem it : cart.getItems().values()) {
			CartDto.Item d = new CartDto.Item() ;
			d.sku = it.getSku() ;
			d.name = it.getName() ;
			d.price = it.getPrice() ;
			d.qty = it.getQty() ;
			d.subtotal = it.subtotal() ;
			dto.items.add(d) ;
		}
		dto.total = cart.gettotal() ;
		return dto ;
	}

	//建立共用方法
	private Cart getOrCreateCart(HttpServletRequest req) {
		
		HttpSession session = req.getSession(true) ;
		Cart cart = (Cart)session.getAttribute("cart");
		if(cart == null) {
			cart = new Cart() ;
			session.setAttribute("cart", cart);
		}
		return cart ;
		
	}
	
	private static class ErrorDto{
		public String code ;
		public String message ;
		public ErrorDto(String code , String message) {
			super() ;
			this.code = code ;
			this.message = message ;
		}
		
	}
	
	private ErrorDto error(String code , String message) {
		return new ErrorDto(code , message) ;
	}
	
}
