<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="css/header.css">
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="js/header.js"></script>

<header>
	<img src="images/seoul.png" id="main_logo">
	<nav id="nav_bar">
		<ul>
			<li>홈</li>
			<li>게시판</li>
			<li>공지</li>
			<li>강의평</li>
		</ul>
	</nav>
	<div class="buttons">
	<!-- 비로그인 -->
	<c:if test="${sessionScope.id == null}">
		<button type="button" id="loginBtn">로그인</button>
		<button type="button" id="signUpBtn">회원가입</button>
	</c:if>
	<!-- 로그인 -->
	<c:if test="${sessionScope.id != null}">
		<button type="button" id="myPageBtn">내정보</button>
		<button type="button" id="logoutBtn">로그아웃</button>
	</c:if>
	</div>
	<input type="hidden" value="${sessionScope.id }">
</header>