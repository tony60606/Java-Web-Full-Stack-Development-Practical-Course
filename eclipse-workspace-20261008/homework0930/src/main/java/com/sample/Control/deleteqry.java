package com.sample.Control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.sample.DAO.createDAO;

/**
 * Servlet implementation class deleteqry
 */
@WebServlet("/deleteqry")
public class deleteqry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteqry() {
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
		
		if (indexs == null || indexs.isBlank()) {
			response.sendError(400, "請選擇要刪除的代辦事項");
            return;
		}
		
		try {
			int index = Integer.parseInt(indexs) ;
			
			boolean deletes = createDAO.delete(index , username) ;
			
			if (!deletes) {
				 response.sendError(404, "資料不存在");
	             return;
			}
			
			response.sendRedirect(request.getContextPath() + "/td/To-do.jsp");
			
		} catch (NumberFormatException ex) {
			 response.sendError(400, "索引格式錯誤");
		}
		
		
	}

}
