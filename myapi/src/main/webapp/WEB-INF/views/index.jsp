<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Test Api</h1>
<hr>
<div>
	<h3>C : 등록</h3>
	<input type="text" name="name" placeholder="name..."><br>
	<input type="text" name="age" placeholder="age..."><br>
	<input type="button" value="등록" onclick="regMember()">
	<div id="result_reg">여기에 등록 결과가 나와요.</div>
	<hr>
	<h3>U : 수정</h3>
	<input type="text" id="updateName" name="name"><br>
	<input type="text" id="updateAge" name="age"><br>
	<input type="button" value="수정" onclick="update()">
	<div id="result_update">여기에 수정 결과가 나와요.</div>
</div>
<script>
	function regMember(){
		//alert("regMember...");
		const uname = document.querySelector("input[name='name']").value;
		const uage = document.querySelector("input[name='age']").value;
		//alert("uname : " + uname);
		const obj_user = {
				name : uname,
				age : uage
		}
		const json_user = JSON.stringify(obj_user);
		//alert("json_user" + json_user);
		const xhttp = new XMLHttpRequest();
		xhttp.onload = function(){
			document.querySelector("#result_reg").innerHTML = this.responseText;
		}
		
		xhttp.open("post", "/api/post-api/user", true);	// 유저 등록
		xhttp.setRequestHeader("Content-type", "application/json");
		xhttp.send(json_user);
	}
	
	function update(){
		const name = document.querySelector("#updateName").value;
		const age = document.querySelector("#updateAge").value;
		
		const obj_user = {
				name : name,
				age : age
		}
		const user = JSON.stringify(obj_user);
		const xhttp = new XMLHttpRequest();
		xhttp.onload = function(){
			document.querySelector("#result_update").innerHTML = this.responseText;
		}
		xhttp.open("put", "/api/put-api/user", true);
		xhttp.setRequestHeader("Content-type", "application/json");
		xhttp.send(user);
	}
</script>
</body>
</html>