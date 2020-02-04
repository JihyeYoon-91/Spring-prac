<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/login.jsp</title>
<jsp:include page="../include/resource.jsp"></jsp:include>
</head>
<body>
<div class="container">
	<h1>Alert</h1>
	<c:choose>
	<c:when test="${not empty sessionScope.id }">
		<p>
			<strong>${id }</strong>회원님 로그인 되었습니다.
			<a href="${url} ">확인</a>
		</p>
	</c:when>
	<c:otherwise>
		<p>
			아이디 혹은 비밀번호가 일치하지 않아요!
			<a href="loginform.do?url=${encodedUrl }">다시 로그인 하러가기</a>
		</p>
	</c:otherwise>
	</c:choose>
</div>
</body>
</html>