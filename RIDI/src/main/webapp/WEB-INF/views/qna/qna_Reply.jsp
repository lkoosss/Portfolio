<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div id="contents" class="qna_Reply">
        <h2 class="qnaReply_title">답글달기</h2>
        <form method="POST" action="ReplySelectAll.do" class="qnaReply_form">
            <div class="qnaReply_container">
                <ul class="qnaReply_inner">
                    <li>
                        <div><span>작성자<span></div>
                        <label><input type="text" name="writer_Id" placeholder="이름을 입력하세요"></label>
                    </li>
                    <li>
                        <div><span>내용</span></div>
                        <label><textarea rows="" cols="" name="contents" placeholder="내용을 입력하세요"></textarea></label>
                    </li>
                </ul>
            </div>
            <div class="qnaReply_btn">
                <input type="hidden" name="no" value="${no }"> 
                <input type="hidden" name="reGroup" value="${reGroup }">
                <input type="hidden" name="reStep" value="${reStep }"> 
                <input type="hidden" name="reLevel" value="${reLevel }"> 
                <input type="submit" value="확인"> 
                <input type="button" value="취소">
            </div>
        </form>
    </div>
<%@ include file="../include/footer.jsp"%>



