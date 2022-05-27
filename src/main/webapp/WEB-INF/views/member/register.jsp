<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- JSP include -->
<%-- <%@ include file="../includes/header.jsp" %> --%>
<!-- JSP 액션태그 include -->
<jsp:include page="../includes/header.jsp"></jsp:include>

<div class="col-md-12">
	<h4 class="m-b-lg">Member Register</h4>
</div>
<!-- END column -->


<div class="col-md-12">
	<div class="widget p-lg">
		<h4 class="m-b-lg">Member Register</h4>
		<p class="m-b-lg docs">
			<!-- Add <code>.table-hover</code> to enable a hover state on table rows within a <code>&lt;tbody&gt;</code>. -->
		</p>
		
		<div class="panel-body">
			<form method="post" action="register">
			<!-- 많은 내용을 보낼때면 post방식으로 --> <!-- 같은 페이지로 가기 때문에 register = 빈값 = /board/register 셋 중에 아무거나 해도 괜찮다. -->
			<div class="form-group">
					<label>회원명</label><input type="text" name="uname" id="uname" class="form-control" value="" required="required">
				</div>
				<div class="form-group">
					<label>학교명</label><input name="schoolname" id="schoolname" class="form-control" required="required">
					<!-- textarea 크기 고정 => style="resize:none;" 추가 -->
				</div>
				<div class="form-group">
					<label>학년반</label><input type="text" name="gradeclass" id="gradeclass" class="form-control" value="" required="required">
				</div>
				<div class="form-group">
					<label>전화번호</label><input type="text" name="uid" id="uid" class="form-control" value="" required="required">
				</div>
				<div class="form-group">
					<label>비밀번호</label><input type="password" name="upw" id="upw" class="form-control" value="" required="required">
				</div>
				<div class="form-group">
					<label>노선</label><input type="text" name="route" id="route" class="form-control" value="" required="required">
				</div>
				<div class="form-group">
					<label>탑승장소</label><input type="text" name="boardingplace" id="boardingplace" class="form-control" value="" required="required">
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">회원등록</button>
					<button type="button" onclick="history.go(-1);" class="btn btn-primary">취소</button>
				</div>
			</form>
		</div>
	</div>
	<!-- .widget -->
</div>
<!-- END column -->


<!-- JSP 액션태그 include -->
<jsp:include page="../includes/footer.jsp"></jsp:include>
<!-- JSP include -->
<%-- <%@ include file="../includes/footer.jsp" %> --%>



