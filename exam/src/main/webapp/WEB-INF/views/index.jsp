<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Exam Page</h1>
<hr>

	<h3>C : 등록</h3>
	<table border="1">
		<tr>
			<th>이름</th>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<th>나이</th>
			<td><input type="text" name="age"></td>
		</tr>
		
		<tr>
			<td colspan="2"><div id="regResult">등록결과가 이곳에 표시됩니다.</div></td>
		</tr>
	</table>
	<input type="button" value="등록" onclick="regUser()">
	<hr>
	<h3>R : 조회</h3>
	<table border="1">
		<tr>
			<th>이름</th>
			<td><input type="text" name="rName"></td>
		</tr>
		<tr>
			<th>결과</th>
			<td><div id="readResult">조회 결과가 여기에 표시됩니다.</div></td>
		</tr>
	</table>
	<input type="button" value="조회" onclick="readUser()">
	<hr>
	<h3>U : 수정</h3>
	<table border="1">
		<tr>
			<th>수정할 회원의 이름</th>
			<td><input type="text" name="selectName"></td>
		</tr>
		<tr>
			<th>수정할 이름</th>
			<td><input type="text" name="updateName"></td>
		</tr>
		<tr>
			<th>수정할 나이</th>
			<td><input type="text" name="updateAge"></td>
		</tr>
		<tr>
			<th>수정결과</th>
			<td><div id="updateResult">여기에 수정결과가 표시됩니다.</div></td>
		</tr>
	</table>
	<input type="button" value="수정" onclick="updateUser()">
	<hr>
	<h3>D : 삭제</h3>
	<table border="1">
		<tr>
			<th>삭제할 회원의 이름</th>
			<td><input type="text" name="dName"></td>
		</tr>
		<tr>
			<th>수정결과</th>
			<td><div id="deleteResult">여기에 삭제결과가 표시됩니다.</div></td>
		</tr>
	</table>
	<input type="button" value="삭제" onclick="deleteUser()">
<script>

	// 등록
	function regUser(){
		const xhttp = new XMLHttpRequest();
		xhttp.onload = function(){
			let data = this.responseText;
			let result = parseInt(data, 10);
			if(result == 1){
				document.querySelector("#regResult").innerHTML = "<span style='color:green;'>등록성공!<span>"; 
			}else{
				document.querySelector("#regResult").innerHTML = "<span style='color:red;'>등록실패...<span>"; 
			}
		}
		let name = document.querySelector("input[name='name']").value;
		let age = document.querySelector("input[name='age']").value;
		const obj = {
				name : name,
				age : age
		}
		const user = JSON.stringify(obj);
		xhttp.open("post", "/api/exam/post-api/user", true);
		xhttp.setRequestHeader("Content-type", "application/json");
		xhttp.send(user);
	}
	
	// 조회
	function readUser(){
		const xhttp = new XMLHttpRequest();
		xhttp.onload = function(){
			let data = this.responseText;
			let obj = JSON.parse(data);
			if(obj != null){
				document.querySelector("#readResult").innerHTML = "<span style='color:green;'>이름 : " + obj.name + ", 나이 : " + obj.age + "</span>"; 
			}else{
				document.querySelector("#readResult").innerHTML = "<span style='color:red;'>조회된 결과가 없습니다.</span>"; 
			}
		}
		let rName = document.querySelector("input[name='rName']").value;
		alert(rName);
		xhttp.open("get", "/api/exam/get-api/user/" + rName, true);
		xhttp.send();
	}
	
	
	// 수정
	
	function updateUser(){
		const xhttp = new XMLHttpRequest();
		xhttp.onload = function(){
			document.querySelector("#updateResult").innerHTML = this.responseText;
		}
		let name = document.querySelector("input[name='selectName']").value;
		let uName = document.querySelector("input[name='updateName']").value;
		let uAge = document.querySelector("input[name='updateAge']").value;
		const obj = {
			name : uName,
			age : uAge
		}
		const user = JSON.stringify(obj);
		xhttp.open("put", "/api/exam/put-api/user/" + name, true);
		xhttp.setRequestHeader("Content-type", "application/json");
		xhttp.send(user);
	}
	
	// 삭제
	function deleteUser(){
		const xhttp = new XMLHttpRequest();
		xhttp.onload = function(){
			document.querySelector("#deleteResult").innerHTML = this.responseText;
		}
		let name = document.querySelector("input[name='dName']").value;
		xhttp.open("delete", "/api/exam/delete-api/user/" + name, true);
		xhttp.send();
	}
</script>
</body>
</html>