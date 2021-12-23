<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/jsp/head/default.jsp" flush="flase"></jsp:include>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/module/top-navigation.jsp" flush="flase"></jsp:include>
	</header>
	<div>
		<form action="/login" method="post">
			<input type="text" placeholder="id..." name="userid">
			<hr>
			<input type="password" placeholder="password..." name="user-password">	
			<hr>
			<button type="submit">login..</button>
		</form>
	</div>

</body>
</html>