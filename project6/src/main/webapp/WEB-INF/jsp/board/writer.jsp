<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/jsp/head/default.jsp" flush="flase"></jsp:include>
<title>Insert title here</title>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/module/top-navigation.jsp" flush="flase"></jsp:include>
	</header>
		<c:choose>
			<c:when test="${param.update eq 'yes' }">
				<form action="/update?wnum=${param.wnum }" method="post">
					<ul>
						<c:forEach var="detail" items="${details}">
							<li><input type="text" name="title" placeholder="title..." value="${detail.getwTitle() }"></li>
							<li><textarea name="content" placeholder="content...">${detail.getwContent()}</textarea></li>
						</c:forEach>
					</ul>
					<div>
						<button type="submit">수정</button>
					</div>
				</form>				
			</c:when>
			<c:when test="${param.update == null}">
				<form action="/writer" method="post">	
					<ul>
						<li><input type="text" name="title" placeholder="title..."></li>
						<li><textarea name="content" placeholder="content..."></textarea></li>
					</ul>
					<div>
						<button type="submit">글쓰기</button>
					</div>
				</form>
			</c:when>
		</c:choose>			
	<div>
	<c:if test="${update-error != 0}">
		<h3>${update-error}</h3>
	</c:if>
	</div>
</body>
</html>