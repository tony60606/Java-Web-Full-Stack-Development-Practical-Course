package com.sample;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class HelloServlet
 */
//Servlet文件預設寫法 name 和 url-pattern 都是 HelloServlet
//@WebServlet("/HelloServlet")

//指定url-pattern
//@WebServlet( name = "HelloServlet" , urlPatterns = "/Hello.view") 

//配置多個url-pattern

@WebServlet( name = "HelloServlet" , urlPatterns = {"/HelloServlet","/Hello.view"}) 

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//設定回應的內容型態，告知瀏覽器要以text/html解析，採用UTF-8編碼
				response.setContentType("text/html;charset=utf-8") ;
				response.getWriter().append("Served at: ").append(request.getContextPath());
				
				String msg = "<h1> 這是Servlet的回應 </h1>" ;
				//使用getWriter()方法取得代表回應的輸出的PrintWriter物件的println()來對瀏覽器輸出回應的內容
				PrintWriter out = response.getWriter() ;
				out.println(msg);
				out.println("<font size = '15' color = 'red' >您好!!JAVA WEB</font>") ;
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
