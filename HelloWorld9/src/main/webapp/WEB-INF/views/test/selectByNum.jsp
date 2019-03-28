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
	<h1>회원정보 자세히 보기</h1>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>게시글</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${dto.num }</td>
				<td>${dto.tname }</td>
				<td>${dto.tday }</td>
			</tr>
		</tbody>

	</table><br>
	<a href="/test/updateui?num=${dto.num }">수정</a>
	<a href="/test/delete?num=${dto.num }">삭제</a>
	<a href="/test/list">목록</a>
</body>
</html>