package com.sample;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * Servlet implementation class SelectCourseServlet
 */
@WebServlet("/SelectCourseServlet")
public class SelectCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8") ;
		
		PrintWriter out = response.getWriter() ;
		
		//getParamater():用來取得表單欄位或QueryString參數名稱的內容(參數只帶一個值)
		String item = request.getParameter("course") ;
		out.println("<h2>選修課程</h2>") ;
		out.println("<h3>你選修的課程為：" + item +"</h3>") ;
		
		out.println("<hr>") ;
		
		//多個參數
		//name=Java&version=21&item=Web開發
		out.println("<h2>多個參數</h2>");
		//一般寫法getParamater()個別取出
		out.println("<p>" + request.getParameter("name")+"</p>") ;
		out.println("<p>" + request.getParameter("version")+"</p>") ;
		out.println("<p>" + request.getParameter("item")+"</p>") ;
		
		out.println("<hr>") ;
		//取得指定參數
		// name=Java&name=Python&name=SQL
		String[] names = request.getParameterValues("name") ;
		out.println("<h2>參數帶多個值</h2>") ;
		out.println("<p><font-color = 'Green'>" + Arrays.toString(names) + "</font></p>" ) ;
		out.println("<hr>") ;
		
		//用列舉方式處理多個參數
		//建立Map集合
		HashMap<String ,String> map = new HashMap() ;
		//使用 getParameterNames()從請求參數中取出所有資料放入列舉中
		Enumeration<String> enumname = request.getParameterNames();
		while(enumname.hasMoreElements()) {
			String key = enumname.nextElement() ;
			map.put(key , request.getParameter(key)) ;
		}
		
		// 使用 lambda 表達式取出 map 集合中的所有的 key 和 value
		map.forEach((k,v) -> out.println("<h3>" + k + "--->" + v + "</h3>"));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
