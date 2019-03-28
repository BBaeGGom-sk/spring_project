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
<h1>회원 정보 자세히 보기</h1>
ID : ${dto.id}<br>
NAME : ${dto.name }<br>
AGE : ${dto.age }<br>
<a href="/tt/updateui?id=${dto.id }">수정</a>
<a href="/tt/delete?id=${dto.id }">삭제</a>
<a href="/tt/list">목록</a>
</body>
</html>