package com.yeg.servlet3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*3、可插性支持 Servlet3.0新增的可插性（Pluggability）支持则将Servlet配置的灵活性提升到了新的高度。<br/>
使用该特性，现在我们可以在不修改已有Web应用的前提下，只需将按照一定格式打包成的JAR包放到WEB-INF/lib目录下，即可实现新的功能的扩充，不需要额外的配置。<br/>
Servlet3.0引入了称为“Web模块部署描述文件片段”的web-fragment.xml来实现可插性的。<br/>
web-fragment.xml部署描述文件可以定义一切可以在web.xml中定义的内容。<br/>
1）新建的Servlet类：
2）在web目录下新建一个目录META-INF，在该目录下新建一个web-fragment.xml模块部署描述符文件片段：
3）将FragmentDemoServlet和META-INF目录一起打包成JAR包，假如JAR包叫fragment.jar。
4）将fragment.jar放到其他Web项目中的WEB\lib目录中，然后访问http://localhost:8080/fragment即可。
*/

public class FragmentDemoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=utf-8");

		PrintWriter out = resp.getWriter();

		out.println("这是我Servlet3.0的第一个可插性示例");

		out.flush();
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