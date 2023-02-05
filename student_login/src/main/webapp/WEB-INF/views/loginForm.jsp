<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<style>
	fieldset{
		width: 300px;
		height: 100px;
		text-align: center;
	}
	legend{
		text-align: center;
	}
	
</style>
<body>
<h1>로그인</h1>
<hr>
	<form action="login.do" method="post">
		<fieldset>
			<legend>Login</legend>		
			<input type="text" name="id" id="input_id" placeholder="아이디를 입력하세요."><br>
			<input type="password" name="pw" id="input_pw" placeholder="비밀번호를 입력하세요."><br>
			<input type="reset" value="초기화">
			<input type="submit" value="로그인">
		</fieldset>
	</form>
<c:if test="${result == 1}">
	<script>
		alert("로그인 성공!");
		location.href = "/";
	</script>
</c:if>
<c:if test="${result == 0}">
	<script>
		if(confirm("로그인 실패\n회원이 아니라면 회원가입을 진행하시겠습니까?") == true){
			location.href = "signUpForm";
		}
	</script>
</c:if>
</body>
</html>