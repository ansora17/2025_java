<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="include/header.jsp"%>


<!-- 슬릭슬라이더 구현부분 -->
<div class="container" style="">


	<div class="mt-4" style="padding: 0 0 0 0px">
		<div class="slider-div">
			<div>
				<img src="images/slider_1.png" alt="" />
			</div>
			<div>
				<img src="images/slider_6.jpg" alt="" />
			</div>
			<div>
				<img src="images/slider_7.jpg" alt="" />
			</div>
			<div>
				<img src="images/slider_10.jpeg" alt="" />
			</div>
			<div>
				<img src="images/slider_9.jpg" alt="" />
			</div>

		</div>


		<div class="container">
			<div class=" row">
				<div class=" col-md-6">
					<div class="totalList mt-4 mb-5">
						<div class="mb-3">
							<span class="fw-bold" style="font-size: 25px;">언론보도</span> <a
								class="" href="list"
								style="text-decoration: none; font-size: 35px;">+</a>
						</div>
						<ul class="leftline">
							<c:forEach items="${report}" var="dto" varStatus="">
								<li class="leftInline mt-3 ">
									<div>
										<a href="/view?id=${dto.id}" class="nav-link fw-bold mb-2">${dto.title }</a>
									</div>
									<div class="mb-3 gap-3">${dto.formattedDate }
										<a href="" class="" style="padding: 10px;">${dto.broad}</a><a
											style="color: red;" href="">${ dto.asso }</a>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>

				<div class="col-md-6">
					<div class="totalList mt-4 mb-5 ms-md-0">
						<div class="mb-3">
							<span class="fw-bold" style="font-size: 25px;">공지사항</span> <a
								class="" href="notice"
								style="text-decoration: none; font-size: 35px;">+</a>
						</div>
						<ul class="leftline">
							<c:forEach items="${notice}" var="dto" varStatus="">
								<li class="leftInline mt-3 ">
									<div>
										<a href="/view?id=${dto.id}" class="nav-link fw-bold mb-2">${dto.title }</a>
									</div>
									<div class="mb-3 gap-3">${dto.formattedDate }
										<a style="color: red;" href="">${ dto.asso }</a>
									</div>
								</li>
							</c:forEach>
						</ul>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>








<%@ include file="include/footer.jsp"%>