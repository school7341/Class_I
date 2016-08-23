<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>자유게시판 글쓰기</h2>
<form name="BbsWrite" action="bbsWrite.yong">
	<ul>
		<li>작성자 : <input type="text" name="writer"></li>
		<li>비밀번호 : <input type="password" name="pwd"></li>
		<li>제목 : <input type="text" name="subject" size="40"></li>
		<li><textarea rows="10" cols="40" name="content"></textarea></li>
	</ul>
	<p>
		<input type="submit" value="글쓰기">
	</p>
</form>
</body>
</html>