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
	<h1>회원정보 자세히 보기</h1>

<table>
	<thead>
		<tr>
			<th>
				ID
			</th>
			<th>
				name
			</th>
			<th>
				age
			</th>
			<th>
				등록일
			</th>
		</tr>
	</thead>
	<tbody>
			<tr>
				<td>
					${dto.id }
				</td>
				<td>
					${dto.name }
				</td>
				<td>
					${dto.age }
				</td>
				<td>
					${dto.regdate }
				</td>
			</tr>
	</tbody>
</table>

<a href="/member/updateui?id=${dto.id }">수정</a>
<a href="/member/delete?id=${dto.id }">삭제</a>
<a href="/member/select">목록</a>


</body>
</html>