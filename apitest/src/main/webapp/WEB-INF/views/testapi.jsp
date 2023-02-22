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
	<h1>Test API</h1>
	<hr>
	<div class="container">
		<p>C : 등록</p>
		<table border="1">
			<tr>
				<th>이름</th>
				<th>나이</th>
				<th>실행</th>
			</tr>
			<tr>
				<td><input type="text" name="cname"></td>
				<td><input type="text" name="cage"><br></td>
				<td><input type="button" value="등록" onclick="regUser()"></td>
			</tr>
			<tr>
				<td colspan="3" id="reg_result">등록성공여부</td>
			</tr>
		</table>
		<hr>
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
		<p>U : 수정</p>
		<table border="1">
			<tr>
				<th>수정할 회원이름</th>
				<th>이름</th>
				<th>나이</th>
				<th>실행</th>
			</tr>
			<tr>
				<td><input type="text" name="mod_name"></td>
				<td><input type="text" name="mname"></td>
				<td><input type="text" name="mage"><br></td>
				<td><input type="button" value="수정" onclick="modifyUser()"></td>
			</tr>
			<tr>
				<td colspan="4" id="modify_result">수정성공여부</td>
			</tr>
		</table>
		<hr>
		<p>D : 삭제</p>
		<table border="1">
			<tr>
				<th>삭제할 회원이름</th>
				<th>실행</th>
			</tr>
			<tr>
				<td><input type="text" name="del_name"></td>
				<td><input type="button" value="삭제" onclick="deleteUser()"></td>
			</tr>
			<tr>
				<td colspan="2" id="delete_result" >삭제성공여부</td>
			</tr>
		</table>
	</div>
	<script>
//등록
		function regUser() {
			alert("regUser...");
			const user_name = document.querySelector("input[name='cname']").value;
			const user_age = document.querySelector("input[name='cage']").value;
			const obj_user = {
					name : user_name,
					age : user_age
				}
			const json_user = JSON.stringify(obj_user);
			alert(json_user);
			
			const xhttp = new XMLHttpRequest();
			xhttp.onload = function() {
				document.getElementById("reg_result").innerHTML = this.responseText;
			}
			xhttp.open("POST", "/api/post-api/user/", true);
			xhttp.setRequestHeader("Content-type", "application/json");
			xhttp.send(json_user);
		}
//조회
		function readUser() {
			const read_name = document.querySelector("input[name='read_name']").value;
			//alert(read_name);
			const xhttp = new XMLHttpRequest();
			xhttp.onload = function() {
				document.getElementById("read_result").innerHTML = this.responseText;
			}
			//@RequestMapping("/api/get-api/")
			//@GetMapping("/user/{name}")
			//http://localhost:9001/api/get-api/user/cucu
			xhttp.open("GET", "/api/get-api/user/" + read_name, true);
			xhttp.send();
		}
//수정
		function modifyUser() {
			alert("modifyUser...");
			const mod_name = document.querySelector("input[name='mod_name']").value;
			const user_name = document.querySelector("input[name='mname']").value;
			const user_age = document.querySelector("input[name='mage']").value;
			const obj_user = {
					name : user_name,
					age : user_age
				}
			const json_user = JSON.stringify(obj_user);
			alert(json_user);
			
			const xhttp = new XMLHttpRequest();
			xhttp.onload = function() {
				document.getElementById("modify_result").innerHTML = this.responseText;
			}
			xhttp.open("PUT", "/api/put-api/user/"+ mod_name, true);
			xhttp.setRequestHeader("Content-type", "application/json");
			xhttp.send(json_user);
		}
		
//삭제
		function deleteUser() {
			alert("delete.....");
			const name = document.querySelector("input[name='del_name']").value;
			alert("name : " + name); 
			const xhttp = new XMLHttpRequest();
			xhttp.onload = function() {
				document.getElementById("delete_result").innerHTML = this.responseText;
			}
			xhttp.open("DELETE", "/api/delete-api/user/" + name, true);
			xhttp.send();
		}
		
	</script>
</body>
</html>