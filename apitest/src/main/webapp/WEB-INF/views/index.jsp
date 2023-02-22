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
<h1>Index Page</h1>
<hr>
hello!<br>
<hr>
<h1>회원등록</h1>
<form name="frm">
	<input type="text" name="name" id="name"><br>
	<input type="text" name="tel" id="tel"><br>
</form>
<button type="button" onclick="regist()">등록</button>
<hr>
<h1>회원수정</h1>
<form name="frm2">
	<input type="hidden" name="sno" id="sno">
	<input type="text" name="updateName" id="updateName"><br>
	<input type="text" name="updateTel" id="updateTel"><br>
</form>
<button type="button" id="updateDoBtn">수정</button>
<hr>
<table border="1">
	<thead>
		<tr>
			<th>이름</th><th>전화번호</th><th>수정</th><th>삭제</th>
		</tr>
	</thead>
	<tbody id="tbody">
		<!--  -->
	</tbody>
</table>

<p>R : 조회</p>
		<table border="1">
			<tr>
				<th>조회할 회원이름</th>
				<th>실행</th>
			</tr>
			<tr>
				<td><input type="text" name="read_name"></td>
				<td><input type="button" value="조회" onclick="readUser()"></td>
			</tr>
			<tr>
				<td colspan="2" id="read_result">조회성공여부</td>
			</tr>
		</table>
		<hr>
<script>
	getList();
	
	// 등록
	function regist(){
		const xhttp = new XMLHttpRequest();
		xhttp.onload = function(){
			let data = this.responseText;
			let result = parseInt(data, 10);
			if(result == 1){
				alert("등록 성공!");
				getList();
			}else{
				alert("등록 실패...");
			}
		}
		let name = document.querySelector("#name").value;
		let tel = document.querySelector("#tel").value;
		xhttp.open("post", "api/v1/post-api/member", true);
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhttp.send("name=" + name + "&tel=" + tel);
	}
	
	// 목록
	function getList(){
		const xhttp = new XMLHttpRequest();
		xhttp.onload = function(){
			let data = this.responseText;
			let obj = JSON.parse(data);
			let tbody = document.querySelector("#tbody");
			tbody.replaceChildren();
			for(let i = 0; i < obj.length; i++){
				tbody.innerHTML += "<tr>"
										+ "<td>" + obj[i].name + "</td>"
										+ "<td>" + obj[i].tel + "</td>"
										+ "<td>" + "<button type=button id='updateBtn' value=" + obj[i].sno + ">수정</button>" + "</td>"
										+ "<td>" + "<button type=button id='deleteBtn' value=" + obj[i].sno + ">삭제</button>" + "</td>"
									+"<tr>";
			}
		}
		xhttp.open("get", "api/v1/get-api/list", true);
		xhttp.send();
	}
	
	// 회원정보 가져오기
	$(document).on("click", "#updateBtn", function(e){
		const xhttp = new XMLHttpRequest();
		xhttp.onload = function(){
			let data = this.responseText;
			let obj = JSON.parse(data);
			$("#updateName").val(obj.name);
			$("#updateTel").val(obj.tel);
			$("#sno").val(obj.sno);
		}
		let sno = e.target.value;
		xhttp.open("post", "/api/v1/post-api/member2", true);
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhttp.send("sno=" + sno);
	});
	
	// 수정
	$(document).on("click", "#updateDoBtn", function(e){
		const xhttp = new XMLHttpRequest();
		xhttp.onload = function(){
			let data = this.responseText;
			if(data == "1"){
				alert("수정 성공");
				getList();
			}else{
				alert("수정 실패");
			}
		}
		let sno = $("#sno").val();
		let name = $("#updateName").val();
		let tel = $("#updateTel").val();
		
		//console.log("sno : " + sno + "\nname : " + name + "\ntel : " + tel);
		xhttp.open("put", "/api/v1/put-api/member/" + name, true);
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhttp.send("sno=" + sno + "&name=" + name + "&tel=" + tel);
	});
	
	// 삭제
	$(document).on("click", "#deleteBtn", function(e){
		const xhttp = new XMLHttpRequest();
		xhttp.onload = function(){
			let data = this.responseText;
			if(data == "1"){
				alert("삭제 성공");
				getList();
			}else{
				alert("삭제 실패");
			}
		}
		let sno = e.target.value;
		xhttp.open("delete", "/api/v1/delete-api/member?sno=" + sno, true);
		xhttp.send();
	});
	
</script>
</body>
</html>