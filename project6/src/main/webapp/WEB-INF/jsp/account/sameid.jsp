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
<title>Insert title here</title>
</head>
<body>
	<form action="/sameid" method="POST">
		<div>
			<label for="userid">아이디</label>
			<input type="text" name="sameid" placeholder="아이디 중복 검사를 하세요...">
			<button type="button" onclick="sameId()">중복확인</button>
			<script type="text/javascript">
				function sameId(){
					console.log("ajax start!!");
					$.ajax({
						url: "./sameid",
						type: "post",
						data: {
							sameid: document.getElementsByName("sameid")[0].value
						},
						dataType: "json",
						success: function(data){
							console.log(data.sameid);
						}
					});
					if(${applicationScope.noSameId == true}){
						alert('이 아이디를 사용 하실수 있습니다.');
						opener.document.getElementsByName("userid")[0].value =
							document.getElementsByName("sameid")[0].value;
						window.close();
					}else{
						alert('동일한 아이디가 있습니다. 다른아이디를 사용해주세요!');
					}
				}
			</script>
			
		</div>
	</form>
</body>
</html>