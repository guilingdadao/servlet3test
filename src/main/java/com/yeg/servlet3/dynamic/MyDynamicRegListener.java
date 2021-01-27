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
public class MyDynamicRegListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	/***
	 * ServletContext 上下文初始化时
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {

		ServletContext servletContext = sce.getServletContext();
		Servlet mds = null;

		try {

			mds = servletContext.createServlet(MyDynamicServlet.class);

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (mds != null && mds instanceof MyDynamicServlet) {

			((MyDynamicServlet) mds).setName("************* registered MyDynamicServlet");

		}

//		返回值是一个FilterRegistration.Dynamic或ServletRegistration.Dynamic
//		他们都是Registration.Dynamic 的子接口，
//		FilterRegistration.Dynamic可以配置一个FIliter
//		ServletRegistration.Dynamic可以配置一个Servlet
		ServletRegistration.Dynamic dynamic = servletContext.addServlet("myDynamicServlet", mds);
		dynamic.setInitParameter("name", "yuaneg");

		dynamic.addMapping("/dynamic");
	}

}
