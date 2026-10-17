package com.sample.control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.sample.DAO.ProductDAO;
import com.sample.model.Product;

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/products")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private final ProductDAO productdao = new ProductDAO() ;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 讀取資料庫取得商品資料 List<Product>
		List<Product> products = productdao.findAllActive() ;
		
		request.setAttribute("products", products) ;
		
		
		request.getRequestDispatcher("products.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
