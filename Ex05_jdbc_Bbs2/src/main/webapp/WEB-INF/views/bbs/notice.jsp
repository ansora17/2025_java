<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@include file="../include/header.jsp" %>
	
	
	<div class="container">
		<div class = "d-flex">
		<h3 class ="fw-bold ms-4 mb-5" style="font-size: 70px; padding : 50px 0 0 0  ">언론보도</h3>
		</div>
		<table class="table ">
			<tr>
				<th>번호</th>
				<th></th>
			
			</tr>
			<c:forEach items="${lists}" var="dto" varStatus="loop">
				<tr >
					<td style= "padding : 10px 0 10px 20px;">${totalCount - ((currentPage-1)*size + loop.index) }</td>
					<td style= "padding : 10px 0 10px 20px;"><a href="/view?id=${dto.id}" class="nav-link ms-2" style="text-decoration: none ; ">${dto.title }</a></td>
					
					<td><a href="/delete?id=${dto.id}"  class="btn btn-primary nav-link" style="text-decoration: none;">삭제</a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="d-flex justify-content-center">
			<ul class="pagination">
				<li class="page-item"><a class="page-link">Previous</a></li>
			<c:forEach begin="1" end="${totalPages }" var="page" >
                <li class="page-item ${page == currentPage ? 'active':''}" >
                <a class="page-link" href="list?page=${page}&size=${size}">${page}</a></li>
                </c:forEach>
                <c:if test="${currentPage < totalPages}">
				<li class="page-item"><a class="page-link" href="list?page=${currentPage + 1}&size=${size}">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div  class="d-flex justify-content-end">
			<a href="/writeForm" class="btn btn-primary">글작성</a>
		</div>
	</div>
	
	<%@ include file="../include/footer.jsp"%>