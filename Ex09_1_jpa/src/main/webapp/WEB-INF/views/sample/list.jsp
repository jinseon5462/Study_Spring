<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<h1>테이블</h1>
<table border="1">
	<thead>
		<tr>
			<th>번호</th><th>이름</th><th>나이</th><th>수정</th><th>삭제</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="user" items="${list }">
		<tr>
			<td>${user.no }</td>
			<td>${user.name }</td>
			<td>${user.age }</td>
			<td><button class="updateBtn" type="button" value="${user.no }">수정</button></td>
			<td><button type="button" class="deleteBtn" value="${user.no }">삭제</button></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<script>
	$(".updateBtn").on("click", function(){
		location.href="/sample/updateForm?no=" + $(this).val();
	});
	
	$(".deleteBtn").on("click", function(){
		let no = $(this).val();
		location.href = "/sample/delete.do?no=" + no;
	});
</script>
</body>
</html>