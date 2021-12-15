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
	<div>
		<table>
			<c:forEach var="detail" items="${details}">
				<tr><h2>${detail.getwTitle() }</h2></tr>
				<tr><h4>${detail.getwContent() }</h4></tr>
				<tr><h6>${detail.getwDate() }</h6></tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>