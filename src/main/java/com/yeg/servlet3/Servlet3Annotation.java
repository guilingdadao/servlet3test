package com.yeg.servlet3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "myServlet", asyncSupported = true, description = "myservlet", displayName = "myservlet", initParams = {
		@WebInitParam(name = "username", value = "zhangsan"),
		@WebInitParam(name = "age", value = "23") }, loadOnStartup = -1, urlPatterns = "/annotation")
//,@WebInitParam= {name="age",age:10}
//initParams = {@WebInitParam(name = "username", value = "YangYuqin")})

public class Servlet3Annotation extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取ServletConfig的实例
		ServletConfig config = this.getServletConfig();

		// 获取指定参数名称的值
		String name = config.getInitParameter("username");

		resp.setContentType("text/html;charset=utf-8");

		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head><title>Servlet3应用实例</title></head>");
		out.println("<body>");
		out.print("获取InitParamServlet的初始化参数\"username\"的字符串值：" + name);
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	public void destroy() {
		// 空
	}

	@Override
	public void init() throws ServletException {
		// 空
	}
}
