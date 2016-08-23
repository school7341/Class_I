<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>자유게시판</h2>
<table border="1" width="450" cellspacing="0">
	<thead>
		<tr>
			<td>순번</td>
			<td>제목</td>
			<td>작성자</td>
			<td>조회수</td>
		</tr>
	</thead>
	<tfoot>
		<tr>
			<td colspan="3" align="center">페이징이 들어갈 영역</td>
		</tr>
			<td><a href="bbsWriteForm.yong">글쓰기</a></td>
	</tfoot>
</table>
</body>
</html>