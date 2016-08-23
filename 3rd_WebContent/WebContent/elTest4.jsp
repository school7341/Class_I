<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>elTest 4</h2>
<script>
var a;
a=10;

</script>

<h4>boolean:${true}</h4>
<h4>Expression:${2*10*10.0-26}</h4>
<h4>String : ${"PMP 3.6"}</h4>
<h4>String : ${'PMP 3.6'}</h4>
<h4>String : 'PMP 3.6'</h4>
<h4>null : ${null}</h4>
<hr>
<h4>"3"+5 : ${"3"+5}</h4>
<h4>"삼"+5 : ${"3"+5}</h4>
<h4>null+5 : ${null+5}</h4>
<h4>3/2 : ${3/2}</h4>
<h4>3==3 : ${3 eq "3"}</h4>
<h4>3!=3 : ${3 != "3"}</h4>
<h4>I am a PM : ${I and am and  a && PM}</h4>
<hr>

</body>
</html>