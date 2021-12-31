<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="/js/jquery-3.6.0.min.js"></script>
<jsp:include page="/WEB-INF/jsp/head/default.jsp" flush="false"></jsp:include>
<title>Insert title here</title>
<script type="text/javascript">
	function profile_update(){
		var myPhoto = document.getElementsByName("profile_photo")[0];
		var createFile = document.createElement("input");
		createFile.setAttribute("type","file","name","profile_upload");
		createFile.setAttribute("name","profile_upload");
		myPhoto.after(createFile);
	}
</script>
</head>
<body>
	<form action="/infoupdate" method="post" enctype="multipart/form-data">
		<div>
		<c:choose>
			<c:when test="${sessionScope.updateProfile == null }">
			<table>
				<tr>
					<div>
						<img src="${sessionScope.account.getProfilephotopath() }" width="80" height="80" name="profile_photo"/>
						<button type="button" onclick="profile_update();">사진등록</button>
					</div>
				</tr>
				<tr>
					<label for="info_username">성함</label>
					<input type="text" value="${sessionScope.account.getUserName() }" name="info_username"/>
				</tr>
				<tr>
					<label for="info_email">이메일</label>
					<input type="text" value="${sessionScope.account.getEmail() }" name="info_email"/>
				</tr>
				<tr>
				<label for=info_birthday">생일</label>
					<input type="text" value="${sessionScope.account.getBirthday() }" name="info_birthday"/>
				</tr>
				<tr>
					<label for="info_signDate">가입날짜</label>
					<input type="text" value="${sessionScope.account.getSignDate() }" name="info_signDate" readonly/>
				</tr>
				<tr>
					<button type="submit" onsubmit="window.close();">등록</button>
				</tr>
			</table>
			</c:when>
			<c:when test="${sessionScope.updateProfile != null }">
			<table>
				<tr>
					<div>
						<img src="${sessionScope.updateProfile.getProfilephotopath() }" width="80" height="80" name="profile_photo"/>
						<button type="button" onclick="profile_update();">사진등록</button>
					</div>
				</tr>
				<tr>
					<label for="info_username">성함</label>
					<input type="text" value="${sessionScope.updateProfile.getUserName() }" name="info_username"/>
				</tr>
				<tr>
					<label for="info_email">이메일</label>
					<input type="text" value="${sessionScope.updateProfile.getEmail() }" name="info_email"/>
				</tr>
				<tr>
				<label for="info_birthday">생일</label>
					<input type="text" value="${sessionScope.updateProfile.getBirthday() }" name="info_birthday"/>
				</tr>
				<tr>
					<label for="info_signDate">가입날짜</label>
					<input type="text" value="${sessionScope.account.getSignDate() }" name="info_signDate" readonly/>
				</tr>
				<tr>
					<button type="submit" onsubmit="window.close();">등록</button>
				</tr>
			</table>
			</c:when>
		</c:choose>
		</div>
	</form>
</body>
</html>