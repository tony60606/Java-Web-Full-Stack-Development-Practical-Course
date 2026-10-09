package com.sample;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CityServlet
 */
@WebServlet(name = "CityServlet",
		urlPatterns = {"/CityServlet"},
		initParams = {@WebInitParam(name = "cities",
								value = "台北市,新北市,桃園市,新竹市,台中市,台南市,高雄市")})
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private String[] cities ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    	public void init() throws ServletException {
    		// TODO Auto-generated method stub
    		super.init();
    		ServletConfig config = this.getServletConfig() ;
    		String value = config.getInitParameter("cities") ;
    		cities = value.split(",") ;
    	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;utf-8") ;
		PrintWriter out = response.getWriter() ;
		
		out.println("<h2>城市清單</h2>") ;
		out.println("<select>") ;
		for (String item :cities) {
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
