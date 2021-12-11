<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
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
<div id="content_Book_Info">
	<div id="book_Info_Box">
		<div class="book_Info_Inner">
			<div class="book_Img">
				<img src="${fn:replace(bookDto.book_Image,'/RIDI','')}" alt="">
			</div>
			<div class="book_Info">
				<div class="book_Info_Line">
					<div class="book_Tag">
						<ul>
							<li>${bookDto.category}</li>
							<li>${bookDto.book_Name}</li>
							<li id="starRating">${bookDto.star_Rating}</li>
							<li>${bookDto.author}<span style="font-weight:normal;"> 저</span></li>
							<li style="width: 150px; height: 20px; text-overflow: clip; overflow: hidden;"><span>출간일 </span>${bookDto.publication_Date }</li>
							<li style="display:none;"><span>hit</span>${ bookDto.count }</li>
						</ul>
					</div>
					<div class="book_parcel_Box">
						<table class="book_parcel_Box_table">
							<tbody>
								<tr class="book_Price">
									<th>구매</th>
									<td>
										<div>
											<span>판매가</span><span><fmt:formatNumber value="${bookDto.price}" pattern="#,###"/>원</span>
										</div>
									</td>
								</tr>
								<tr>
									<th>배송비</th>
									<td><span><fmt:formatNumber value="${bookDto.shipping_Price }" pattern="#,###"/>원</td>
								</tr>
								<tr>
									<th>배송예정시간</th>
									<td><span>약 ${bookDto.estimated_Time }일</span></td>
								</tr>
								<tr>
									<th>재고수</th>
									<td><span><fmt:formatNumber value="${bookDto.stock }" pattern="#,###"/>권</span></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="book_Btn">
						<!-- 오성식 수정(21.10.26) -->
						<a style="cursor: pointer;" id="dibs"><i class="fas fa-shopping-cart"></i></a> 
						<a href="OrderPayForm.do" id="bookPayBtn" onclick="return bookPay()">구매하기</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="book_Introduction">
		<h2>작품소개</h2>
		<p>${bookDto.book_Intro}</p>
	</div>
	<div class="book_Review">
		<h3>리뷰</h3>
		<div class="starRating_container">
			<div class="starRating_form">
				<div class="startRating_wrapper">
					<div class="starRate_num">
						<span>평점</span>
					</div>
					<div class="star-rating space-x-4 mx-auto">
						<input type="radio" id="5-stars" name="star_Rating" value="5" v-model="ratings" /> <label for="5-stars" class="star pr-4">★</label>
						<input type="radio" id="4-stars" name="star_Rating" value="4" v-model="ratings" /> <label for="4-stars" class="star">★</label>
						<input type="radio" id="3-stars" name="star_Rating" value="3" v-model="ratings" /> <label for="3-stars" class="star">★</label>
						<input type="radio" id="2-stars" name="star_Rating" value="2" v-model="ratings" /> <label for="2-stars" class="star">★</label>
						<input type="radio" id="1-star" name="star_Rating" value="1" v-model="ratings" /> <label for="1-star" class="star">★</label>
					</div>
				</div>
				<div class="starRating_contents">
					<textarea name="contents" placeholder="리뷰를 입력해주세요." style="resize: none;"></textarea>
				</div>
				<div class="starRating_btn">
					<button onclick="return reviewWrite('${sessionScope.loggedMember.id}','${bookDto.no }')">리뷰등록</button>
				</div>
			</div>
		</div>
		<!--starRating_container-->
		<ul class="bookContents_wrapper">
			
		</ul>
	</div>
	<!--book_Review-->

	<div class="book_Bottom_Btn">
		<a href="BookDelete.do?no=${ bookDto.no }">삭제</a> 
		<a href="BookModifyForm.do?no=${ bookDto.no }&book_Name=${bookDto.book_Name}">수정</a>
	</div>
</div>

<!-- 오성식 생성 -->
<div style="display: none" id="bookDtoBookNo">${bookDto.no }</div>
<div style="display: none" id="bookDtoPrice">${bookDto.price }</div>
<div style="display: none" id="bookDtoShippingPrice">${bookDto.shipping_Price }</div>
<div style="display: none" id="bookDtoImage">${bookDto.book_Image}</div>
<div style="display: none" id="loggedMemberId">${sessionScope.loggedMember.id }</div>
<div style="display: none" id="loggedMemberAddress">${sessionScope.loggedMember.address }</div>
<script src="./js/review/review_Write.js" defer></script>
<script src="./js/order/book_Info.js" defer></script>
<!-- 오성식 생성 -->
<%@ include file="../include/footer.jsp"%>