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
<h2>Search By Name</h2>
<table border="1" width="450" cellspacing="0">
	<thead>
	<tr>
		<th>Emp_No</th>
		<th>Name</th>
		<th>Email</th>
		<th>Dept</th>
	</tr>
	</thead>
	</thead>
	<tbody>
	<c:set var="arr2" value="${requestScope.dtos}"/>
	<c:if test="${empty arr2 }">
		<tr>
			<td colspan="4" align="center">No List</td>
		</tr>
	</c:if>
	<c:forEach var="dto2" items="${arr2}">
		<tr>
			<td>${dto2.idx}</td>
			<td>${dto2.name}</td>
			<td>${dto2.email}</td>
			<td>${dto2.dept}</td>
		</tr>
	</c:forEach>
</tbody>
</table>

</body>
</html>