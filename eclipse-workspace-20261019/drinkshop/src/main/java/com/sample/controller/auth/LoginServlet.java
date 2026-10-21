package com.sample.controller.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import com.sample.DAO.MemberDAO;
import com.sample.model.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private final MemberDAO dao = new MemberDAO() ;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/auth/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8") ;
		
		String email = request.getParameter("email") ;
		String password = request.getParameter("password") ;
		
		request.setAttribute("email", email) ;
		
		Member m = dao.findActiveByEmail(email) ;
		
		//無會員資料
		if (m == null) {
			request.setAttribute("error", "帳號or密碼錯誤") ;
			request.getRequestDispatcher("/auth/login.jsp").forward(request, response);
			return ;
		}
		
		//有會員資料
		boolean ok ;
		try {
			ok = BCrypt.checkpw(password , m.getPasswordHash()) ;
		} catch (Exception ex) {
			ok = false ;
		}
		
		if (!ok) {
			request.setAttribute("error", "帳號or密碼錯誤") ;
			request.getRequestDispatcher("/auth/login.jsp").forward(request, response);
			return ;
		}
		
		//登入成功將會員資料放入Session
		request.getSession().setAttribute("loginMember", m) ;
		response.sendRedirect(request.getContextPath() + "/products") ;
		
	}

}
