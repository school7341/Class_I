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
<h3>bbsContent.jsp?idx=3&cp=14</h3>
<c:url var="contentUrl" value="bbsContent.jsp">
<c:param name="idx">3</c:param>
<c:param name="cp">14</c:param>
</c:url>
<h3>${contentUrl}</h3>
<hr>
<c:import url="http://m.naver.com" var="mnaver"></c:import>
<div style="border:1px solid gray; width:600px;height:300px;overflow:scroll;">
${mnaver}
</div>
<hr>
<c:catch var="excep">
<%
	String str=null;
	String str2="SeoS";
	System.out.println(str.toString());
	System.out.println(str2.toString());
	System.out.println(str2.charAt(0));	
%>

<h4>${excep}</h4>
</c:catch>
</body>
</html>