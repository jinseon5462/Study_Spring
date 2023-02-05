<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="css/loginForm.css">
</head>
<body>
	<div class="container">
		<%@ include file="header.jsp" %>
			<form>
				<div class="login_box">
					<h1>Login</h1>
					<input type="text" id="id" name="id" maxlength="15" placeholder="아이디를 입력해주세요."><br>
					<input type="password" id="pw" name="pw" maxlength="15" placeholder="비밀번호를 입력해주세요."><br>
					<input type="reset" id="resetBtn" value="초기화">
					<input type="button" id="loginDoBtn" value="로그인">
				</div>
			</form>
		<%@ include file="footer.jsp" %>
	</div>

<script>
	$("#loginDoBtn").on("click", function(){
		if($("#id").val() == ""){
			alert("아이디를 입력해주세요.");
			return false;
		}else if($("#pw").val() == ""){
			alert("비밀번호를 입력해주세요.");
			return false;
		}else{
			const xhttp = new XMLHttpRequest();
			xhttp.onload = function(){
				let data = this.responseText;
				let result = parseInt(data, 10);
				if(result == 1){
					alert("로그인 성공!");
					location.href = "/";
				}else{
					alert("로그인 실패...");
					if(confirm("회원가입이 되어있지 않다면 회원가입을 진행하시겠습니까?") == true){
						location.href = "signUpForm";
					}
				}
			}
			
			let id = $("#id").val();
			let pw = $("#pw").val();
			xhttp.open("post", "login.do", true);
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhttp.send("id=" + id + "&pw=" + pw);
		}
	});
</script>
</body>
</html>