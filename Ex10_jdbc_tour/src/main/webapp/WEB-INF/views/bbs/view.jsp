<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<div class="container mt-5">
  <h3 class="mb-4 fw-bold">📄 글 상세보기</h3>
  <hr />

  <div class="mb-3">
    <p><strong>작성자:</strong> ${dto.writer}</p>
    <p><strong>제목:</strong> ${dto.title}</p>
    <p><strong>여행지 주소:</strong> ${dto.location}</p>
    <p><strong>내용:</strong></p>
    <div class="border rounded p-3 bg-light">${dto.content}</div>
  </div>

  <c:if test="${not empty dto.imageUrl}">
    <div class="mb-4">
      <p><strong>관련 이미지:</strong></p>
      <img src="${dto.imageUrl}" class="img-fluid rounded shadow" style="max-width: 400px;" />
    </div>
  </c:if>

  <div class="d-flex justify-content-between">
    <a href="list" class="btn btn-secondary">🔙 리스트로</a>
    <!-- 💡 옵션: 수정/삭제 버튼도 가능 -->
    <!-- <a href="edit?id=${dto.id}" class="btn btn-outline-primary">수정</a> -->
  </div>
</div>
