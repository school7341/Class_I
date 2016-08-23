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

<h4>jstl Test 1</h4>
<!-- 변수 선언 -->
<c:set var="num1" value="100"/>
<c:set var="num2">200</c:set>
<!-- 변수 선언 -->
<h4>num1:${num1}</h4>
<h4>num2:${num2}</h4>
<h4>num1+num2:${num1+num2}</h4>
<%
String fruit[]={"apple","grape","strawbary","watermelon","melon"};
%>
<c:set var="f" value="<%=fruit %>"/>
<!-- 변수 출력 -->
<ul>
	<li>f id: ${f}</li>
	<li>f 0 value: ${f[0]}</li>
	<li>f 1 value: ${f["1"]}</li>
	<li>f 2 value: ${f['2']}</li>
</ul>
<c:remove var="f"/>
<ul>
	<li>f id: ${f}</li>
	<li>f 0 value: ${f[0]}</li>
	<li>f 1 value: ${f["1"]}</li>
	<li>f 2 value: ${f['2']}</li>
</ul>
<hr>
<%
	Map map=new HashMap();
%>
<c:set var="m" value="<%=map %>"/>
<c:set target="${m}" property="name" value="Seokhyeon Seo"/>
<c:set target="${m}" property="id">SeoS</c:set>
<c:set target="${m}" property="e-mail">school7341@naver.com</c:set>
<h4>Name : ${m.name}</h4>
<h4>Id : ${m.id}</h4>
<h4>E-mail : ${m['e-mail']}</h4>
</body>
</html>