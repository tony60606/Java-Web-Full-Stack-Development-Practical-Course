package com.sample;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Servlet implementation class LoadOtherServlet
 */
@WebServlet("/LoadOtherServlet")
public class LoadOtherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadOtherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String type = request.getParameter("type") ;
		
		String filepath = "" ;

		if (type.equals("pdf")) {
			//設定回應的ContentType
			response.setContentType("application/pdf") ;
			filepath = getServletContext().getRealPath("/docs/MIME_types.pdf") ;
		} else {
			response.setContentType("image/png") ;
			filepath = getServletContext().getRealPath("/docs/logo2.png") ;
		}
		
		System.out.println("### filepath：" + filepath) ;
		
		Path path = Paths.get(filepath) ;
		try(InputStream is = Files.newInputStream(path) ;
			ServletOutputStream so = response.getOutputStream()) {
			byte[] buff = new byte[is.available()] ;
			is.read(buff) ;
			so.write(buff) ;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
