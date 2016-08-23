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
	<h1>Employee Management Program</h1>
	<form name="empAdd" action="empAdd.yong">
		<fieldset>
			<legend>Insert Employee</legend>
			<table>
				<tr>
					<th>Employee Name</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>Employee Email</th>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<th>Employee Dept</th>
					<td><input type="text" name="dept"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Insert Employee"> <input type="reset" value="Reset"></td>
				</tr>
			</table>
		</fieldset>
	</form>
	<hr>
	<form name="empDel" action="empDel.yong">
		<fieldset>
			<legend>Delete Employee</legend>
			<table>
				<tr>
					<th>Employee Name</th>
					<td><input type="text" name="name"></td>
					<td><input type="submit" value="Delete Employee"></td>
				</tr>
			</table>
		</fieldset>
	</form>
	<hr>
	<fieldset>
		<legend>Search all Employee</legend>
		<h4>
			<a href="empList.yong">Click Here</a>
		</h4>
	</fieldset>
	<hr>
	<form name="empSearch" action="empSearch.yong">
		<fieldset>
			<legend>Search Employee by name</legend>
			<strong>Employee Name</strong> <input type="text" name="name"> <input
				type="submit" value="Search Employee">
		</fieldset>
	</form>
	<hr>
<c:catch var="excep">	
	<form name="empUpdate" action="empUpdate.yong">
				<fieldset>
					<legend>Revise Employee</legend>
					<strong>ID_No</strong> 
					<input type="text" name="idx"><br>
					<strong>Name</strong>
					<input type="text" name="name"><br>
					<input type="submit" value="Search">
				</fieldset>
	</form>
<h4>${excep}</h4>
</c:catch>
</body>
</html>