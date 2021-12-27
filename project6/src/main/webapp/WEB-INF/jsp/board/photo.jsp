<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/jsp/head/default.jsp" flush="false"></jsp:include>
<title>Insert title here</title>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/module/top-navigation.jsp" flush="false"></jsp:include>
	</header>
	<table>
		<tr>
		<c:forEach var="photo" items="${photos}">
			<c:url var="detail_link" value="/detail">
				<c:param name="wnum" value="${photo.getwNum()}"/>
			</c:url>
			<td><a href="${detail_link }"><img src="${photo.getDownloadpath()}" width="360" height="500"/></a></td>
		</c:forEach>
		</tr>
	</table>
</body>
</html>