<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/sample/update.do" method="post">
		<table border="1">
			<tr>
				<th>이름</th>
				<td style="display: none;"><input type="text" name="no" value="${sample.no }"></td>
				<td><input type="text" name="name" value="${sample.name }"></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input type="text" name="age" value="${sample.age }"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정"></td>
			</tr>
		</table>
	</form>
</body>
</html>