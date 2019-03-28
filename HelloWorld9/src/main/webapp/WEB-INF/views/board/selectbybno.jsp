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
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<title>Insert title here</title>
</head>
<body>

<div class="container">
	<div class="row">
		<div class="form-group">
			<label for="bno">글번호</label>
			<input class="form-control" name="bno" id="bno" value="${vo.bno }" readonly="readonly">
		</div>
	
		<div class="form-group">
			<label for="title">제목</label>
			<input class="form-control" name="title" id="title" value="${vo.title }" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="writer">작성자</label>
			<input class="form-control" name="writer" id="writer" value="${vo.writer }" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="content">내용</label>
			<textarea class="form-control" name="content" id="content" rows="3" readonly="readonly">${vo.content }</textarea>
		</div>
		
		<div class="form-group">
		<button class="btn btn-warning" id="updateBtn">수정</button>
		<button class="btn btn-danger" id="deleteBtn">삭제</button>
		<button class="btn btn-info" id="listBtn">목록</button>
		<button class="btn btn-primary" id="reply" >댓글</button>
		</div>
	</div>
	
	<div class="row">
		<div class="collapse" id="myCollapsible">
			<div class="form-group">
				<label for="replyer">작성자</label>
				<input id="replyer" class="form-control">
			</div>
			
			<div class="form-group">
				<label for="replyText">내용</label>
				<textarea rows="3" id="replyText" class="form-control"></textarea>
			</div>
			
			<div class="form-group">
				<button id="replyInsertBtn" class="btn btn-success">등록</button>
				<button id="replyResetBtn" class="btn btn-default">초기화</button>
			</div>
			
		</div>
	</div>
	
	<div class="row" id="replies">
		
	</div>
	
	<div class="row"> <!-- 모달 창 -->
		<div class="modal fade" id="myModal">
			<div class="modal-dialog">
				<div class="modal-header">
					<button data-dismiss="modal" class="close">&times;</button>
					<p id="modal_rno"></p>	
				</div>
				<div class="modal-body">
					<input class="form-control" id="modal-replyText">
				</div>
				<div class="modal-footer">
					<button id="modal_update" data-dismiss="modal" class="btn btn-xs">수정</button>
					<button id="modal_delete" data-dismiss="modal" class="btn btn-xs">삭제</button>
					<button id="modal_close" data-dismiss="modal" class="btn btn-xs">닫기</button>
				</div>
			</div>
		</div>
	</div>
	
</div><!-- class가 container인 div태그 -->

	<!-- 나중을 위해 폼태그로 정리함 -->
<form>
	<input type="hidden" name="bno" value="${vo.bno }">
	<input type="hidden" name="page" value="${cri.page }">
	<input type="hidden" name="perpage" value="${cri.perpage }">
	
</form>

<script id="source" type="text/x-handlebars-template">
{{#each.}}
	<div class="panel panel-info">

		<div class="panel-heading">
			<span>rno: {{rno}}, 작성자: {{replyer}}</span>
			<span class="pull-right">{{updatedate}}</span>
		</div>

		<div class="panel-body">
			<p>{{replyText}}</p>
			<button class="callModal btn btn-xm btn-success" data-rno="{{rno}}" data-replyText="{{replyText}}">수정/삭제</button>
		</div>

	</div>
{{/each}}
</script>


<script type="text/javascript">


	$(document).ready(function() {
		
		$("#replies").on("click",".callModal",function() {
			
			var rno = $(this).attr("data-rno");
			var replyText = $(this).attr("data-replyText");
			
			$("#modal_rno").text(rno);
			$("#modal-replyText").val(replyText);
			
			$("#myModal").modal("show");
		});
		
		var bno = ${vo.bno};
		
		$("#reply").click(function() {
			$("#myCollapsible").collapse("toggle");
		});
		
		$("#replyInsertBtn").click(function() {
			var replyer=$("#replyer").val();
			var replyText=$("#replyText").val();
			
			// 아래는 ajax로 통신하는것
			$.ajax({ // 들어가는 속성은 암기할것 !! 순서는 상관없음
				type: 'post',
				url: '/replies',
				headers: {
					"Content-Type":"application/json",
					"X-HTTP-Method-Override":"POST"
				},
				data: JSON.stringify({
					replyer:replyer,
					replyText:replyText,
					bno:bno
				}),
				dataType: "text",
				success: function(result) {
					$("#replyer").val("");
					$("#replyText").val("");
					$("#myCollapsible").collapse("hide");
					getList(bno);
				},
				error: function(request,status,error) {
					alert("code:"+request.status+"\n"+"msg:"+request.responseText+"\n"+"error:"+error);
				},
				complete: function() {
				}
			});
			
		});
		
		$("#replyResetBtn").click(function() {
			$("#replyer").val("");
			$("#replyText").val("");
		});
		
		$("#updateBtn").click(function() {
			$("form").attr("action", "update");
			$("form").attr("method", "get");
			$("form").submit();
		});
		
		$("#deleteBtn").click(function() {
			$("form").attr("action", "delete").attr("method", "get").submit();
		});
		
		$("#listBtn").click(function() {
			//location.href="/board/list?page=${pm.cri.page}&perpage=${pm.cri.perpage}";
			$("form").attr("action", "list");
			$("form").attr("method", "get");
			$("form").submit();
		});
		
		getList(bno);
	});

	function getList(bno) {
		$.getJSON("/replies/"+bno,function(data) {

			var source = $("#source").html();
			var template = Handlebars.compile(source);
			
			$("#replies").html(template(data));
			
			
		});
		
		$("#modal_update").click(function() {
			
			var rno = $("#modal_rno").text();
			var replyText = $("#modal-replyText").val();

			// 아래는 ajax로 통신하는것
			$.ajax({ // 들어가는 속성은 암기할것 !! 순서는 상관없음
				type: 'put',
				url: '/replies/'+rno,
				headers: {
					"Content-Type":"application/json",
					"X-HTTP-Method-Override":"PUT"
				},
				data: JSON.stringify({
					replyText:replyText
				}),
				dataType: "text",
				success: function(result) {
					getList(bno);
				},
				error: function(request,status,error) {
					alert("code:"+request.status+"\n"+"msg:"+request.responseText+"\n"+"error:"+error);
				},
				complete: function() {
				}
			})
			
		})
		
		$("#modal_delete").click(function() {
			
			var rno = $("#modal_rno").text();

			// 아래는 ajax로 통신하는것
			$.ajax({ // 들어가는 속성은 암기할것 !! 순서는 상관없음
				type: 'delete',
				url: '/replies/'+rno,
				headers: {
					"Content-Type":"application/json",
					"X-HTTP-Method-Override":"DELETE"
				},
				data: JSON.stringify({
					rno:rno
				}),
				dataType: "text",
				success: function(result) {
					getList(bno);
				},
				error: function(request,status,error) {
					alert("code:"+request.status+"\n"+"msg:"+request.responseText+"\n"+"error:"+error);
				},
				complete: function() {
				}
			})
			
		})
	};
</script>

</body>
</html>