<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/todo/updateform.jsp</title>
</head>
<body>
<div class="class">
	<h1>할일 수정 폼</h1>
	<form action="update.do" method="post">
		<input type="hidden" name="num" value="${dto.num}"/>
		<div>
			<label for="num">번호</label>
			<input type="text" id="num" value="${dto.num }" disabled/>
		</div>
		<div>
			<label for="content">할일</label>
			<input type="text" name="content" id="content" value="${dto.content }"/>
		</div>
		<input type="hidden" name="regdate" value="${dto.regdate}"/>
		<div>
			<label for="regdate">날짜</label>
			<input type="text" name="regdate" id="regdate" value="${dto.regdate }"disabled/>
		</div>
		<button type="submit">수정확인</button>
		<button type="reset">취소</button>	
	</form>
</div>
</body>
</html>