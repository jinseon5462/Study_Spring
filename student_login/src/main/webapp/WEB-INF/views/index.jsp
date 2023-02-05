<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>메인페이지</h1>
<hr>
여기는 메인페이지페이지페이지페이지페이지페이지페이지페이지페이지페이지페이지페이지페이지<br>
<c:if test="${sessionScope.id == null }">
	<button type="button" id="goLogingBtn" onclick="location.href='loginForm'">로그인하기</button>
	<button type="button" id="goSignUpBtn" onclick="location.href='signUpForm'">회원가입하기</button>
</c:if>
<c:if test="${sessionScope.id != null }">
	<button type="button" id="goLogoutBtn" onclick="location.href='logout'">로그아웃</button>
</c:if>
</body>
</html>