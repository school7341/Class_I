<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<String> arr=new ArrayList<String>();
	arr.add("apple");
	arr.add("grape");
	arr.add("melon");
	arr.add("water-melon");
%>
<c:set var="arr" value="<%=arr%>"/>
<ul>
	<c:forEach var="temp" items="${arr}">
		<li>${temp}</li>
	</c:forEach>
</ul>
<hr>
<ul>
	<c:set var="sum" value="0"></c:set>
	<c:forEach var="i" begin="1" end="10" step="1">
	<c:set var="sum" value="${sum+i}"/>
	<li>${i}</li>
	</c:forEach>
</ul>
<h4>Sum:${sum}</h4>
<hr>
<table border="1" cellspacing="0">
	<c:forEach var="i" begin="1" end="10" step="1">
	<tr>
		<c:forEach var="j" begin="2" end="9" step="1">
			<td>
			${j}X${i}=${i*j}
			</td>
		</c:forEach>
	</tr>
	</c:forEach>
</table>	
<hr>
<ul>
	<c:forTokens var="temp" items="apple|grape|people" delims="|">
	${temp}<br></c:forTokens>
</ul>
<hr>

</body>
</html>