<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP</title>
<link href="<c:url value="/static/css/style.css"/>" rel="stylesheet"/>
</head>
<body>
	<h1>Welcome</h1>
	<h2>${message }</h2>

</body>
</html>