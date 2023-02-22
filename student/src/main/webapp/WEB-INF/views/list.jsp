<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="demo">
</div>
<script>
	
	function getList(){
		const xhttp = new XMLHttpRequest();
		xhttp.onload = function(){
			let data = this.responseText;
			let obj = JSON.parse(data);
			let demo = document.querySelector("#demo");
			for(let i = 0; i < obj.length; i++){
				demo.innerHTML += obj[i].id + "<br>" + obj[i].pw + "<br>" + obj[i].name + "<br>" obj[i].tel;
			}
		}
		xhttp.open("get", "list", true);
		xhttp.send();
	}
</script>
</body>
</html>