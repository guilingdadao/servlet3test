<%@ page contentType="text/html;charset=UTF-8" language="java"
	import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Servlet3.0 上传文件</title>
</head>
<body>
	<h3><%=request.getAttribute("des")%></h3>
	<img alt="servlet3"
		src="<%=basePath%>temp/<%=request.getAttribute("f")%>">
</body>
</html>