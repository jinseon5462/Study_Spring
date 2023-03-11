<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Regist User</h1>
<hr>
<div>
	<form action="/regist" method="post">
		<input type="text" name="id" placeholder="Enter id"><br>
		<input type="text" name="pw" placeholder="Enter pw"><br>
		<input type="text" name="name" placeholder="Enter name"><br>
		<input type="text" name="tel" placeholder="Enter tel"><br>
		<input type="submit" value="등록">
	</form>
</div>
</body>
</html>