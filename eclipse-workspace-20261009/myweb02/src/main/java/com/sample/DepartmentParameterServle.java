package com.sample;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class DepartmentParameterServle
 */
@WebServlet(name = "DepartmentParameterServle" ,
			urlPatterns = {"/DepartmentParameterServle"},
			initParams = {@WebInitParam(name = "department",
										value = "資訊部,財務部,人事部,行銷部,業務部,研發部")})
public class DepartmentParameterServle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String department ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentParameterServle() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	//先取初始化參數
    	department = config.getInitParameter("department") ;
    	//將department的資料給其他Servlet使用
    	//進入網站應用系統界接物件參考
    	ServletContext application = config.getServletContext() ;
    	//進入狀態管理(新增或修改特定屬性參照的物件內容)
    	application.setAttribute("department", department);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;utf-8") ;
		PrintWriter out = response.getWriter();
		out.println("<h1>DepartmentParameterServle</h1>");
		out.println("<h2>已設定department：" + department + "<h2>") ;
		out.println("<p>DepartmentParameterServlet 必須先執行一次，department 參數才可以給其他 Servlet 使用</p>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
