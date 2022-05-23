<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSP include -->
<!-- 수정하기 -->

<%-- <%@ include file="../includes/header.jsp"%> --%>
<!-- header와 footer를 나눈 것을 하나로 합쳐주는 방법. -->
<!-- 이곳에 대입을 하면 header 파일의 title에 값이 전송 된다. header에는 i가 빨갛지만 컴파일을 해서 값이 뜬다. -->

<!-- JSP 액션태그 include -->
<%-- <% int i = 10; %> --%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<%-- <jsp:param value="1234" name="head"/> --%>
<!-- 액션태그에 값을 넣으면 아래 tables 옆에 값을 띄울 수 있다. -->

<div class="col-md-12">
	<h4 class="m-b-lg">Tables</h4>
</div>
<!-- END column -->

<div class="col-md-12">
	<div class="widget p-lg">
		<h4 class="m-b-lg">Board List Page</h4>
		<!-- <p class="m-b-lg docs">
			Add
			<code>.table-hover</code>
			to enable a hover state on table rows within a
			<code>&lt;tbody&gt;</code>
			.
		</p> -->

		<table class="table table-hover">
			<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>수정일</th>
			</tr>
			</thead>
			<tr>
				<td>1</td>
				<td>Mark</td>
				<td>Otto</td>
				<td>@mdo</td>
			</tr>
			<tr>
				<td>2</td>
				<td>Jacob</td>
				<td>Thornton</td>
				<td>@fat</td>
			</tr>
			<tr>
				<td>3</td>
				<td>Larry</td>
				<td>the Bird</td>
				<td>@twitter</td>
			</tr>
		</table>
	</div>
	<!-- .widget -->
</div>
<!-- END column -->
<!-- jsp include -->
<%-- <%@ include file="../includes/footer.jsp" %> --%>

<!-- jsp 액션태그 include -->
<jsp:include page="../includes/footer.jsp"></jsp:include>
