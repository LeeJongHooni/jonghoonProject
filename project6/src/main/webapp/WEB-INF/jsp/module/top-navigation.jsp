<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">

      <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
 		<c:forEach var="menu" items="${applicationScope.menus}">     
        	<li><a href="${menu.getMenuURL()}" class="nav-link px-2 link-secondary active">${menu.getMenuName()}</a></li>
        </c:forEach>
      </ul>

      <div class="col-md-3 text-end">
      <c:choose>
      	<c:when test="${sessionScope.logined == null }">
	        <a href="<%=request.getContextPath() + "/login"%>"><button type="button" class="btn btn-outline-primary me-2">Login</button></a>
	        <a href="<%=request.getContextPath() + "/sign"%>"><button type="button" class="btn btn-primary">Sign-up</button></a>
 		</c:when>
 		<c:when test="${sessionScope.logined != null }">
 			<a href="<%=request.getContextPath() + "/logout"%>"><button type="button" class="btn btn-outline-primary me-2">Logout</button></a>
	        <a href="<%=request.getContextPath() + "/info"%>"><button type="button" class="btn btn-primary">info</button></a>
 		</c:when>
      </c:choose>
      </div>
    </header>
 