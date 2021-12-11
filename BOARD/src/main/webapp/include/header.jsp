<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INCLUDE 연습</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@100;200;300;400;500;600;700&display=swap"
	rel="stylesheet">

<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<script src="./js/jquery-3.6.0.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
 
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<link href="summernote/summernote-lite.css" rel="stylesheet">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="summernote/summernote-lite.js"></script>

<link rel="stylesheet" href="./css/layout.css">
</head>
<body>
	<header id="header">
		<div class="container">
			<h1 id="logo">
				<a href="./GoBoardListViewPage.do">SSOH'S MEDIA</a>
			</h1>
			<nav id="gnb">
				<ul>
					<c:if test="${empty sessionScope.loggedMemberDto }">
						<li><a href="./GoMemberLoginViewPage.do">로그인</a></li>
						<li><a href="./GoMemberJoinViewPage.do">회원가입</a></li>
						<li><a href="./GoBoardListViewPage.do">게시판</a></li>
					</c:if>
					<c:if test="${!empty sessionScope.loggedMemberDto }">
						<li><a href="./GoMemberInfoViewPage.do">${sessionScope.loggedMemberDto.name }</a></li>
						<li><a href="./MemberLogout.do">로그아웃</a></li>
						<li><a href="./GoBoardListViewPage.do">게시판</a></li>
						<li><a href="./GoFAQListViewPage.do">FAQ</a></li>
					</c:if>
				</ul>
			</nav>
		</div>
	</header>
	<!-- 내용은 여기에 들어감... -->