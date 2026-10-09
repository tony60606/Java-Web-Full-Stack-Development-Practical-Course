package com.sample.listener;

import com.sample.entity.DBConfig;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ApplicationHandler
 *
 */
@WebListener
public class ApplicationHandler implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ApplicationHandler() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	ServletContext application = sce.getServletContext() ;
    	
    	//取得 Web.xml 初始化參數 <context-param>
    	String driverClassName = application.getInitParameter("driverClassName") ;
    	String url = application.getInitParameter("url") ;
    	String username = application.getInitParameter("username") ;
    	String password = application.getInitParameter("password") ;
    	
    	DBConfig dbconfig = new DBConfig(driverClassName,url,username,password) ;
    	System.out.println("###" + dbconfig) ;
    	application.setAttribute("dbconfig", dbconfig) ;
    	
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}
