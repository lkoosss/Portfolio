<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="qnaView_body">
	<div id="qna_View" class="qna_View">
		<div class="qnaView_form">
			<div class="qnaView_container">
				<ul class="qnaView_inner">
					<li>
						<div>
							<sapn>제목</sapn>
						</div>
						<div>${qnaDto.subject}</div>
					</li>
					<li>
						<div>
							<span>조회수</span>
						</div>
						<div>${qnaDto.readCount}</div>
					</li>
					<li>
						<div>
							<span>작성일자</span>
						</div>
						<div>${qnaDto.regDate}</div>
					</li>
					<li>
						<div>
							<span>작성자</span>
						</div>
						<div>${qnaDto.writerId}</div>
					</li>
					<li>
						<div class="txtContents">
							<span>내용</span>
						</div>
						<div>${qnaDto.contents}</div>
						<div id="qnaNo" style="display: none;">${qnaDto.no }</div>
					</li>
				</ul>
			</div>
			<div class="bottomContent">
				<div class="prevAndNext">
					<!-- 다음 페이지로 넘기기 -->
					<div class="item">
						<span class="inner">NEXT <span class="fas fa-angle-up"></span></span>
						<a href="QnaView.do?no=${nextQnaDto.no}&clickedPage=1&num=${nextQnaDto.num}&searchField=${searchField}&searchWord=${searchWord}">${nextQnaDto.subject }</a>
					</div>
					<!-- 이전 페이지로 넘기기 -->
					<div class="item">
						<span class="inner">PREV&nbsp;<span class="fas fa-angle-down"></span></span>
						<a href="QnaView.do?no=${prevQnaDto.no}&clickedPage=1&num=${prevQnaDto.num}&searchField=${searchField}&searchWord=${searchWord}">${prevQnaDto.subject }</a>
					</div>
				</div>
				<!--  댓글기능 -->
				<div class="qnaView_btn">
					<div class="replyBox">
						<textarea name="reply" id="reply" placeholder="댓글을 입력해주세요." maxlength=100></textarea>
						<button class="btnReply">댓글 등록</button>
					</div>
					<div class="txtCount">
						<span id="currentCount"></span>/100
					</div>
					<div class="replyList">
						<!-- 여기에 댓글 등록 -->
						<ul class="list">
						
						
						</ul>
					</div>
					<a href="QnaList.do?clickedPage=1">목록</a> 
					<a href="#" id="qnaDeleteBtn">삭제</a>
				</div>
			</div>

		</div>
	</div>
</div>
<script src="./js/qna/qna_View.js" defer></script>
<link rel="stylesheet" href="./css/qnaView.css">
<%@ include file="../include/footer.jsp"%>



