<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<link rel="stylesheet" href="css/style.css" media="all" />

<%@include file="../include/header.jsp"%>
<body class="themeTour">
	<div class="themeTour container">

		<div class="themeMenu d-flex gap-1 justify-content-between ">
			<div>
				<ul class="d-flex fw-bold gap-3  justify-content-center ">
					<li><a href="#" class="link-btn nav-link"
						onclick="keyBtn('고기')"
						style="padding: 10px 20px; border-radius: 20px; color: #00376f;">고기</a></li>
					<li><a href="#" class="link-btn nav-link"
						onclick="keyBtn('수산')"
						style="padding: 10px 20px; border-radius: 20px; color: #00376f;">수산</a></li>
					<li><a href="#" class="link-btn nav-link"
						onclick="keyBtn('한정식')"
						style="padding: 10px 20px; border-radius: 20px; color: #00376f;">한정식</a></li>
					<li><a href="#" class="link-btn nav-link"
						onclick="keyBtn('카페')"
						style="padding: 10px 20px; border-radius: 20px; color: #00376f;">카페</a></li>
					<li><a href="#" class="link-btn nav-link"
						onclick="keyBtn('포차')"
						style="padding: 10px 20px; border-radius: 20px; color: #00376f;">포차</a></li>
				</ul>
			</div>
			<div class="d-flex gap-1 align-items-center">
				<input type="text" class="form-control inp "
					placeholder="키워드를 검색하세요!" />
				<div class="btn searchBtn fw-bold  "
					style="width: 70px; color: #00376f;">검색</div>
			</div>
		</div>
		<div class="searchInfo d-flex mt-5 mb-2">
			검색 정보 :&nbsp; <span class="total"></span>개
		</div>
		<div class="row tourList mb-3"></div>
	</div>

	<div class="pagination d-flex justify-content-center  mt-4">
		<div class="d-flex gap-2 align-items-center">
			<div class="prev fw-bold btn">Previous</div>

			<div class="page-item d-flex gap-3"></div>

			<div class="next fw-bold btn">next</div>
		</div>
	</div>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.8.4/axios.min.js"
		integrity="sha512-2A1+/TAny5loNGk3RBbk11FwoKXYOMfAK6R7r4CpQH7Luz4pezqEGcfphoNzB7SM4dixUoJsKkBsB6kg+dNE2g=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>

	<script src="script/diner.js"></script>
</body>

