<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>重复登录</title>
</head>
<body>
	<font color=red>检测到您的账号在其他地点登陆，您被迫下线！</font>
	<a href='${pageContext.request.contextPath}/login' target='_top'>重新登录</a>
	<p />
	<br />
</body>
</html>
