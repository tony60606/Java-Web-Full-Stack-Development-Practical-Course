package com.sample.controller.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.sample.DAO.MemberDAO;
import com.sample.model.Member;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/auth/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final MemberDAO dao = new MemberDAO() ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/auth/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//接受註冊表單
		request.setCharacterEncoding("utf-8") ;
		
		//取參數+trim
		String email = trim(request.getParameter("email")) ;
		String password = request.getParameter("password") ;
		String displayname = trim(request.getParameter("displayname")) ;
		String phone = trim(request.getParameter("phone")) ;
		
		//回填
		request.setAttribute("email", email) ;
		request.setAttribute("displayname", displayname) ;
		request.setAttribute("phone", phone) ;
		
		//檢查可能繞過表單送入的資料
		if(isBlank(email) || isBlank(password) || isBlank(displayname)) {
			request.setAttribute("erroe", "請完整填必填欄位") ;
			request.getRequestDispatcher("/auth/register.jsp").forward(request, response);
		}
		
		Member m = new Member() ;
		m.setEmail(email);
		m.setDisplayname(displayname);
		m.setPhone(phone);
		
		try {
		MemberDAO.RegisterResult r  = dao.registerWithBCryptTx(m, password) ;
		if (!r.isok()) {
			if ("EMAIL_EXIST".equalsIgnoreCase(r.getMessage())) {
				request.setAttribute("error", "此Email已被註冊") ;
			} else {
				request.setAttribute("error", "註冊失敗" + r.getMessage()) ;
			}
			request.getRequestDispatcher("/auth/register.jsp").forward(request, response);
			return ;
		}
		
		//註冊成功
		response.sendRedirect(request.getContextPath() + "/auth/login") ;
		
		} catch (RuntimeException ex) {
			request.setAttribute("error", "系統忙線中，請重新再試") ;
			request.getRequestDispatcher("/auth/register.jsp").forward(request, response);
		}
		
	}
	
	private String trim(String s) {
		return (s == null) ? null : s.trim();
	} 
	
	private boolean isBlank(String s) {
		return s == null || s.isBlank() ;
	}
	
}
