<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <link rel="stylesheet" href="/webjars/bootstrap/5.3.3/css/bootstrap.css"
	media="all" />
<link rel="stylesheet" href="css/style.css" media="all" />
 
<div class="container">
	<div class="row text-center ">
		<div class="col d-none d-md-block"><img class=" w-50" src="images/lgf-01.png" alt="" /></div>
		<div class="col d-none d-md-block"><img class=" w-50" src="images/lgf-02.png" alt="" /></div>
		<div class="col"><img class=" w-50" src="images/lgf-03.jpg" alt="" /></div>
		<div class="col"><img class=" w-50" src="images/lgf-05.png" alt="" /></div>
		<div class="col"><img class=" w-50" src="images/lgf-06.png" alt="" /></div>

	</div>
</div>
<!-- 
 <div class=" mt-5 " style="padding : 50px 0 50px 0 ; background-color: #F0F4F6;">
 	<div class="container d-flex text-center justify-content-between align-items-center gap-5 " style="margin: 0 auto;" >
 		<img src="images/lgf-01.png" style="width: 100px; "  alt="" />
 		<img src="images/lgf-02.png" style="width: 100px; " alt="" />
 		<img src="images/lgf-03.jpg" style="width: 100px; " alt="" />
 		<img src="images/lgf-05.png" style="width: 90px; " alt="" />
 		<img src="images/lgf-06.png" style="width: 90px; " alt="" />
 	</div>
 </div> -->
 
<script
      src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
      integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    ></script>
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js"
      integrity="sha512-HGOnQO9+SP1V92SrtZfjqxxtLmVzqZpjFFekvzZVWoiASSQgSr4cw9Kqd2+l8Llp4Gm0G8GIFJ4ddwZilcdb8A=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    ></script>
    
    <script>
      $(".slider-div").slick({
        slide: "div", //슬라이드 되어야 할 태그 ex) div, li
        infinite: true, //무한 반복 옵션
        slidesToShow: 1, // 한 화면에 보여질 컨텐츠 개수
        slidesToScroll: 1, //스크롤 한번에 움직일 컨텐츠 개수
        speed: 300, // 다음 버튼 누르고 다음 화면 뜨는데까지 걸리는 시간(ms)
        arrows: false, // 옆으로 이동하는 화살표 표시 여부
        dots: true, // 스크롤바 아래 점으로 페이지네이션 여부
        autoplay: true, // 자동 스크롤 사용 여부
        autoplaySpeed: 8000, // 자동 스크롤 시 다음으로 넘어가는데 걸리는 시간 (ms)
        pauseOnHover: true, // 슬라이드 이동	시 마우스 호버하면 슬라이더 멈추게 설정
        vertical: false, // 세로 방향 슬라이드 옵션
        prevArrow: "<button type='button' class='slick-prev bg-primary'>Previous</button>", // 이전 화살표 모양 설정
        nextArrow: "<button type='button' class='slick-next'>Next</button>", // 다음 화살표 모양 설정
        dotsClass: "slick-dots", //아래 나오는 페이지네이션(점) css class 지정
        draggable: true, //드래그 가능 여부

        responsive: [
          // 반응형 웹 구현 옵션
          {
            breakpoint: 960, //화면 사이즈 960px
            settings: {
              //위에 옵션이 디폴트 , 여기에 추가하면 그걸로 변경
              slidesToShow: 1,
            },
          },
          {
             //화면 사이즈 768px
            settings: {
              //위에 옵션이 디폴트 , 여기에 추가하면 그걸로 변경
              slidesToShow: 1,
            },
          },
        ],
      })
    </script>
 
</body>
</html>

