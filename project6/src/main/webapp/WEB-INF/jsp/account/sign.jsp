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
	<script>
		function sign_alert(){
			if(${sign-error != 0}){
				alert('회원가입에 실패 하셨습니다.');
			}else{
				alert('회원가입에 성공 하셨습니다.');
			}
		}
	</script>
<body>

	<form action="/sign" method="post">
		<div>
			<label for="userid">아이디</label>
			<input type="text" name="userid" placeholder="userId ..">
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
			<button type="submit" onclick="sign_alert()">가 입 하 기</button>
		</div>
	</form>
	
		<div>
		
			<h6>${sign_error }</h6>
		
		<c:set var="x" value="hello"/>
		<c:set var="p1" value="hello page scope" scope="page"/>
		<c:set var="r1" value="hello Request Scope" scope="request"/>
		<c:set var="s1" value="hello Session Scope" scope="session"/>
		<c:set var="a1" value="hello Application Scope" scope="application"/>
		
		${x}
		Page : ${p1}<br>
		Request : ${r1}<br>
		Session : ${SessionScope.s1}<br>
		Application : ${applicationScope.a1}<br>
	</div>
	
</body>
<
</html>