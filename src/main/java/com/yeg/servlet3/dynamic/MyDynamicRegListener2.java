package com.yeg.servlet3.dynamic;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

/***
 * 方式一: 实现ServletContextListener接口,在contextInitialized方法中完成注册Servlet
 */
@WebListener
public class MyDynamicRegListener2 implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	/***
	 * ServletContext 上下文初始化时
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {

		ServletContext servletContext = sce.getServletContext();

		//// Register Servlet
		/*
		 * 返回值是一个FilterRegistration.Dynamic或ServletRegistration.Dynamic
		 * 他们都是Registration.Dynamic 的子接口， FilterRegistration.Dynamic可以配置一个FIliter
		 * ServletRegistration.Dynamic可以配置一个Servlet
		 */
		ServletRegistration.Dynamic dynamic = servletContext.addServlet("myDynamicServlet2",
				"com.yeg.servlet3.dynamic.MyDynamicServlet2");
		
		
		
		
		if(dynamic== null) {
			System.out.println("**********>dynamic.is.null");
		}
		
		
		//servletContext.addServlet(arg0, arg1)
		
		dynamic.setInitParameter("name", "yuaneg2");
		dynamic.addMapping("/dynamic2");
		
		
//		// Register Filter 
//        FilterRegistration fr = sc.addFilter("DynamicFilter", 
//            "web.servlet.dynamicregistration_war.TestFilter"); 
//        fr.setInitParameter("filterInitName", "filterInitValue"); 
//        fr.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST), 
//                                     true, "DynamicServlet"); 
//
//        // Register ServletRequestListener 
//        sc.addListener("web.servlet.dynamicregistration_war.TestServletRequestListener");
        
        
	}

}
