<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Buy Ticket</h1>
<hr>
<p>카드결제</p>

<form action="buy_ticket_card">
	고객 아이디 : <input type="text" name="consumerId"><br>
	티켓 구매수 : <input type="text" name="amount"><br>
	에러 발생 여부 : <input type="text" name="error" value="0"><br>
	<input type="submit" value="전송">
</form>
<hr>
에러 발생 여부에 1을 입력하면 에러가 발생합니다.
</body>
</html>