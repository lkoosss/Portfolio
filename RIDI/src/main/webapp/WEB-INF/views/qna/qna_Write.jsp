<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<div id="contents" class="qna_Write">
	 <h2 class="qnaWrite_title">게시판 글쓰기</h2>
		 <form method="POST" action="QnaWrite.do" class="qnaWrite_form">
		 <div class="qnaWrite_container">
			<ul class="qnaWrite_inner">
				<li>
                        <div><span>작성자<span></div>
                        <label><input type="text" name="writerId" placeholder="이름을 입력하세요"></label>
                 </li>
				<li>
                        <div><span>제목</span></div>
                        <label><input type="text" name="subject" placeholder="제목을 입력하세요"></label>
                 </li>
				<li>
                        <div><span>패스워드</span></div>
                        <label><input type="password" name="password" placeholder="패스워드를 입력하세요"></label>
                    </li>
				<li>
                        <div><span>내용</span></div>
                        <label><textarea rows="" cols="" name="contents" placeholder="내용을 입력하세요"></textarea></label>
                  </li>
				</ul>
            </div>
		<div class="qnaWrite_btn">
                <input type="submit" value="확인">
                <input type="button" onClick="history.go(-1)" value="취소">
            </div>
	</form>
</div>
<%@ include file="../include/footer.jsp" %>