package com.yeg.servlet3.ext;

import java.io.StringWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class SpringWebInitializerImpl implements SpringWebInitializer {

	/****
	 * 在自定义的方法中获取到了ServletContext
	 */
	@Override
	public void config(ServletContext ctx) {

		StringWriter sw = new StringWriter();
		sw.write("************SpringWebInitializer \n");
		sw.write("使用ServletContext可以添加Servlet,Lister,filter等把一些相关资源添加给ServletContext \n");
		sw.write("获取从ServletContext获取一些资源  \n");

		
		ServletRegistration.Dynamic dynamic = ctx.addServlet("DynamicServlet", DynamicServlet.class);
		dynamic.addMapping("/ext");
		
		System.out.println(sw.toString());

	}
}
