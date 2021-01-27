<%@ page contentType="text/html;charset=UTF-8" language="java"
	import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<title>Servlet3.0 上传文件</title>
</head>
<body>
	<form action="uploadfile" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>选择文件：</td>
				<td><input type="file" name="file" /></td>
			</tr>
			<tr>
				<td>描述:</td>
				<td><input type="text" name="description" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="提交" />&nbsp;&nbsp;
					<input type="reset" value="重置" /></td>
			</tr>
		</table>
	</form>
</body>
</html>