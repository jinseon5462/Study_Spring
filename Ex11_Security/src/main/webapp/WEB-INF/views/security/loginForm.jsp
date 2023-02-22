<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Login Form</h1>
<hr>
<form action="j_spring_security_check" method="post">
	ID : <input type="text" name="j_username"><br>
	PW : <input type="text" name="j_password"><br>
	<input type="submit" value="LOGIN"><br>
</form>
</body>
</html>