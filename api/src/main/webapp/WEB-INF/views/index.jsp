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
<div>
	Parameters:<br>
	param1 : <input type="text" name="name" value="James"><br>
	param2 : <input type="text" name="email" value="james5462@gmail.com"><br>
	param3 : <input type="text" name="organization" value="JamesCorp"><br>
</div>
<div>
	<button onclick="requestGet()">Get 요청</button>
	<button onclick="requestPost()">Post 요청</button>
	<button onclick="requestPut()">Put 요청</button>
	
</div>
<div id="demo"></div>
<script>
	function requestGet() {
		const xhttp = new XMLHttpRequest();
	  	xhttp.onload = function() {
	    	document.getElementById("demo").innerHTML = this.responseText;
	    }
		const param1 = document.querySelector("input[name='name']").value;
		const param2 = document.querySelector("input[name='email']").value;
		const param3 = document.querySelector("input[name='organization']").value;
		
		const uri = "/api/v1/get-api/request1/?name=" + param1
				+ "&email=" + param2 + "&organization=" + param3;
	  	xhttp.open("get", uri, true);
	  	xhttp.send();
	}
	
	function requestPost() {
		const xhttp = new XMLHttpRequest();
	  	xhttp.onload = function() {
	    	document.getElementById("demo").innerHTML = this.responseText;
	    }
		
	  	xhttp.open("post", "/api/v1/post-api/user2", true);
	  	xhttp.setRequestHeader("Content-type", "application/json");
	  	xhttp.send('{"name":"value1", "email":"value2", "organization":"value3"}');
	}
	
	function requestPut(){
		const xhttp = new XMLHttpRequest();
		xhttp.onload = function(){
			document.getElementById("demo").innerHTML = this.responseText;
		}
		xhttp.open("put", "/api/v1/put-api/user1", true);
	  	xhttp.setRequestHeader("Content-type", "application/json");
	  	xhttp.send('{"name":"cucu", "email":"cucu@", "organization":"home"}');
	}
	
	
</script>
</body>
</html>