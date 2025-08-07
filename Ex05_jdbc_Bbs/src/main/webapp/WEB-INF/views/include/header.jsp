<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/5.3.3/css/bootstrap.css"
	media="all" />
 <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.css"
      integrity="sha512-wR4oNhLBHf7smjy0K4oqzdWumd+r5/+6QO/vDda76MW5iug4PT7v86FoEkySIJft3XA0Ae6axhIvHrqwm793Nw=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick-theme.css"
      integrity="sha512-6lLUdeQ5uheMFbWm3CP271l14RsX1xtx+J5x2yeIDkkiBpeVTNhTqijME7GgRKKi6hCqovwCoBTlRBEC20M8Mg=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />

<link rel="stylesheet" href="css/style.css" media="all" />

 <style>
      .slider-div {
        width:100% ;
        margin: 0 auto;
      }
      .slider-div img {
	    height: 600px;
	    object-fit: cover;
   		 width: 100%;
      }

      .slick-prev {
        position: absolute;
        left: -20px;
        z-index: 10;
      }
      .slick-next {
        position: absolute;
        right: 10px;
      }
    </style>
</head>
<body>
	<div class=" text-black mb-2 mt-4">
		<div class="container d-flex justify-content-between align-items-center py-3  ">
			<div>
				<a href="/"><img src="images/Group.jpg" alt="" style="width: 80px; height: auto;" /></a> 
			</div>
			<div>
				<ul class=" fw-bold gap-5 align-items-center d-none d-md-flex"  style="font-size: 20px;">
					<li><a href="lg" class="nav-link">LG재단</a></li>
					<li><a href="" class="nav-link">연암문화재단</a></li>
					<li><a href="" class="nav-link">상록재단</a></li>
					<li><a href="" class="nav-link">연암학원</a></li>
					<li><a href="" class="nav-link">소식/공지</a></li>
				</ul>
			</div>
	 		<div class= "d-flex gap-4">
				<img src="images/icon-search.jpg" alt="" />
				<img src="images/icon-lang.jpg" alt="" />
				<img src="images/icon-menu.jpg" alt="" />
			</div> 
		</div>
	</div>



