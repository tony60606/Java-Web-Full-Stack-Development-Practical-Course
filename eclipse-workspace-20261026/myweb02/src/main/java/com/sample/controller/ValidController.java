package com.sample.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ValidController
 */
@WebServlet("/ValidController")
public class ValidController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8") ;
		String username = request.getParameter("username") ;
		String password = request.getParameter("password") ;
		
		//驗證帳號、密碼(預設admin.1234)
		if(username.equals("admin") && password.equals("1234")) {
			Cookie cookie = new Cookie("cred",username) ;
			response.addCookie(cookie);
			PrintWriter out = response.getWriter();
			out.println("<h1>Java Web 系統</h1>");
			out.println("<h2>" + username + "驗證成功</h2>") ;
			out.println("<p><a href = \"/myweb02/index.jsp\">回首頁</a></p>") ;
		} else {
			//沒有驗證成功，就轉到 login.jsp 重新載入
			response.sendRedirect("login.jsp") ;
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
