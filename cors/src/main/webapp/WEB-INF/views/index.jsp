<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Index Page</h1>
<hr>
<input type="text" name="name">
<input type="button" value="요청" onclick="getUser()">
<div id="result">여기에 조회 결과가 표시됩니다.</div>
<script>
	function getUser(){
		const name = document.querySelector("input[name='name']").value;
		const xhttp = new XMLHttpRequest();
		xhttp.onload = function(){
			document.querySelector("#result").innerHTML = this.responseText;
		}
		xhttp.open("get", "http://localhost:9001/api/exam/get-api/user/" + name, true);
		xhttp.send();
	}
</script>
</body>
</html>