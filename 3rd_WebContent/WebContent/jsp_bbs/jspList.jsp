<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>자유게시판</h2>
<table border="1" width="450" cellspacing="0">
	<thead>
		<tr>
			<th>순번</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tfoot>
		<tr>
			<td colspan="3" align="center">
			${requestScope.pageStr}
			</td>
			<td>
			<a href="bbsWriteForm.yong">글쓰기</a>
			</td>
		</tr>
	</tfoot>
	<tbody>
		<c:set var="dtos" value="${requestScope.lists}"/>
		<c:if test="${empty dtos}">
			<tr>
				<td colspan="4" align="center">등록된 글이 없습니다.</td>
			</tr>
		</c:if>
		<c:forEach var="dto" items="${dtos}">
		<tr>
			<td>${dto.idx}</td>
			<td>${dto.writer}</td>
			<td>${dto.subject}</td>
			<td>${dto.readnum}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>