<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../resources/js/test.js"></script>
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<a class="btn btn-info" href="/board/insertui">글쓰기</a>
		</div>
		<div class="row">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${list }" var="vo">
						<tr>
							<td>${vo.bno }</td>
							<td><a
								href="/board/selectbybno${pm.makeQuery(pm.cri.page)}&bno=${vo.bno}">${vo.title }</a></td>
							<td>${vo.writer }</td>
							<td>${vo.updateDate }</td>
							<td>${vo.viewCnt }</td>
						</tr>
					</c:forEach>
				</tbody>


			</table>
		</div><!-- class row -->

		<div class="row text-center">
			<ul class="pagination">
				<c:if test="${pm.cri.page>1}">
					<li><a href="/board/list${pm.makeQuery(pm.cri.page-1) }">&laquo;</a></li>
				</c:if>
				<c:forEach begin="${pm.beginPageNum }" end="${pm.stopPageNum }" var="idx">
					<li class="${pm.cri.page==idx?'active':'' }"><a
						href="/board/list${pm.makeQuery(idx)}">${idx }</a></li>
				</c:forEach>
				<c:if test="${pm.cri.page < pm.totalpage}">
					<li><a href="/board/list${pm.makeQuery(pm.cri.page+1) }">&raquo;</a></li>
				</c:if>
			</ul>


		</div>
		
		<form action="/board/search" method="get" target="_blank"> <!-- 타겟 블랭크는 새창이 열림 ?-->
		<div class="row">
			<div class="col-xs-3 col-sm-2">
				<select id="ssel" name="searchType" class="form-control">
					<option disabled="disabled">검색기준</option>
					<option value="title">제목</option>
					<option value="writer">작성자</option>
					<option value="content">내용</option>
				</select>
			</div>
			<div class="input-group col-xs-9 col-sm-10">
				<input name="keyword" id="keyword" class="form-control">
				<span class="input-group-btn">
					<button class="btn btn-success" id="searchBtn">검색</button>
				</span>
			</div>
		</div>
		</form>
		
	</div><!-- class container -->
	<script type="text/javascript">
		$(document).ready(function() {
			test();
			
			$("#searchBtn").click(function() {
				$("form").submit();
			});
		});

	</script>
</body>
</html>