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
<script type="text/javascript" src="/js/jquery-3.6.0.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/module/top-navigation.jsp" flush="false"></jsp:include>
	</header>
	<c:set var="logined" value="false" />
	<c:if test="${sessionScope.account != null}">
		<c:set var="logined" value="${sessionScope.logined}"/>
	</c:if>
	<p>
		<div>
			<c:if test="${logined}">
				<h1>${sessionScope.account.getUserName() } 님 환영합니다.</h1>
			</c:if>
		</div>
			<h1>ajax 샘플</h1>
			<p>
				jquery 라이브러리가 필요함 - ajax에 대한 편의성을 제공
			</p>
			<button type="button" onclick="sendAjax();">누르면 aJax 전송</button>
			<button type="button" onclick="sendPost();">Post 전송</button>
			<script type="text/javascript">
				function sendAjax(){
					console.log("Ajax를 시작 합니다.");
					$.ajax({
						url: "./ajax/sample", 
						type: "get",
						data: {
							key: "GET 한글 데이터",
							x:10,
							y:20
						}, 
						dataType: "json",
						success: function(data){
							console.log(data.xy);
							console.log(data.msg);
						} 
					});
				}
				function sendPost(){
					console.log("Post로 보내기 합니다.");
					$.ajax({
						url: "./ajax/sample", 
						type: "POST",
						data: {
							key: "Post 한글 데이터",
							x:10,
							y:20
						}, 
						dataType: "json",
						success: function(data){
							console.log(data.xy);
							console.log(data.msg);
						} 
					});
				}
			</script>
	</p>
</body>
</html>