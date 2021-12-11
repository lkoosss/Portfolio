<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./css/RIDI.css">
<link rel="stylesheet" href="./css/layout.css">
<!-- <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">  -->
<!-- <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>  -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
	integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/gsap/gsap.min.js"></script>
<script src="js/main.js" defer></script>
<script src="js/isotope.pkgd.min.js"></script>
<script src="js/imagesloaded.pkgd.min.js"></script>

<script src="js/summernote/summernote.min.js"></script>
<script type="text/javascript"
	src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"
	defer></script>
<link rel="shortcut icon" href="./images/favicon.ico">

<title>RIDI</title>
</head>
<body id="home">
	<div id="wrap">
		<header id="header">
			<div class="header_Inner">
				<div class="header_Top">
					<div class="logo_Search">
						<h1 class="logo">
							<a href="/">RIDI <span class="tone_Down">RIDI</span></a>
						</h1>
						<form action="" method="POST">
							<input type="text" name="search_Box" id="search_Box"
								placeholder="제목, 저자, 출판사검색">
							<!--<input type="submit" class="btn"  value="검색">-->
							<!--어떤식으로할지 고민해보고 바꾸기-->
						</form>
					</div>
					<div id="logJoin">
						<c:if test="${empty sessionScope.loggedMember }">
							<a href="MemberJoinForm.do" class="HDJoin">회원가입</a>
							<a href="MemberLoginForm.do" class="HDLogin">로그인</a>
						</c:if>
						<c:if test="${!empty sessionScope.loggedMember }">
							<a style="color: #fff">${loggedMember.name }님 환영합니다</a>
							<a href="MemberLogout.do" class="HDLogin">로그아웃</a>
						</c:if>
					</div>
				</div>
				<nav>
					<ul class="headerMenu">
						<li><a href="/"><i class="fas fa-home"></i>홈<span class="menu_Under"></span></a></li>
						<li><a href="CartListForm.do"><i class="fas fa-shopping-cart"></i>카트<span class="menu_Under"></span></a></li>
						<li><a href="OrderPayForm.do"><i class="fas fa-box"></i>주문/배송조회<span class="menu_Under"></span></a></li>
						<li><a href="BookWriteForm.do"><i class="fas fa-book"></i>책 판매<span class="menu_Under"></span></a></li>
						<c:if test="${!empty sessionScope.loggedMember }">
							<li><a href="MemberHomeForm.do"><i class="far fa-user"></i>마이리디<span class="menu_Under"></span></a></li>
						</c:if>
						<li><a href="QnaList.do"><i class="fab fa-quora"></i>QnA<span class="menu_Under"></span></a></li>
					</ul>
				</nav>
			</div>
		</header>
	</div>