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
<script type="text/javascript">
	function profile_photo(f){
		window.open("/infoupdate?id=${sessionScope.account.getId() }","",'width=350,height=500');
	}
</script>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/module/top-navigation.jsp" flush="false"></jsp:include>
	</header>
	<form action="/info" method="post">
		<div>
		<c:choose>
			<c:when test="${sessionScope.updateProfile == null }">
			<table>
				<tr>
					<div>
						<img src="${sessionScope.account.getProfilephotopath() }" width="80" height="80" name="myphoto"/>
						<button type="button" onclick="profile_photo(this.form);">사진등록</button>
					</div>
				</tr>
				<tr>
					<label for="info_username">성함</label>
					<input type="text" value="${sessionScope.account.getUserName() }" name="info_username" readonly/>
				</tr>
				<tr>
					<label for="info_email">이메일</label>
					<input type="text" value="${sessionScope.account.getEmail() }" name="info_email" readonly/>
				</tr>
				<tr>
				<label for=info_birthday">생일</label>
					<input type="text" value="${sessionScope.account.getBirthday() }" name="info_birthday" readonly/>
				</tr>
				<tr>
					<label for="info_signDate">가입날짜</label>
					<input type="text" value="${sessionScope.account.getSignDate() }" name="info_signDate" readonly/>
				</tr>
			</table>
			</c:when>
			<c:when test="${sessionScope.updateProfile != null }">
			<table>
				<tr>
					<div>
						<img src="${sessionScope.updateProfile.getProfilephotopath() }" width="80" height="80" name="myphoto"/>
						<button type="button" onclick="profile_photo(this.form);">사진등록</button>
					</div>
				</tr>
				<tr>
					<label for="info_username">성함</label>
					<input type="text" value="${sessionScope.updateProfile.getUserName() }" name="info_username" readonly/>
				</tr>
				<tr>
					<label for="info_email">이메일</label>
					<input type="text" value="${sessionScope.updateProfile.getEmail() }" name="info_email" readonly/>
				</tr>
				<tr>
				<label for=info_birthday">생일</label>
					<input type="text" value="${sessionScope.updateProfile.getBirthday() }" name="info_birthday" readonly/>
				</tr>
				<tr>
					<label for="info_signDate">가입날짜</label>
					<input type="text" value="${sessionScope.account.getSignDate() }" name="info_signDate" readonly/>
				</tr>
			</table>
			</c:when>
			</c:choose>
		</div>
		<div>
			<a href="/accountdelete"><button type="button">회원탈퇴</button></a>
		</div>
	</form>
</body>
</html>