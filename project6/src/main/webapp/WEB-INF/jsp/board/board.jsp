<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/js/board.js"></script>
<jsp:include page="/WEB-INF/jsp/head/default.jsp" flush="flase"></jsp:include>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/module/top-navigation.jsp" flush="flase"></jsp:include>
	</header>
	<table>
		<tr>
			<thead>
				<th>No</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성날</th>
				<th>조회수</th>
			</thead>
		</tr>
		<tr>
			<tbody>
				<c:forEach var = "content" items="${applicationScope.contents}">
					<c:url var="detail_url" value="/detail">
						<c:param name="wnum" value="${content.getwNum() }" />
					</c:url>
					<tr>
						<td>${content.getwNum()}</td>
						<td><a href="${detail_url}">${content.getwTitle() }</a></td>
						<td><a href="${detail_url}">${content.getwContent() }</a></td>
						<td>${content.getwDate() }</td>
						<td>${content.getViewCnt() }</td>
					<tr>
				</c:forEach>		
			</tbody>
		</tr>
		<script>
			function logined(){
				var loginfrm = document.logined_form;
				if(${sessionScope.logined != null}){
					loginfrm.submit();
				}else{
					alert('로그인 해주셔야 글쓰기 가능합니다.');
				}
			};
		</script>
		<tr>
			<tfoot>
				<tr>
					<td>
						<form action="<%= request.getContextPath() + "/writer"%>" name="logined_form">
							<button type="button" onclick="logined()">글쓰기</button>
						</form>
					<td>
				</tr>		
			</tfoot>
		</tr>	
	</table>
</body>
</html>