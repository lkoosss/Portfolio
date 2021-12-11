<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
<div class="headerCategoryLine">
	<nav class="headerCategoryInner">
		<ul class="headerCategory">
			<li><i class="fas fa-caret-right"></i></li>
			<li><a href="MoneyBookForm.do">재테크</a></li>
			<li><a href="ComicBookForm.do">만화</a></li>
			<li><a href="EssayBookForm.do">에세이</a></li>
		</ul>
	</nav>
</div>
<div id="main_Content">
	<!--  SLIDER CLASS NAME 변경  -->
	<div class="main_slider"></div>
	<div class="main_Best">
		<h3>
			베스트 셀러 <i class="fas fa-chevron-right"></i>
		</h3>
		<div class="main_Best_Inner">
			<ul class="grid">

			</ul>
		</div>
	</div>
	<div class="main_Pop">
		<h3>
			조회수 많은 책 <i class="fas fa-chevron-right"></i>
		</h3>
		<div class="main_Pop_Inner">
			<ul class="Popgrid">

			</ul>
		</div>
	</div>
	<div class="main_New">
		<div class="main_New">
			<div class="main_New_Inner">
				<h4>신간도서</h4>
				<div class="newBook_Slide"></div>
			</div>
		</div>
	</div>
	<div class="main_movie">
		<div class="ad_inner">
			<iframe width="1200" height="393"
				src="https://www.youtube.com/embed/mSuoqRNpj_c"
				title="YouTube video player" frameborder="0"
				allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
				allowfullscreen></iframe>
		</div>
	</div>
</div>
<%@ include file="include/footer.jsp"%>