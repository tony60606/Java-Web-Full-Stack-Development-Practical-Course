package com.sample.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.model.Product;
import com.sample.util.DButil;

public class ProductDAO {

	//查詢所有商品
	public List<Product> findAllActive() {
		
		String sql = "SELECT product_id,sku,name,description,price,stock,is_active FROM products WHERE is_active = 1 ORDER BY product_id" ;
		
		List<Product> list = new ArrayList() ; 
		
		try(Connection conn = DButil.getConnection() ;
			PreparedStatement pstmt = conn.prepareStatement(sql) ;
			ResultSet rs = pstmt.executeQuery()) {
			
			while(rs.next()) {
				Product p = new Product() ;
				p.setProductID(rs.getLong("product_id"));
				p.setSku(rs.getString("sku"));
				p.setName(rs.getString("name"));
				p.setDescription(rs.getString("description"));
				p.setPrice(rs.getBigDecimal("price"));
				p.setStock(rs.getInt("stock"));
				p.setActive(rs.getInt("is_active") == 1);
				list.add(p) ;
			}
			
			return list ;
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			throw new RuntimeException("資料查詢異常") ;
		}
	}
	
}
