package com.yeg.servlet3.ext;

import javax.servlet.ServletContext;

public interface SpringWebInitializer {
	/***
	 * 使用ServletContext可以添加Servlet,Lister,filter等把一些相关资源添加给ServletContext
	 * 
	 * @param ctx
	 */
	void config(ServletContext ctx);

}
