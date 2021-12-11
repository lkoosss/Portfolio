<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
	<div class="testBox" style="height:800px; padding-left:300px;">
		<form action="ReviewWrite.do">
			<h2>리뷰쓰기</h2>
			<div>
				<input type="text" name="book_No" id="book_No" placeholder="책 번호">
			</div>
			<div>
				<input type="text" name="contents" id="contents" placeholder="내용">
			</div>
			<div>
				<input type="text" name="writer_Id" id="writer_Id" placeholder="작성자" value="${sessionScope.loggedMember.id }">
			</div>
			<div>
				<div id="star">
					<a href="#" value="1" style="font-size:20px; color:#FF5356"><i class="far fa-star"></i></a>
					<a href="#" value="2" style="font-size:20px; color:#FF5356"><i class="far fa-star"></i></a>
					<a href="#" value="3" style="font-size:20px; color:#FF5356"><i class="far fa-star"></i></a>
					<a href="#" value="4" style="font-size:20px; color:#FF5356"><i class="far fa-star"></i></a>
					<a href="#" value="5" style="font-size:20px; color:#FF5356"><i class="far fa-star"></i></a>
				</div>
				<input type="number" name="star_Rating" id="star_Rating" placeholder="별점" readonly>
			</div>
			<div>
				<input type="password" name="password" id="password" placeholder="비밀번호">
			</div>
			<div>
				<input type="submit" value="리뷰 작성">
			</div>
		</form>
		<br><br>
		<h2> 리뷰리스트</h2>
		<br><br>
		<table>
			<thead>
				<tr>
					<th>글 번호</th>
					<th>책 번호</th>
					<th>내용</th>
					<th>작성자</th>
					<th>별점</th>
					<th>비밀번호</th>
					<th>작성날짜</th>
					<th>삭제버튼</th>
				</tr>
			</thead>
			<tbody class="reviewList">
			</tbody>
		</table>
	</div>
	<script src="./js/review_Write.js" defer></script>
	<link rel="stylesheet" property="stylesheet" href="./css/review_Write.css"></link>
<%@ include file="../include/footer.jsp"%>