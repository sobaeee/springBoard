<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- JSP include -->
<%-- <%@ include file="../includes/header.jsp" %> --%>
<!-- JSP 액션태그 include -->
<jsp:include page="../includes/header.jsp"></jsp:include>

<div class="col-md-12">
	<h4 class="m-b-lg">Board Read Page</h4>
</div>
<!-- END column -->


<div class="col-md-12">
	<div class="widget p-lg">
		<h4 class="m-b-lg">Board Read Page</h4>
		<p class="m-b-lg docs">
			<!-- Add <code>.table-hover</code> to enable a hover state on table rows within a <code>&lt;tbody&gt;</code>. -->
		</p>

		<div class="panel-body">
			<form method="post" action="" id="frm">
				<!-- post방식으로 하려면 id를 일단 줘야함 -->
				<!-- 많은 내용을 보낼때면 post방식으로 -->
				<!-- 같은 페이지로 가기 때문에 register = 빈값 = /board/register 셋 중에 아무거나 해도 괜찮다. -->
				<input type="hidden" name="bno" id="bno" value="${board.bno}">
				<div class="form-group">
					<label>제목</label><input type="text" name="title" id="title"
						class="form-control" value="${board.title}" required="required">
				</div>
				<div class="form-group">
					<label>내용</label>
					<textarea name="content" id="content" class="form-control"
						style="resize: none;" required="required">${board.content}</textarea>
					<!-- textarea 크기 고정 => style="resize:none;" 추가 -->
				</div>
				<div class="form-group">
					<label>작성자</label><input type="text" name="writer" id="writer"
						class="form-control" value="${board.writer}" required="required">
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">글수정</button>
					<button type="button" id="btn_del" class="btn btn-primary">삭제</button>
				</div>
			</form>
		</div>
	</div>
	<!-- .widget -->
</div>
<!-- END column -->

<script>
$(document).ready(function(){
	$("#btn_del").on("click",function(){
		if(confirm("정말로 삭제하시겠습니까")){
			//get 방식 : location.href='remove?bno=${board.bno}';	
			//post 방식
			$("#frm").attr("action", "remove"); //"/board/remove" or remove
			$("#frm").submit();
		
		console.log("삭제버튼"+res);
		}
	});
	
});
</script>

<!-- JSP 액션태그 include -->
<jsp:include page="../includes/footer.jsp"></jsp:include>
<!-- JSP include -->
<%-- <%@ include file="../includes/footer.jsp" %> --%>



