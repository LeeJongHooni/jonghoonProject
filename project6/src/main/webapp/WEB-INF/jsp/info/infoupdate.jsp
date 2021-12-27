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
	function update_success(f){
		var createFile = document.createElement("input");
		if(createFile.value != null){
			$.ajax({
				url: "/info",
				type: "post",
				data:{
					profile_photo: f.profile_upload.value
				},
				dateType : "json",
				success: function(data){
					document.getElementsByName("profile_photo")[0].src = data.profile_photo
				}
			});
		}
	}
	
</script>
</head>
<body>
	<form action="/info" method="post">
		<div>
			<table>
				<tr>
					<div>
						<img src="" width="80" height="80" name="profile_photo"/>
						<button type="button" onclick="profile_update();">사진등록</button>
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
				<tr>
					<button type="button" onclick="update_success(this.form);">등록</button>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>