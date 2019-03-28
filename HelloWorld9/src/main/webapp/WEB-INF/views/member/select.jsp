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
	<a href="/member/insertui">회원등록</a>
<table>
	<thead>
		<tr>
			<th>
				ID
			</th>
			<th>
				name
			</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>
					${dto.id }
				</td>
				<td>
					<a href="/member/selectbyid?id=${dto.id }">${dto.name }</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>