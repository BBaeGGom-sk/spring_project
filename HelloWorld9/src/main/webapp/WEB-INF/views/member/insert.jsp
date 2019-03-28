<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원등록</h1>
	<form action="/member/insert" method="post">
	ID : <input name="id" type="number"><br>
	name : <input name="name"><br>
	age : <input name="age" type="number"><br>
	<input type="submit" value="등록">
	<input type="reset" value="초기화">
	
	</form>
	
</body>
</html>