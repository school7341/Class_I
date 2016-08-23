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
<h2>if tag test</h2>
<form name="f">
name : <input type="text" name="name">
<input type="submit" value="send">
</form>
<hr>
<c:if test="${empty param.name}"><h4 style="color:red;">There is no Name.</h4></c:if>
<c:if test="${param.name eq 'SeoS'}"><h4 style="color:blue;">${param.name} is a Project Management.</h4></c:if>
<hr>
<h2>choose Test</h2>
<c:choose>
	<c:when test="${param.name eq 'SeoS'}"><h4 style="color :violet;">Welcome, ${param.name}</h4></c:when>
	<c:when test="${param.name eq 'killer'}"><h4 style="color :red;">You can not enter.</h4></c:when>
	<c:otherwise><h4 style="color :green;">Welcome, ${param.name}</h4></c:otherwise>
</c:choose>
<hr>

</body>
</html>