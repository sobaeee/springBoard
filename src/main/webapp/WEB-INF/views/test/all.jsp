<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All page</title>
</head>
<body>
<h1>All page</h1>

<sec:authorize access="isAnonymous()"><!-- isAnonymous : 익명의 사용자의 경우, 로그인 하지 않은 경우 -->
<a href="/customLogin">로그인</a>
</sec:authorize>

<sec:authorize access="isAuthenticated()"> <!-- isAuthenticated : 인증된 사용자라면 true -->
<form action="/customLogout" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<button>Logout</button>
</form>
</sec:authorize>
</body>
</html>