<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>수정하기</h1>
<hr>
<form action="update.do" method="post">
<table border="1">
	<tr>
		<th>아이디</th>
		<td><input type="text" name="id" value="${user.id }" readonly></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="text" name="pw" value="${user.pw }"></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><input type="text" name="name" value="${user.name }"></td>
	</tr>
	<tr>
		<th>전화번호</th>
		<td><input type="text" name="tel" value="${user.tel }"></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="수정하기">
			<input type="reset" value="초기화">
		</td>
	</tr>
</table>
</form>

</body>
</html>