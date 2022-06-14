<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- JSP include -->
<%-- <%@ include file="../includes/header.jsp" %> --%>
<!-- JSP 액션태그 include -->
<jsp:include page="../includes/header.jsp"></jsp:include>

<div class="col-md-12">
	<h4 class="m-b-lg">Board Register</h4>
</div>
<!-- END column -->


<div class="col-md-12">
	<div class="widget p-lg">
		<h4 class="m-b-lg">Board Register</h4>
		<p class="m-b-lg docs">
			<!-- Add <code>.table-hover</code> to enable a hover state on table rows within a <code>&lt;tbody&gt;</code>. -->
		</p>

		<div class="panel-body">
			<form method="post" action="register" enctype="multipart/form-data">
				<!-- 많은 내용을 보낼때면 post방식으로 -->
				<!-- 같은 페이지로 가기 때문에 register = 빈값 = /board/register 셋 중에 아무거나 해도 괜찮다. -->
				<div class="form-group">
					<label>제목</label><input type="text" name="title" id="title"
						class="form-control" value="" required="required">
				</div>
				<div class="form-group">
					<label>내용</label>
					<textarea name="content" id="content" class="form-control"
						style="resize: none;" required="required"></textarea>
					<!-- textarea 크기 고정 => style="resize:none;" 추가 -->
				</div>
				<div class="form-group">
					<label>첨부파일</label><input type="file" name="upfile" id="upfile"
						multiple="multiple" class="form-control" value=""
						required="required">
				</div>
				<div class="form-group">
					<label>작성자</label><input type="text" name="writer" id="writer"
						class="form-control" value="" required="required">
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary" id="upbtn">글쓰기</button>
					<button type="button" class="btn btn-primary" onclick="location.href='list'">취소</button>
				</div>
			</form>
		</div>
	</div>
	<!-- .widget -->
</div>
<!-- END column -->

<script>
	$(document).ready(function() {
		$("#upbtn").click(function() {
			if($.trim($("#title").val() == '')) {
				alert('이름은 필수 입력입니다.');
				//$("title").val('');
				$("#title").focus();
				return false;
			}
		});
	});
</script>

<!-- JSP 액션태그 include -->
<jsp:include page="../includes/footer.jsp"></jsp:include>
<!-- JSP include -->
<%-- <%@ include file="../includes/footer.jsp" %> --%>



