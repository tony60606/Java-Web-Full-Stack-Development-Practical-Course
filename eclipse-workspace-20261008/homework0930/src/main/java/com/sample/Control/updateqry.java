package com.sample.Control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import com.sample.DAO.createDAO;

/**
 * Servlet implementation class update
 */
@WebServlet("/updateqry")
public class updateqry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateqry() {
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
		
		String indexs = request.getParameter("index") ;
		String date = request.getParameter("date") ;
		String title = request.getParameter("title") ;
		String content = request.getParameter("content") ;
		String username = null ;
		
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
		
		if (indexs == null || indexs.isBlank()|| date == null || date.isBlank()) {
            response.sendError(400, "請選擇代辦事項並填寫日期");
            return;}
		
		try {
			int index = Integer.parseInt(indexs) ;
			LocalDate dates = LocalDate.parse(date) ;
			
			boolean updates = createDAO.update(index, dates, title, content , username) ;
			
			if (!updates) {
				response.sendError(404, "修改失敗，資料不存在或資料已過期");
                return;
			}
			
			response.sendRedirect(request.getContextPath() + "/td/To-do.jsp");
			
		} catch (NumberFormatException | DateTimeParseException ex) {
			 response.sendError(400, "請選擇代辦事項並填寫日期");
		}
		
	}

}
