<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Search All</h2>
<table border="1" width="450" cellspacing="0">
	<thead>
	<tr>
		<th>Emp_No</th>
		<th>Name</th>
		<th>Email</th>
		<th>Dept</th>
	</tr>
	</thead>
	<tbody>
	<c:set var="arr" value="${requestScope.dtos}"/>
	<c:if test="${empty arr }">
		<tr>
			<td colspan="4" align="center">No List</td>
		</tr>
	</c:if>
	<c:forEach var="dto" items="${arr}">
		<tr>
			<td>${dto.idx}</td>
			<td>${dto.name}</td>
			<td>${dto.email}</td>
			<td>${dto.dept}</td>
		</tr>
	</c:forEach>
</tbody>
</table>
</body>
</html>