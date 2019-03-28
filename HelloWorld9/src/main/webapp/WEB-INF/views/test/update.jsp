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
<h1>회원 정보 수정</h1>
<form action="/test/update" method="post">
NUM : <input name="num" readonly="readonly" type="number" value="${dto.num }"><br>
TNAME : <input name="tname" required="required" value="${dto.tname }"><br>
<input type="submit" value="수정">
</form>
</body>
</html>