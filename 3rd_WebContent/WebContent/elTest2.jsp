<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setAttribute("id","Hong");
	request.setAttribute("addr","Seoul");
%>
<jsp:forward page="elTest3.jsp"></jsp:forward>
</body>
</html>