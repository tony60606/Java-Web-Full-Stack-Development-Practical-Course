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
 * Servlet Filter implementation class ControlFilter
 */
@WebFilter("/td/*")
public class ControlFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public ControlFilter() {
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
		boolean isVaild = false ;
		Cookie[] cookies = ((HttpServletRequest)request).getCookies() ;
		if (cookies == null) {
			((HttpServletResponse)response).sendRedirect("/homework0930/index.jsp") ;
		} else {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("cred")) {
					isVaild = true ;
					break ;
				}
			}
		}
		if (isVaild) {
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse)response).sendRedirect("/homework0930/index.jsp") ;
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
