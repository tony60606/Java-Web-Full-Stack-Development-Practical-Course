package com.sample.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet Filter implementation class HRSecurityHandler
 */
@WebFilter(urlPatterns = {"/hr/*"})
public class HRSecurityHandler extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public HRSecurityHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		//攔截前端憑證(Cookie)
		//進行旗標
		boolean isVaild = false ;
		Cookie[] cookies = ((HttpServletRequest)request).getCookies();
		
		//走訪所有Cookies
		if (cookies == null) {
			((HttpServletResponse) response).sendRedirect("/myweb02/login.jsp");
		} else {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("cred")) {
					isVaild = true ;
					break ;
				}
			}
		}
		
		if (isVaild) {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		} else {
			// 尚未登入，導向(Redirect) login.jsp
			((HttpServletResponse)response).sendRedirect("/myweb02/login.jsp");
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
