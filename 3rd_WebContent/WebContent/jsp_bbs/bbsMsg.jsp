<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="msg" value="${requestScope.msg }"/>
<script>
	window.alert('${requestScope.msg}');
	location.href='bbsList.yong';
</script>
