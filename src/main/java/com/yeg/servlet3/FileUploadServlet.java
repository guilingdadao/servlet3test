package com.yeg.servlet3;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 */
@WebServlet(name = "upFile", urlPatterns = { "/uploadfile" })
@MultipartConfig(maxFileSize = 500000, maxRequestSize = -1)
public class FileUploadServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// resp.setContentType("text/html;charset=utf-8");
		// 获取请求参数值
		
		Part part = req.getPart("file");
		
		// 存储路径
		String storePath = req.getServletContext().getRealPath("/temp");
		// Servlet3没有提供直接获取文件名，后缀名的方法，需要从请求头中解析出来
		// 获取请求头
		String header = part.getHeader("content-disposition");
		// 获取文件后缀名
		// String suffix = parseFileName(header);
		String name = parseFileName(header);
		// 重新命名
		// String name = UUID.randomUUID() + suffix;
		// 把文件写到指定路径
		part.write(storePath + File.separator + name);
//        PrintWriter out = resp.getWriter();
//        out.println("上传成功");
//        out.flush();
//        out.close();
		
		// 获得文件描述信息
		String description = req.getParameter("description");
		req.setAttribute("f", name);
		req.setAttribute("des", description);
		
		req.getRequestDispatcher("info.jsp").forward(req, resp);
	}

	/*
	 * 根据请求头解析出上传文件的后缀名称
	 */
	/**
	 * 根据请求头解析出文件名 请求头的格式：火狐和google浏览器下：form-data; name="file";
	 * filename="snmp4j--api.zip" IE浏览器下：form-data; name="file";
	 * filename="E:\snmp4j--api.zip"
	 *
	 * @param header 请求头
	 * @return 文件名
	 */
	public String parseFileName(String header) {
		// return header.substring(header.lastIndexOf("."), header.length() - 1);
		/**
		 * String[] tempArr1 = header.split(";");代码执行完之后，在不同的浏览器下，tempArr1数组里面的内容稍有区别
		 * 火狐或者google浏览器下：tempArr1={form-data,name="file",filename="snmp4j--api.zip"}
		 * IE浏览器下：tempArr1={form-data,name="file",filename="E:\snmp4j--api.zip"}
		 */
		String[] tempArr1 = header.split(";");
		/**
		 * 火狐或者google浏览器下：tempArr2={filename,"snmp4j--api.zip"}
		 * IE浏览器下：tempArr2={filename,"E:\snmp4j--api.zip"}
		 */
		String[] tempArr2 = tempArr1[2].split("=");
		// 获取文件名，兼容各种浏览器的写法
		String fileName = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\") + 1).replaceAll("\"", "");
		return fileName;
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