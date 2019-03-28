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
	<a href="/tt/insertui">회원 등록</a><br>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>AGE</th>
				</tr>
			</thead>
			<tbody>
	<c:forEach var="list" items="${list}">
				<tr>
					<td>${list.id }</td>
					<td><a href="/tt/selectbyid?id=${list.id }">${list.name }</a></td>
					<td>${list.age }</td>
				</tr>
	</c:forEach>
			</tbody>

		</table>
</body>
</html>