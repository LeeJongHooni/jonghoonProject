<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/sign" method="post">
		<div>
			<label for="userid">아이디</label>
			<input type="text" name="userid" placeholder="userId .." readonly>
			<button type="button" onclick="newScreen_sameId()">중복확인</button>
			<script type="text/javascript">
				function newScreen_sameId(){
					window.open("/sameid","","width=300,height=500");
				}
			</script>
			<hr>
			<label for="password">비밀번호</label>
			<input type="password" name="password" placeholder="password..">
			<hr>
			<label for="email">이메일</label>
			<input type="text" name="email" placeholder="email..">
			<hr>
			<label for="name">이름</label>
			<input type="text" name="name" placeholder="name..">
			<hr>
			<label for="birthday">생년월일</label>
			<input type="date" name="birthday">
			<hr>
		</div>
		<div>
			<button type="submit">가 입 하 기</button>
		</div>
	</form>
	
	<div>
		<c:if test="${sign_error != null}">
			<h5>${sign_error}</h5>
		</c:if>
	</div>
	
</body>
</html>