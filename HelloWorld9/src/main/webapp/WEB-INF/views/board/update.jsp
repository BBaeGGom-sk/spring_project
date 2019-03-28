<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<div class="container">
	<div class="row">
		<form action="/board/update" method="post">
		<div class="form-group">
			<label for="bno">글번호</label>
			<input class="form-control" name="bno" id="bno" value="${vo.bno }" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="title">제목</label>
			<input class="form-control" name="title" id="title" value="${vo.title }">
		</div>
		<div class="form-group">
			<label for="writer">작성자</label>
			<input class="form-control" name="writer" id="writer" value="${vo.writer }">
		</div>
		<div class="form-group">
			<label for="content">내용</label>
			<textarea class="form-control" name="content" id="content" rows="3">${vo.content }</textarea>
		</div>
		
		<div class="form-group">
		<button class="btn btn-warning" id="updateBtn">수정</button>
		<button class="btn btn-info" id="listBtn">목록</button>
		</div>
		
		<input type="hidden" name="bno" value="${vo.bno }">
		<input type="hidden" name="page" value="${cri.page }">
		<input type="hidden" name="perpage" value="${cri.perpage }">
		</form>
	</div>
</div>

<script type="text/javascript">

	$(document).ready(function() {
		
		$("#updateBtn").click({
			$("form").attr("action", "update");
			$("form").attr("method", "post");
			$("form").submit();
		});
		
		$("#listBtn").click({
			//location.href="/board/list";
			$("form").attr("action", "list");
			$("form").attr("method", "get");
			$("form").submit();
		});
	});
	
</script>

</body>
</html>