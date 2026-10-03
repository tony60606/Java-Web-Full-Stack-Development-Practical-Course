package com.sample.Control;

import jakarta.servlet.ServletException ;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.sample.DAO.CustomerDAO;

/**
 * Servlet implementation class CustomersQry
 */
@WebServlet("/CustomersQry")
public class CustomersQry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomersQry() {
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
		
		//建立datasource
		BasicDataSource datasource = new BasicDataSource() ;
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver") ;
		datasource.setUrl("jdbc:mysql://localhost:3306/sakila?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8") ;
		datasource.setUsername("root");
		datasource.setPassword("zoobee00");
		
		//呼叫DAO模組進行資料查詢
		CustomerDAO dao = new CustomerDAO() ;
		//注入datasource
		dao.setDataSource(datasource);
	}

}
