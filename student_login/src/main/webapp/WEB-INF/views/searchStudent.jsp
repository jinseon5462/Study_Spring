<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생조회</title>
</head>
<body>
<div>
	<h3>학생조회하기</h3>
	<hr>
	<input type="text" id="sno" name="searchSno" placeholder="학생번호를 입력해주세요."><br>
	<input type="text" id="name" name="searchName" placeholder="이름을 입력해주세요."><br>
	<input type="button" id="searchBtn" value="조회하기">
</div>
<hr>
<h3>조회 결과</h3>
<form action="goSignUpForm" method="post">
	<input type="text" id="studentNo" name="sno" readonly><br>
	<input type="text" id="studentName" name="name" readonly><br>
	<input type="text" id="studentTel" name="tel" readonly><br>
	<input type="submit" value="사용하기" onclick="return check()">
</form>
<script>
	let searchBtn = document.querySelector("#searchBtn");
	searchBtn.addEventListener("click", search)
	
	function search(){
		if(document.querySelector("#sno").value == ""){
			alert("메뉴를 선택해주세요.");
			return;
		}else if(document.querySelector("#name").value == ""){
			alert("키워드를 입력해주세요.");
			return;
		}else{
			const xhttp = new XMLHttpRequest();
			xhttp.onload = function(){
				let data = this.responseText;
				let obj = JSON.parse(data);
				if(obj == null){
					alert("조회된 학생이 없습니다.");
				}else{
					document.querySelector("#studentNo").value = obj.sno;
					document.querySelector("#studentName").value = obj.name;
					document.querySelector("#studentTel").value = obj.tel;
				}
			}
			let sno = document.querySelector("#sno").value;
			let name = document.querySelector("#name").value;
			
			xhttp.open("post", "search.do", true);
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhttp.send("sno=" + sno + "&name=" + name);
		}
	}
	
	function check(){
		if(document.querySelector("#studentNo").value == ""){
			alert("학생 정보가 존재하지 않습니다.");
			return false;
		}
	}
</script>
</body>
</html>