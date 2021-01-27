package com.yeg.servlet3.dynamic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * 不用添加@@WebServlet
 *
 */
public class MyDynamicServlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");

		PrintWriter write = resp.getWriter();

		String name = this.getInitParameter("name");
		
		write.println("<html><head><title>Fist servlet" + "</title></head><body><h2>" + name);
		write.println("</h2></body></html>");

	}

}
