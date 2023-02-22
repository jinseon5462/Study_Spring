<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<h1>검색</h1>
<hr>
<form action="#" method="post">
	<select id="sel">
		<option value="">카테고리선택</option>
		<option value="name">이름으로 검색</option>
		<option value="age">나이로 검색</option>
	</select>
	<input type="text" id="keyword" name="keyword" placeholder="키워드를 입력하세요">
	<input type="button" id="searchBtn" value="검색">
</form>
<table border="1">
	<thead>
		<tr>
		</tr>
	</thead>
	<tbody id="tbody">
	</tbody>
</table>
<script>
	$("#searchBtn").on("click", function(){
		let sel = $("#sel").val();
		let keyword = $("#keyword").val();
		//console.log("선택 : " + sel + "\n키워드 : " + keyword);
		const xhttp = new XMLHttpRequest();
		xhttp.onload = function(){
			let data = this.responsetText;
			let obj = JSON.parse(data);
			console.log(obj);
		}
		xhttp.open("post", "search.do", true);
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhttp.send("sel=" + sel + "&keyword=" + keyword);
	});
</script>
</body>
</html>