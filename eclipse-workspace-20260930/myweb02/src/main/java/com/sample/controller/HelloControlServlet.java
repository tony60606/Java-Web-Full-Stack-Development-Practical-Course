package com.sample.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class HelloControlServlet
 */
@WebServlet("/HelloControlServlet")
public class HelloControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloControlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//擷取資料編碼設定
		request.setCharacterEncoding("utf-8") ;
		//設定回應內容型態，告知瀏覽器以text/html解析,並用utd-8編碼
		response.setContentType("text/html;charset=utf-8") ;
		//取出表單參數
		String message = request.getParameter("message") ;
		//資料處理
		String result = "[處理結果]" + message + "，感謝您提供的訊息" ;
		//透過request參考出RequestDispacher介面
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("showhello.jsp") ;
		//使用setAttribute()參照處理好的狀態(State)，持續這些狀態到目標
		request.setAttribute("result", result);
		//分派到目標(Servlet/jsp)
		//----------------------------
		//[測試一] 使用forward() 
		//requestDispatcher.forward(request, response);
		//[測試一] 使用include() 
		requestDispatcher.include(request, response);
		//----------------------------
		//[測試] 使用forward()跟include()的差異
		response.getWriter().println("<hr><h1>當這行字出現時，表示使用include()分派</h1>") ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
