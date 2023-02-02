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
			<th>순번</th><th>아이디</th><th>이름</th><th>연락처</th><th>수정</th><th>삭제</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="user" items="${list }" varStatus="status">
		<tr>
			<td>${status.count }</td>
			<td>${user.id }</td>
			<td>${user.name }</td>
			<td>${user.tel }</td>
			<td><input type="button" id="updateBtn" value="수정" onclick="location.href='updateForm?id=${user.id}'"></td>
			<td><input type="button" id="deleteBtn" value="삭제" onclick="location.href='delete.do?id=${user.id}'"></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>