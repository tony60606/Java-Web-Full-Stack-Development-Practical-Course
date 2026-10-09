package com.sample;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ItemServlet
 */



//先註解@WebServlet
//@WebServlet("/ItemServlet")


public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	//屬性
	private String[] items ;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	//先取得Web.xml的<init-param>
    	String values = config.getInitParameter("items") ;
    	//字串切割取得字串陣列指定給屬性items
    	items = values.split(",") ;
    	
    	
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;utf-8") ;
		PrintWriter out = response.getWriter() ;
		
		out.println("<h2>資訊課程清單</h2>") ;
		out.println("<select>") ;
		for (String item :items) {
			out.printf("<option  value = '%s'>%s</option>",item,item) ;
		}
		out.println("</select>") ;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
