<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users.jsp</title>
</head>
<body>
<div class="container">
	<h1>Alert</h1>	 
	 <strong>${dto.id } </strong>회원님 가입 되었습니다.
	 <a href="${pageContext.request.contextPath}/users/loginform.do" >
	  로그인 하러가기</a>
</div>
</body>	
</html>