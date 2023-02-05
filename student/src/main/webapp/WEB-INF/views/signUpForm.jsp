<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="css/signUp.css">
</head>
<body>
	<div class="container">
		<%@ include file="header.jsp" %>
			<form>
				<fieldset>
					<legend>Sign Up</legend>
					<div class="wrap">
						<div id="studentCheckResult">&nbsp;</div>
						<div id="checkIdResult">&nbsp;</div>
						<input type="hidden" id="studentCheckresult" value="">
						<input type="hidden" id="CheckIdresult" value="">
						<input type="text" name="sno" id="sno" maxlength="3" placeholder="학생번호를 입력해주세요."><br>
						<input type="text" name="name" id="name" maxlength="5" placeholder="이름을 입력해주세요."><input type="button" id="studentCheck_btn" value="학생확인"><br>
						<input type="text" name="id" id="id" maxlength="15" placeholder="아이디를 입력해주세요."><input type="button" id="idCheck_btn" value="중복확인"><br>
						<input type="password" name="pw" id="pw" maxlength="15" placeholder="비밀번호를 입력해주세요."><br>
						<input type="text" name="tel" id="tel" maxlength="15" placeholder="전화번호를 입력해주세요."><br>
						<input type="text" id="rdString" maxlength="15" value="" readonly><br>
						<input type="text" id="rdResult" maxlength="15" placeholder="자동입력 방지문자 입력">
					</div>
					<input type="reset" name="reset" id="reset_btn" value="초기화">
					<input type="button" name="reg" id="signUp_btn" value="회원가입">
				</fieldset>
			</form>
		<%@ include file="footer.jsp" %>
	</div>
<script>

	// 자동가입 방지숫자 생성
	$(document).ready(function(){
	let keyList = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
	let temp = "";
		for(let i = 0; i < 6; i++){
			temp += keyList.charAt(Math.floor(Math.random() * keyList.length));
		}
		$("#rdString").val(temp);
	});
	
	
	// 학생확인
	$("#studentCheck_btn").on("click", function(){
		if($("#sno").val() == ""){
			alert("학생번호를 입력해주세요.");
			return;
		}else if($("#name").val() == ""){
			alert("이름을 입력해주세요.");
			return;
		}else{
			const xhttp = new XMLHttpRequest();
			xhttp.onload = function(){
				let data = this.responseText;
				let result = parseInt(data, 10);
				if(result == 1){
					$("#studentCheckResult").text("학생목록에 정보가 존재합니다!");
					$("#studentCheckResult").css("color", "green");
					$("#studentCheckresult").val(1);
				}else{
					$("#studentCheckResult").text("학생목록에 정보가 존재하지 않습니다...");
					$("#studentCheckResult").css("color", "red");
					$("#studentCheckresult").val(0);
				}
			}
			let sno = $("#sno").val();
			let name = $("#name").val();
			
			xhttp.open("post", "studentCheck.do", true);
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhttp.send("sno=" + sno + "&name=" + name);
		}
	});
	
	// 아이디 중복확인
	$("#idCheck_btn").on("click", function(){
		if($("#id").val() == ""){
			alert("아이디를 입력해주세요.");
			return;
		}else{
			const xhttp = new XMLHttpRequest();
			xhttp.onload = function(){
				let data = this.responseText;
				let result = parseInt(data, 10);
				if(result == 0){
					// 아이디 사용가능
					$("#checkIdResult").text("사용가능한 아이디입니다!");
					$("#checkIdResult").css("color", "green");
					$("#CheckIdresult").val(1);
				}else{
					$("#checkIdResult").text("이미 사용중인 아이디입니다...");
					$("#checkIdResult").css("color", "red");
					$("#CheckIdresult").val(0);
				}
			}
			let id = $("#id").val();
			
			xhttp.open("post", "idCheck.do", true);
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhttp.send("id=" + id);
		}
	});
	
	
	// 회원가입실행
	$("#signUp_btn").on("click", function(){
		if($("#sno").val() == ""){
			alert("학생번호를 입력해주세요!");
			return;
		}else if($("#name").val() == ""){
			alert("이름을 입력해주세요!");
			return;
		}else if($("#id").val() == ""){
			alert("아이디를 입력해주세요!");
			return;
		}else if($("#pw").val() == ""){
			alert("비밀번호를 입력해주세요!");
			return;
		}else if($("#tel").val() == ""){
			alert("전화번호를 입력해주세요!");
			return;
		}else if($("#rdResult").val() == ""){
			alert("자동가입 방지문자를 입력해주세요!");
			return;
		}else if($("#rdResult").val() != $("#rdString").val()){
			alert("자동가입 방지문자를 정확히 입력해주세요!");
			return;
		}else if($("#studentCheckresult").val() == ""){
			alert("학생확인 후 이용가능합니다!");
			return;
		}else if($("#studentCheckresult").val() == "0"){
			alert("서울대학교 재학생이 아니면 가입이 불가능합니다!");
			return;
		}else if($("#CheckIdresult").val() == ""){
			alert("아이디 중복확인 후 이용가능합니다!");
			return;
		}else if($("#CheckIdresult").val() == "0"){
			alert("중복된 아이디입니다.\n다른 아이디를 이용부탁드립니다!");
			return;
		}else{
			// 실행
			const xhttp = new XMLHttpRequest();
			xhttp.onload = function(){
				let data = this.responseText;
				if(data == "1"){
					alert("회원가입 성공!");
					location.href = "loginForm";
				}else{
					alert("등록 실패...");
				}
			}
			let sno = $("#sno").val();
			let id = $("#id").val();
			let pw = $("#pw").val();
			let tel = $("#tel").val();
			
			xhttp.open("post", "signUp.do", true);
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhttp.send("sno=" + sno + "&id=" + id + "&pw=" + pw + "&tel=" + tel);
		}
	});
</script>
</body>
</html>