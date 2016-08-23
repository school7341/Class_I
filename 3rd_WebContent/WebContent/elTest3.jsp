<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>elTest 3</h2>
<%
String name=request.getParameter("name");
String id=(String)request.getAttribute("id");
%>
<h4>Name : <%=name %></h4>
<h4>Id : <%=id %></h4>
<hr>
<h4>Age :${param.age}</h4>
<h4>Addr :${requestScope.addr}</h4>
</body>
</html>