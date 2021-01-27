package com.yeg.servlet3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "servlet3logout", urlPatterns = { "/logout" })
public class Servlet3Logout extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 设置响应内容类型
		req.setCharacterEncoding("utf-8");
		// 销毁会话，会触发SessionLinstener中的sessionDestroyed方法
		req.getSession().invalidate();
		
		// 从应用上下文中获取在线用户名列表
		List<String> online = (List<String>) getServletContext().getAttribute("online");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>用户列表</title></head>");
		out.println("<body>");
		out.print("<h3>在线用户列表</h3>");
		int size = ((online == null) ? 0 : online.size());
		for (int i = 0; i < size; i++) {
			if (i > 0) {
				out.println("<br />");
			}
			out.println(i + 1 + "." + online.get(i));
		}
		out.println("<hr><a href=\"index.jsp\">主页</hr>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
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