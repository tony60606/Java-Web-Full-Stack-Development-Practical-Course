package com.sample.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.sample.modal.Customer;

public class CustomerDAO {

	//宣告DataSource
	private DataSource datasource ;
	
	//建立連線資料(連接工廠)
	public void setDataSource(DataSource datasource) {
		this.datasource = datasource ;
	}
	
	//資料庫查詢(單筆查詢)
	//SELECT * FROM customer WHERE  customer_id = ?
	public Customer selectForObject(String sql , Object... args) throws SQLException {
		Customer customer = null ;
		//判斷DataSource是否有注入
		if (datasource == null) {
			//手動拋出例外
			throw new SQLException("尚未注入datasource") ;
		}
		//透過datasource建立連接物件
		Connection connecttion = datasource.getConnection() ;
		//產生一個帶參數的PreparedStatement物件
		PreparedStatement pstmt = connecttion.prepareStatement(sql) ;
		//走訪args參數進行pstmt內容設定
		for(int i = 0 ;  i < args.length ; i++) {
			pstmt.setObject(i + 1 , args[i]);
		}
		//執行查詢
		ResultSet rs = pstmt.executeQuery();
		//判定是否有查到相對應客戶
		if (rs.next()) {
			customer = new Customer() ;
			customer.setCustomerID(rs.getString("customer_id")) ;
			customer.setFirstName(rs.getString("first_name")) ;
			customer.setLastName(rs.getString("last_name")) ;
			customer.setEmail(rs.getString("email")) ;
		}
		//關閉資料庫連線
		connecttion.close();
		return customer ;
		
	}
	
}
