<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/cafe/list.jsp</title>
<jsp:include page="../include/resource.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../include/navbar.jsp">
	<jsp:param value="cafe" name="category"/>
</jsp:include>
<div class="container">
	<ol class="breadcrumb">
		<li><a href="${pageContext.request.contextPath }/cafe/list.do">목록</a></li>
	</ol>
		<c:choose>
		<c:when test="${not empty keyword }">
			<p>
				<strong>${keyword} </strong>키워드로 검색된
				<strong>${totalRow }</strong>개의 파일이 있습니다.
			</p>
		</c:when>
		<c:otherwise>
			<p><strong>${totalRow }</strong>개의 파일이 있습니다.</p>
		</c:otherwise>
	</c:choose>
	<h1>글 목록 입니다.</h1>
	<table class="table table-striped table-condensed">
		<colgroup>
			<col class="col-xs-1"/>
			<col class="col-xs-2"/>
			<col class="col-xs-5"/>
			<col class="col-xs-1"/>
			<col class="col-xs-3"/>
		</colgroup>
		<thead>
			<tr>
				<th>글번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>조회수</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="tmp" items="${requestScope.list }">
			<tr>
				<td>${tmp.num }</td>
				<td>${tmp.writer }</td>
				<td>
					<a href="detail.do?num=${tmp.num }">
						${tmp.title }
					</a>
				</td>
				<td>${tmp.viewCount }</td>
				<td>${tmp.regdate }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<a href="insertform.do">새글 작성</a>
	
	<div class="page-display">
		<ul class="pagination pagination-sm">
			<c:choose>
				<c:when test="${startPageNum ne 1 }">
					<li>
						<a href="list.do?pageNum=${startPageNum-1 }&condition=${condition}&keyword=${encodedKeyword}">&laquo;</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="disabled">
						<a href="javascript:">&laquo;</a>
					</li>
				</c:otherwise>
			</c:choose>
			<c:forEach var="i" begin="${startPageNum }" 
				end="${endPageNum }">
				<c:choose>
					<c:when test="${i eq pageNum }">
						<li class="active">
							<a href="list.do?pageNum=${i }&condition=${condition}&keyword=${encodedKeyword}">${i }</a>
						</li>
					</c:when>
					<c:otherwise>
						<li>
							<a href="list.do?pageNum=${i }&condition=${condition}&keyword=${encodedKeyword}">${i }</a>
						</li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${endPageNum lt totalPageCount }">
					<li>
						<a href="list.do?pageNum=${endPageNum+1 }&condition=${condition}&keyword=${encodedKeyword}">&raquo;</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="disabled">
						<a href="javascript:">&raquo;</a>
					</li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>	
	<form action="list.do" method="get"> <%-- <c:if test="${condition eq 'titlename' }">selected</c:if>	 --%>
		<label for="condition">검색조건</label>
		<select name="condition" id="condition">
			<option value="titlename" <c:if test="${condition eq 'titlename' }">selected</c:if>>제목+내용</option>
			<option value="title" <c:if test="${condition eq 'title' }">selected</c:if>>제목</option>
			<option value="writer" <c:if test="${condition eq 'writer' }">selected</c:if>>작성자</option>
		</select>
		<input type="text" name="keyword" id="keyword"
			placeholder="검색어 ..." value="${keyword }"/>
		<button type="submit">검색</button>
	</form><!-- condition이라는 파라미터 명으로 넘어간다. -->
</div>
</body>
</html>