<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@include file="../include/header.jsp"%>
<div class="container">
	<table class="text-center">
		<tr class="text-center">
			<th style="padding: 10px 0 10px 20px;">NO.</th>
			<th style="padding: 10px 0 10px 20px;">TITLE</th>
		</tr>
		<c:forEach items="${lists}" var="dto" varStatus="loop">
			<tr class="text-center">
				<td>${loop.index + 1}</td>
				<td><a href="view?id=${dto.id}" class="text-decoration-none">
						${dto.title} </a></td>
				<td><img src="${dto.imageUrl}" style="width: 200px;" /></td>
				<td><a href="/delete?id=${dto.id}"
					class="btn btn-primary nav-link" style="text-decoration: none;">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
	<div class="d-flex justify-content-end">
		<a href="/writeForm" class="btn btn-primary text-white">글작성</a>
	</div>

</div>

<%@ include file="../include/footer.jsp"%>
