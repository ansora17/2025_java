<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>



<div class=" top-banner mb-3"></div>

<div class="container ">


	<form action="write" method="post">

		<div class="row mb-3 px-3" style="gap: 11px;">
			<label for="name"
				class="col-2 col-form-label text-center bg-primary rounded-3 text-white">작성자</label>
			<input type="text" id="name" class="col form-control" name="writer" onblur="searchByTitle()" />
		</div>
		<div class="row mb-3 px-3" style="gap: 11px;">
			<label for="title"
				class="col-2 col-form-label text-center bg-primary rounded-3 text-white">타이틀</label>
			<input type="text" id="title" class="col form-control" name="title" />
		</div>

		<div class="row mb-3 px-3" style="gap: 11px;">
			<label for="title"
				class="col-2 col-form-label text-center bg-primary rounded-3 text-white">이미지</label>
			<input type="text" id="imgUrl" class="col form-control" name="imageUrl" />
		</div>


		<div class="row mb-3 px-3 align-items-center">
			<label for="content"
				class="col-2 col-form-label text-center bg-primary rounded-3 text-white ">여행지</label>

			<div class="col">
				<input type="text" id="content" class="form-control" name="addr" />
			</div>

			<div class="col-auto">
				<button class="btn btn-primary" type="button"
					onclick="keyBtn('제주도')">추천여행지</button>
			</div>
		</div>

		<div class="row mb-3 px-3 ">
			<label for="body"
				class="col-2 col-form-label d-flex justify-content-center bg-primary rounded-3 text-white align-items-center"
				style="height: 130px;">내용</label>
			<div class="col">
				<textarea class="form-control" id="body" name="body" rows="5"
					placeholder="여행지에 대한 자세한 내용을 입력하세요"></textarea>
			</div>
		</div>

		<!-- API 자동입력 버튼 -->
		<div class="mb-4 d-flex justify-content-end">
			<button type="button" class="btn btn-outline-primary"
				onclick="fillTourData(126508)">📥 API 자동입력</button>
		</div>

		<div class="d-flex justify-content-end">
			<input type="submit" value="작성하기" class="btn btn-primary" />
		</div>

	</form>

</div>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="script/write.js"></script>