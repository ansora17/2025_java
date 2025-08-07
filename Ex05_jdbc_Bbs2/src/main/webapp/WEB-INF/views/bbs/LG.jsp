<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<%@include file="../include/header.jsp" %>


<div class="container" >
<div class="text-end mb-4 mt-5 ">
<a href="/" class="fw-bold " style="color:gray; font-size: 13px;" >LG재단</a><a  class ="fw-bold me-4 " href="" style="color:gray; font-size: 13px;""> > 재단소개</a>
</div>
<h4 class ="fw-bold ms-4 mb-5" style="font-size: 50px; ">${title }</h4>

</div>

<div class="d-flex justify-content-center mt-5 mb-5  " style="background-color: #F0F4F6; padding : 50px 0">
<img  src="images/lg-history.png" style="max-width: 60%; height: auto;" alt="" />
</div>


<div class="container">
	<!-- <div class="row">
		<img src="images/slider_1.png" alt="" />
	</div>  -->
<div class="totalList mt-4">
<div class="mb-3">
<span class="fw-bold" style="font-size: 25px;">언론보도</span>
<a class="" href="list" style=" text-decoration: none; font-size: 35px;">+</a>
</div>
	<ul class="leftline">
		<c:forEach items="${report}" var="dto" varStatus="">
			<li class="leftInline mt-3 ">
				<div>
					<a href="/view?id=${dto.id}" class="nav-link fw-bold mb-2">${dto.title }</a>
				</div>
					<div class="mb-3 gap-3">${dto.formattedDate } <a href="" class="" style="padding: 10px;">${dto.broad}</a><a style="color:red;" href="">${ dto.asso }</a></div> 
			</li>
		</c:forEach>
	</ul>

</div>
</div>

<%@ include file="../include/footer.jsp"%>
