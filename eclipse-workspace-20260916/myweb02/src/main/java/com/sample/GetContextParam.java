package com.sample;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.sample.entity.DBConfig;

/**
 * Servlet implementation class GetContextParam
 */
@WebServlet("/GetContextParam")
public class GetContextParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetContextParam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8") ;
		
		ServletContext application = this.getServletContext() ;
		DBConfig dbconfig = (DBConfig)application.getAttribute("dbconfig") ;
		
		PrintWriter out = response.getWriter() ;
		out.println("<h3>" + dbconfig.getDriverClassName() + "</h3>");
		out.println("<h3>" + dbconfig.getUrl() + "</h3>");
		out.println("<h3>" + dbconfig.getUsername() + "</h3>");
		out.println("<h3>" + dbconfig.getPassword() + "</h3>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
