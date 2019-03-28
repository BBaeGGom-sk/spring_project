<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보 수정</h1>

	<form action="/member/update" method="post">
		ID : <input name="id" readonly="readonly" value="${dto.id }"><br>
		name : <input name="name" value="${dto.name }"><br>
		age : <input name="age" value="${dto.age }" type="number"><br>
		<input type="submit" value="수정">
		
	</form>
</body>
</html>