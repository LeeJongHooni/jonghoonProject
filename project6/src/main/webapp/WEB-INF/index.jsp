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
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/module/top-navigation.jsp" flush="flase"></jsp:include>
	</header>
	<c:set var="logined" value="false" />
	<c:if test="${sessionScope.account != null}">
		<c:set var="logined" value="${sessionScope.logined}"/>
	</c:if>
	<p>
		<div>
			<c:if test="${logined}">
				<h1>${sessionScope.account.getUserid() } 님 환영합니다.</h1>
			</c:if>
			<c:set var="x" value="hello"/>
			<c:set var="p1" value="hello page scope" scope="page"/>
			<c:set var="r1" value="hello Request Scope" scope="request"/>
			<c:set var="s1" value="hello Session Scope" scope="session"/>
			<c:set var="a1" value="hello Application Scope" scope="application"/>
		
			Page : ${p1}<br>
			Request : ${r1}<br>
			Session : ${SessionScope.s1}<br>
			Application : ${applicationScope.a1}<br>
			
		</div>
		<hr>
		EL(Expression Langguage)<br>
		자바 코드가 들어가는 표현식을 좀 더 편하게 사용하기 위해 쓰인다.<br>
		기존표현식 보다 편리하게 값을 출력할수 있다.<br>
		변수와 여러 연산자를 포함 할 수 있다.<br>
		JSP의 내장 객체에 저장된 속성을 출력할수 있다.<br>
		표현 언어 자체의 내장객체 제공<br>
		
		-pageScope  :JSP의 page 영역에 바인딩된 객체 참조<br>
		-requestScope :request에 바인딩된 객체 참조<br>
		-sessionScope :session에 바인딩된 객체 참조<br>
		-applicationScope :application 에 바인딩된 객체 참조<br>
		-param : request.getParameter 를 사용하는것과 동일<br>
		-Cookies : Cookies 객체를 참조<br>
		
		사용 형식-><br><%-- ${변수명 또는 객체명} --%>10 + 10 = ${10 + 10}<br>
				10 - 10 = ${10 - 10}<br>
				10 * 10 = ${10 * 10}<br>
				10 / 10 = ${10 / 10}<br>
				10 div 10 = ${10 div 10}<br>
				10 mod 10 = ${10 mod 10}<br>
				1 == 1 = ${1 == 1}<br>
				"abcd" == "abcd" = ${"abcd" == "abcd"}<br>
				"abcd" eq "abcd" = ${"abcd" eq "abcd"}<br>
				1 != 1 = ${1 != 1}<br>
				"abcd" != "abcd" = ${"abcd" != "abcd"}<br>
				"abcd" ne "abcd" = ${"abcd" ne "abcd"}<br>
				<hr>
				1 &gt; 2 -> ${1 > 2}<br>
				1 gt 2 -> ${1 gt 2}<br>
				1 &gt;= 2 -> ${1 >= 2}<br>
				1 ge 2 -> ${1 ge 2}<br>
				1 &lt; 2 -> ${1 < 2}<br>
				1 lt 2 -> ${1 lt 2}<br>
				1 &lt;= 2 -> ${1 <= 2}<br>
				1 le 2 -> ${1 le 2}<br>
				<hr>
				true && true = ${true && true}<br>
				true and true = ${true and true}<br>
				true || false = ${true || false}<br>
				true or false = ${true or false}<br>
				!true = ${!true}<br>
				not true = ${not true}<br>
				<hr>
				${empty ""}<br>
				${empty null}<br>
				${empty " "}<br>
				<hr>
				${true? "참":"거짓"}<br>
				
				<%
						pageContext.setAttribute("x", 10);//page 스코프 영역에서 사용할 객체 생성
						pageContext.setAttribute("y", 20);//page 스코프는 현재 JSP페이지 에서만 유효하게 사용할수 있는 영역으로 한정
				%>
				${x + y}<br>
				${x - y}<br>
				${x * y}<br>
				${x / y}<br>
				
			pageSCope(우선참조) 가 없으면 RequestScope로 자동으로 넘어가서 참조함.<br>
			<%
				getServletContext().setAttribute("data","application");
			%>
			${applicationScope.data}<br>
			<div>
				<div style="background-color:tomato;width:50px;height:50px;position:relative;top:1">page(JSP)</div>
				<div style="background-color:yellow;width:75px;height:75px;position:relative;top:2">request(servlet,jsp,forward)</div>
				<div style="background-color:teal;width:100px;height:100px;position:relative;top:3">session (browser,user,device)</div>
				<div style="background-color:coral;width:125px;height:125px;position:relative;top:4">Application(server)</div>
			</div>
			<div>
				JSTL (JSP Standard Tag Library)<br>
					-JSP 에서 가장많이 사용하는 기능을 태그로 제공<br>
					-코어 포멧 함수 태그 기능을 제공<br>
						-코어 : 변수 사용 및 흐름 제어와 관련된 기능 제공 <br>
						-포멧 : 날짜 숫자 포멧 형식 기능 제공 <br>
						<%-- <fmt:기능명/> --%>
						-함수 : 문자열 관련 함수 제공<br> 
						<%-- ${fn:함수명()} --%>
						
			</div>
			<div>
				<ul>
					<c:forTokens var="s" items="java, javascript, python, c++" delims=",">
						<li>${s}</li>
					</c:forTokens>
				</ul>
				
				<c:url var="url" value="/url/path" >
					<c:param name="id" value="10" />
					<c:param name="password" value="jognhog" />
				</c:url>
				<span>${url}</span>
			</div>
			<div>
				<fmt:formatNumber value="100" type="number" /><br>
				<fmt:formatNumber value="0.9" type="percent" /><br>
				<fmt:formatNumber value="100000000" type="currency" groupingUsed="true" currencySymbol="$" /><br>
				
				<hr>
    	<% java.util.Date date = new java.util.Date();
    		pageContext.setAttribute("now", date); %>
		    	<fmt:formatDate value="${now}" type="date" /><br>
		    	<fmt:formatDate value="${now}" type="date" dateStyle="full" /><br>
		    	<fmt:formatDate value="${now}" type="date" dateStyle="long" /><br>
		    	<fmt:formatDate value="${now}" type="date" dateStyle="medium" /><br>
		    	<fmt:formatDate value="${now}" type="date" dateStyle="short" /><br>
		    	<fmt:formatDate value="${now}" type="date" pattern="YYYY-MM-dd EEEE(E)" /><br>
		    	<hr>
		    	<fmt:formatDate value="${now}" type="time" /><br>
		    	<fmt:formatDate value="${now}" type="time" timeStyle="full" /><br>
		    	<fmt:formatDate value="${now}" type="time" timeStyle="long" /><br>
		    	<fmt:formatDate value="${now}" type="time" timeStyle="medium" /><br>
		    	<fmt:formatDate value="${now}" type="time" timeStyle="short" /><br>
		    	<fmt:formatDate value="${now}" type="time" pattern="a hh:mm:ss.SSS z" /><br>
		    	<fmt:formatDate value="${now}" type="time" pattern="H:mm:ss.SSS Z" /><br>
		    	<fmt:formatDate value="${now}" type="time" pattern="a hh:mm:ss.SSS Z z" timeZone="America/New_York" /><br>
		    	<fmt:formatDate value="${now}" type="time" pattern="a hh:mm:ss.SSS Z z" timeZone="Asia/Tokyo" /><br>
		    	<fmt:formatDate value="${now}" type="time" pattern="a hh:mm:ss.SSS Z z" timeZone="Europe/Paris" /><br>
		    	<hr>
		    	<fmt:formatDate value="${now}" type="both" /><br>
		    	<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" /><br>
		    	<fmt:formatDate value="${now}" type="both" dateStyle="long" timeStyle="long" /><br>
		    	<fmt:formatDate value="${now}" type="both" dateStyle="medium" timeStyle="medium" /><br>
		    	<fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short" /><br>
			</div>
			<div>
				fn:contains(전체문자열, 일부문자열)<br>
				fn:indexOf(전체문자열,일부문자열)<br>
				fn:length(문자열)<br>
				fn:replace(전체문자열,일부문자열,바꿀문자열)<br>
				fn:toLower(문자열)<br>
				fn:toUpper(문자열)<br>
				fn:subString(전체문자열,시작위치,끝위치)<br>
				fn:split(전체문자열,분리기준문자열)<br>
				fn:trim(전체문자열,[제거할문자])<br>
				fn:join(문자열배열,결합문자열)<br>
			</div>
	</p>
</body>
</html>