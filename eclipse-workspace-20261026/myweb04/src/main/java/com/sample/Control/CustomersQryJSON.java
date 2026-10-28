package com.sample.Control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.google.gson.Gson;
import com.sample.DAO.CustomerDAO;
import com.sample.modal.Customer;


/**
 * Servlet implementation class CustomersQryJSON
 */
@WebServlet("/CustomersQryJSON")
public class CustomersQryJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomersQryJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String customerID = request.getParameter("customer_id") ;
		
		BasicDataSource datasource = new BasicDataSource() ;
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver") ;
		datasource.setUrl("jdbc:mysql://localhost:3306/sakila?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8") ;
		datasource.setUsername("root");
		datasource.setPassword("zoobee00");
		
		CustomerDAO dao = new CustomerDAO() ;
		
		dao.setDataSource(datasource);
		
		Customer customer = null ;
		
		try {
			customer = dao.selectForObject("SELECT * FROM customer WHERE customer_id = ?", customerID) ;
			if (customer != null) {
				//JSON文字給用戶端
				//建構GSON物件
				Gson gosn = new Gson() ;
				//序列化物件為JSON
				String data = gosn.toJson(customer) ;
				response.setContentType("application/json");
				response.getWriter().println(data) ;
				
			} else {
				RequestDispatcher rs = request.getRequestDispatcher("message.jsp") ;
				//訊息狀態
				request.setAttribute("title", "查詢結果");
				request.setAttribute("message", "客戶ID：" + customerID + "=>查無此筆紀錄!!");
				//分送
				rs.forward(request, response);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
			
		
	}

}
