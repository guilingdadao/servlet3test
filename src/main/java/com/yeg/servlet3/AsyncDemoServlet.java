package com.yeg.servlet3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*、异步处理支持
Servlet3.0支持异步处理支持，Servlet接收到请求之后，可能首先需要对请求携带的数据进行一些预处理；
接着，Servlet线程将请求转交给一个异步线程来执行业务处理，线程本身返回至容器，此时Servlet还没有生成响应数据，
异步线程处理完业务以后，可以直接生成响应数据（异步线程拥有ServletRequest和ServletResponse对象的引用），
或者将请求继续转发给其他Servlet。

1）对于使用传统的部署描述文件web.xml配置Servlet和过滤器的情况，Servlet3.0为<servlet>和<filter>标签增加了<async-supported>子标签，
该标签的默认取值为false，要启用异步处理支持，则将其设为true即可。

<servlet>
<servlet-name>DemoServlet</servlet-name>
<servlet-class>com.yeg.servlet3.AsyncDemoServlet</servlet-class>
<async-supported>true</async-supported>
</servlet>
2）对于使用Servlet3.0提供的@WebServlet和@WebFilter进行Servlet或过滤器配置的情况，这两个标注都提供了asyncSupported属性，默认该属性的取值为false，要启动异步处理支持，只需将该属性设置为true即可。
*/

@WebServlet(urlPatterns = { "/asyncdemo" }, asyncSupported = true)
public class AsyncDemoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("进入Servlet的时间：" + new Date() + ".");
		out.flush();
		
		// 在子线程中执行业务调用，并由其负责输出响应，主线程退出
		AsyncContext ctx = req.startAsync();
		
		new Thread(new Executor(ctx)).start();
		
		out.println("结束Servlet的时间：" + new Date() + ".");
		
		out.flush();
	}
	
	/***
	 * 
	 * 
	 *
	 */
	public class Executor implements Runnable {
		private AsyncContext ctx = null;

		public Executor(AsyncContext ctx) {
			this.ctx = ctx;
		}

		public void run() {
			try {
				// 等待10秒钟，以模拟业务方法的执行
				Thread.sleep(10000);
				PrintWriter out = ctx.getResponse().getWriter();
				out.println("业务处理完毕的时间：" + new Date() + ".");
				out.flush();
				ctx.complete();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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