package com.sample;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LifeSircleServlet
 */
@WebServlet("/LifeSircleServlet")
public class LifeSircleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private String msg = "" ;
	private int count = 0 ;
	
	
    public LifeSircleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    //覆寫init()
    //輸入init => alt + /
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	System.out.println("init()....") ;
		msg = msg + "init() ...<br>" ; 
    }
    
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	System.out.println("service()....count:"+ ++count) ;
    	msg = msg + "msg + service() ... +count："+ ++count +"<br>" ; 
    	
    	super.service(req, res);
    }
    
    @Override
    public void destroy() {
    	// TODO Auto-generated method stub
    	super.destroy();
    	System.out.println("### LifeCycleServlet --> destroy()");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=utf-8") ;
		System.out.println("doget()....") ;
		msg = msg + "doGet()...<br>-------------<br><br>";
		response.getWriter().println(msg);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
