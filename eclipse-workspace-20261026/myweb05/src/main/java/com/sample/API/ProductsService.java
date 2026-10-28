package com.sample.API;


import com.sample.DAO.ProductDAO;
import com.sample.model.Message;
import com.sample.model.Product;
import java.util.List;

import jakarta.ws.rs.Produces;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("products")
public class ProductsService {
	
	//初始化ProductDAO
	private final ProductDAO dao = new ProductDAO() ;
	
	/*
	 *端點一：查詢所有上架/有效產品
	 **/
	@Path("all/rawdata")
	@GET
	@Produces("application/json ; charset=utf-8")
	public Response queryAllActiveProducts() {
		
		
		List<Product> list = dao.findAllActive() ;
		
		return Response.ok().header("status", "ok").encoding("utf-8").entity(list).build();
		
	}
	
	/*
	 *端點二：根據產品ID單獨查詢
	 **/
	@Path("productsqry/id/{product_id}/rawdata")
	@GET
	@Produces("application/json ; charset=utf-8")
	public Response productQryByID(@PathParam("product_id") Long productid) {
		
		// 檢查路徑參數是否有效傳入
			if(productid != null) {
				// 根據 ID 向資料庫查詢該筆產品
				Product p = dao.findById(productid);
				if(p != null) {
					return Response.ok().header("status", "ok").encoding("utf-8").entity(p).build();
				}else {
					// 若找不到該 ID 對應的產品，封裝錯誤訊息物件
					Message msg = new Message();
					msg.setMessage("沒有此產品編號!");
					msg.setCode(400);
					// 回應 HTTP 400 Bad Request，並夾帶 Message JSON 物件
					return Response.status(400).encoding("utf-8").entity(msg).build();
				}
			}else {
				// 若參數為空，封裝提示訊息
				Message msg = new Message();
				msg.setMessage("產品編號尚未輸入!");
				msg.setCode(404);
				// 回應 HTTP 404 Bad Request，並夾帶 Message JSON 物件
				return Response.status(404).encoding("utf-8").entity(msg).build();
			}
	}
}
