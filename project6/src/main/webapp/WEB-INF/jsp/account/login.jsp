<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/js/jquery-3.6.0.min.js"></script>
<jsp:include page="/WEB-INF/jsp/head/default.jsp" flush="false"></jsp:include>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/module/top-navigation.jsp" flush="false"></jsp:include>
	</header>
	<script type="text/javascript">
		function isvalid_login(f){
			$.ajax({
				url: "/login",
				type: "post",
				data: {
					userid: f.userid.value,
					user_password: f.user_password.value
				},
				dataType: "json",
				success: function(data){
					if(data.state === "success"){
						location.href="/";
					}else{
						alert('로그인에 실패하셨습니다. 아이디와 비밀번호를 확인하세요!');
					}
				}
			});
		}
	</script>
	<div>
		<form action="/login" method="post">
			<input type="text" placeholder="id..." name="userid">
			<hr>
			<input type="password" placeholder="password..." name="user_password">	
			<hr>
			<button type="button" onclick="isvalid_login(this.form);">login..</button>
		</form>
	</div>

</body>
</html>