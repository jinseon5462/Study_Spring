<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>User List Page</h1>
<hr>
<table border="1">
	<thead>
		<tr>
			<th>아이디</th><th>비밀번호</th><th>이름</th><th>연락처</th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>
<script>
	getList();
	function getList(){
		const xhttp = new XMLHttpRequest();
		xhttp.onload = function(){
			let data = this.responseText;
			let obj = JSON.parse(data);
			let tbody = document.querySelector("tbody");
			for(let i = 0; i < obj.length; i++){
				tbody.innerHTML +=
					"<tr>"
					+ "<td>" + obj[i].id + "</td>"
					+ "<td>" + obj[i].pw + "</td>"
					+ "<td>" + obj[i].name + "</td>"
					+ "<td>" + obj[i].tel + "</td>"
					+ "<tr>";
			}
		}
		xhttp.open("get", "/getList.do", true);
		xhttp.send();
	}
</script>
</body>
</html>