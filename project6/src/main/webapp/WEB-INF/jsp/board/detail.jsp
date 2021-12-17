<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/jsp/head/default.jsp" flush="flase"></jsp:include>
<title>Insert title here</title>
<script type="text/javascript">
	function delete_confirm(){
		var frm = document.hiddenfrm;
		if(confirm("게시글 삭제를 하시겠습니까?") == true){
			alert("게시글 삭제 하셨습니다.");
			return true;
		}else{
			alert("게시글 삭제를 취소 하셨습니다.");
			return false;	
		}
	}
</script>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/module/top-navigation.jsp" flush="flase"></jsp:include>
	</header>
	<div>
		<table>
			<c:forEach var="detail" items="${applicationScope.details}">
				<tr>
					<th><h2>${detail.getwTitle() }</h2></th>
					<td><fmt:formatDate value="${detail.getwDate() }" type="both" dateStyle="long" timeStyle="long"/></td>
				</tr>
				<tr>
					<td>
						<h4>${detail.getwContent() }</h4>
					</td>			
				</tr>
				<tr>
					<td>
					<c:set var="filePath" value="${detail.getDownloadpath()}"/>
					<c:set var="fileNameArr" value="${fn:split(filePath,'/')}"/>
					
					<c:forEach var="fileName" items="${fileNameArr }" varStatus="i">
					 	<c:if test="${i.last}">
							<a href="${detail.getDownloadpath() }" download>${fileName}</a>								 	
					 	</c:if>
					</c:forEach>
					
					</td>
				</tr>
				<tr>
				<c:set var="signId" value="${detail.getSignId()}"/>
				<c:set var="pkId" value="${sessionScope.userPkId}"/>
				<c:if test="${signId == pkId}">
					<td>
						<c:url var="update" value="/writer">
							<c:param name="update" value="yes"/>
							<c:param name="wnum" value="${detail.getwNum()}"/>
						</c:url>
						<button><a href="${update}">수 정</a></button>
					</td>
					<td>	
						<c:url var="delete" value="/delete">
							<c:param name="wnum" value="${detail.getwNum()}"/>
						</c:url>
						<button type="submit"><a href="${delete}" onclick="return delete_confirm()" name="delete">삭 제</a></button>
						<form method="get" name="hiddenfrm">
							<input type="hidden" name="hiddenval" value=""/>
						</form>				
					</td>	
				</c:if>				
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>