<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Login From</h1>
<hr>
<div>
	<form action="/auth/securitylogin" method="post">
		<input type="text" name="username" placeholder="Enter id"><br>
		<input type="text" name="password" placeholder="Enter pw"><br>
		<input type="submit" value="로그인">
	</form>
</div>
</body>
</html>