<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>등록하기</h1>
<hr>
<form action="reg.do" method="post">
	<table border="1">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id" placeholder="아이디를 입력해주세요."></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="text" name="pw" placeholder="비밀번호를 입력해주세요."></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" placeholder="이름을 입력해주세요."></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input type="text" name="tel" placeholder="전화번호를 입력해주세요."></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="등록하기">
				<input type="reset" value="초기화">
			</td>
		</tr>
	</table>
</form>
</body>
</html>