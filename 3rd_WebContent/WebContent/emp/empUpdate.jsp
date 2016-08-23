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

<c:set var="arr3" value="${requestScope.dtoss}"/>

	<form name="empRevise" action="empRevise.yong">
		<fieldset>
			<legend>revise Employee</legend>
			<table>
				<tr>
					<th>Employee ID</th>
					<td><input type="text" name="idx"  value="${arr3.idx}" readonly></td>
				</tr>

				<tr>
					<th>Employee Name</th>
					<td><input type="text" name="name" value="${arr3.name}"></td>
				</tr>
				<tr>
					<th>Employee Email</th>
					<td><input type="text" name="email" value="${arr3.email}"></td>
				</tr>
				<tr>
					<th>Employee Dept</th>
					<td><input type="text" name="dept" value="${arr3.dept}"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Update Employee"> <input type="reset" value="Reset"></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>