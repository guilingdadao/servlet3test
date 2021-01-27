package com.yeg.servlet3;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/*
 * @WebFilter用于将一个类声明为过滤器，该标注将会在部署时被容器处理。	<br/>
	以下属性均为可选属性，但是value、urlPatterns、servletNames三者必需至少包含一个，	<br/>
	且value和urlPattern不能共存，如果同时指定，通常忽略value的取值。	<br/>

	属性名	类型	描述
	filterName	String	指定过滤器的name属性，等价于<filter-name>	<br/>
	value	String[]	该属性等价于urlPatterns属性，两个属性不能同时使用	<br/>
	urlPatterns	String[]	指定一组Servlet的URL匹配模式，等价于<url-pattern>标签	<br/>
	servletNames	String[]	@WebServlet中的name属性的取值，或者是web.xml中<servlet-name>的取值	<br/>
	initParams	WebInitParam[]	指定一组Servlet初始化参数，等价于<init-param>标签	<br/>
	dispatcherTypes	DispatcherType	指定过滤器的转发模式。具体取值包括：ASYNC、ERROR、FORWARD、INCLUDE、REQUEST	<br/>
	asyncSupported	boolean	声明过滤器是否支持异步操作模式，等价于<async-supported>标签	<br/>
	description	String	该Servlet的描述信息，等价于<description>标签	<br/>
	displayName	String	该Servlet的显示名，通常配合工具使用，等价于<display-name>标签	<br/>

*/
@WebFilter(servletNames = { "myservlet" }, filterName = "characterFilter", initParams = {
		@WebInitParam(name = "encoding", value = "UTF-8") })
public class Servlet3FilterAnnotation implements Filter {
	private FilterConfig filterConfig = null;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
//获取此Filter的初始参数的值
		String encoding = filterConfig.getInitParameter("encoding");
		System.out.println(encoding);
//设置请求数据的编码方式
		servletRequest.setCharacterEncoding(encoding);
//把请求和响应对象传给过滤链中的下一个要调用的过滤器或Servlet
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {
//空
	}
}
