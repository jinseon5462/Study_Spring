<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	int rdNum = (int) (Math.random() * (9999)) + 1000;
	pageContext.setAttribute("rdNum", rdNum);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<h1>회원가입</h1>
<hr>
<form action="signUp.do" method="post">
	<table border="1">
		<tr>
			<td colspan="2" style="text-align:center;"><a href="searchStudent">학생조회</a></td>
		</tr>
		<tr>
			<th>중복확인 결과</th>
			<td><input type="text" id="result" name="result" readonly></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id" id="id" placeholder="아이디를 입력해주세요."><input type="button" id="idCheckBtn" value="중복확인">
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pw" id="pw" placeholder="비밀번호를 입력해주세요.">
		</tr>
		<tr>
			<th>학생번호</th>
			<td><input type="text" name="sno" id="sno" value="${student.sno }">
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" id="name" maxlength="5" placeholder="이름을 입력해주세요." value="${student.name }">
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input type="text" name="tel" id="tel" maxlength="13" placeholder="전화번호를 입력해주세요." value="${student.tel }">
		</tr>
		<tr>
			<th>자동입력방지숫자</th>
			<td colspan="2">
				<input type="text" id="rdNum" value="${rdNum }" readonly><br>
				<input type="text" id="input_rdNum" placeholder="위의 숫자를 입력해주세요.">
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;">
				<input type="reset" value="초기화">
				<input type="submit" value="회원가입" onclick="return check()">
			</td>
		</tr>
	</table>
</form>
<c:if test="${result == 1 }">
	<script>
		alert("회원가입 성공!");
		location.href = "loginForm";
	</script>
</c:if>

<c:if test="${result == 0 }">
	<script>
		alert("회원가입 실패...");
	</script>
</c:if>
<script>
	let idCheckBtn = document.querySelector("#idCheckBtn");
	idCheckBtn.addEventListener("click", function(){
		const xhttp = new XMLHttpRequest();
		xhttp.onload = function(){
			let data = this.responseText;
			let result = parseInt(data, 10);
			if(result == 1){
				document.querySelector("#result").value = "이미 사용중인 아이디입니다.";
				document.querySelector("#result").style.color = "red";
			}else{
				document.querySelector("#result").value = "사용가능한 아이디입니다.";
				document.querySelector("#result").style.color = "green";
			}
		}
		let id = document.querySelector("#id").value;
		xhttp.open("POST", "idCheck.do", true);
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhttp.send("id=" + id);
	});
	
	function check(){
		if(document.querySelector("#result").value == ""){
			alert("아이디 중복확인 후 이용가능합니다.");
			return false;
		}else if(document.querySelector("#id").value == ""){
			alert("아아디를 입력해주세요.");
			return false;
		}else if(document.querySelector("#pw").value == ""){
			alert("비밀번호를 입력해주세요.");
			return false;
		}else if(document.querySelector("#sno").value == ""){
			alert("학생조회 후 이용가능합니다.");
			return false;
		}else if(document.querySelector("#name").value == ""){
			alert("학생조회 후 이용가능합니다.");
			return false;
		}else if(document.querySelector("#tel").value == ""){
			alert("학생조회 후 이용가능합니다.");
			return false;
		}else if(document.querySelector("#input_rdNum").value == ""){
			alert("자동입력 방지 숫자를 입력해주세요.");
			return false;
		}else if(document.querySelector("#rdNum").value != document.querySelector("#input_rdNum").value){
			alert("자동입력 방지 숫자가 일치하지 않습니다.");
			return false;
		}else{
			return true;
		}
	}
</script>
</body>
</html>