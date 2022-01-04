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
	<form action="accountdelete" method="post">
		<p>정말로 회원 탈퇴를 하시겠습니까 ?</p>
		<input type="checkbox" name="deleteCheck">
		<div>
			<button type="submit">탈퇴하기</button>
		</div>
		<c:if test="${deleteAccount_error != null}">
			<script type="text/javascript">
					alert('${deleteAccount_error}');
			</script>
		</c:if>
		<c:if test="${deleteCheck_error != null}">
			<script type="text/javascript">
					alert('${deleteCheck_error}');
			</script>
		</c:if>
	</form>
</body>
</html>