<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/home.jsp</title>
</head>
<body>
<h1>인덱스 페이지입니다.</h1>
<h2>공지사항</h2>
<ul>
	<c:forEach var="tmp" items="${requestScope.notice}">
		<li>${tmp }</li>
	</c:forEach>
</ul>
<p>어쩌구..저쩌구..</p>
</body>
</html>