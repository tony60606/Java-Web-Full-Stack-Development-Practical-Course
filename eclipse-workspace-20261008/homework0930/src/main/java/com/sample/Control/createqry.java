package com.sample.Control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;

import com.sample.DAO.createDAO;

/**
 * Servlet implementation class createqry
 */
@WebServlet("/createqry")
public class createqry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createqry() {
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
		request.setCharacterEncoding("utf-8") ;
		
		String date = request.getParameter("date") ;
		String title = request.getParameter("title") ;
		String content = request.getParameter("content") ;
		String username = null ;
		
		LocalDate dates = null ;
		
		Cookie[] cookies = request.getCookies() ;
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("cred")) {
					username = cookie.getValue() ;
					break ;
				}
			}
		}
		if (username == null || username.isBlank()) {
			
			response.setContentType("text/html;charset=UTF-8");
			
			response.getWriter().println(
				"<script>" +
				"alert('請先登入');" +
			    "window.location.href='" + request.getContextPath() + "/index.jsp';" +
			    "</script>"
			);
			return;
		}
		
		
		if(date == null || date.isBlank()) {
			response.sendError(400,"日期為必填欄位") ;
			return;
		}
		
		try {
			dates = LocalDate.parse(date) ;
			if (dates.isBefore(LocalDate.now())) {
			    response.sendError(400, "日期不能小於今天");
			    return;
			}
		} catch (DateTimeException ex) {
			response.sendError(400,"日期格式錯誤") ;
			return ;
		}
		
		createDAO.add(dates, title, content,username);
		
		response.sendRedirect(request.getContextPath() + "/td/To-do.jsp") ;
	}

}
