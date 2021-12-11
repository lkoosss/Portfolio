<%@page import="com.ssoh.model.BoardDto"%>
<%@page import="com.ssoh.model.BoardDao"%>
<%@page import="com.ssoh.model.MemberDto"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
	<div id="contents">
        <h2 class="contentsTitle">게시글</h2>
        <div class="form">
            <table>
                <colgroup>
                    <col style="width:100px;">
                    <col style="width:100px;">
                    <col style="width:100px;">
                    <col style="width:100px;">
                </colgroup>
                <tbody>
        			<tr>
                        <th>글쓴이 이름</th>
                        <td>${boardDto.name }</td>
                        <th>글쓴이 ID</th>
                        <td>${boardDto.id }</td>
                    </tr>
                    <tr>
                    	<th>게시날짜</th>
                    	<td>${boardDto.regDate }</td>
                        <th>조회수</th>
                        <td>${boardDto.readCount }</td>
                    </tr>
                    <tr>
                    	<th>제목</th>
                        <td class="left" colspan="3">${boardDto.subject }</td>
                    </tr>
                    <tr>
                        <th>내용</th>
                        <td class="left" colspan="3">${boardDto.contents }</td>
                    </tr>
                </tbody>
            </table>
           	<c:if test="${empty loggedUserId}">
            	<div class="btns">
	            	<a href="#" onClick="history.back()">뒤로가기</a>
	            </div>
           	</c:if>
           	<c:if test="${!empty loggedUserId && loggedUserId != boardDto.id }">
           		<div class="btns">
	            	<a href="./GoArticleReplyWriteViewPage.do?articleNumberToReply=${articleNumber }">답글쓰기</a>
	            	<a href="#" onClick="history.back()">뒤로가기</a>
	            </div>
           	</c:if>
           	<c:if test="${loggedUserId == boardDto.id }">
            	<div class="btns">
	            	<a href="./BoardDelete.do?articleNumberToDelete=${articleNumber }" onclick="return confirm('정말 삭제하시겠습니까?')">글 삭제</a>
	                <a href="./GoArticleModifyViewPage.do?articleNumberToModify=${articleNumber }" onclick="modifyArticle()">수정</a>
	                <a href="#" onClick="history.back()">뒤로가기</a>
	            </div>
           	</c:if>
        </div>
    </div>
<%@ include file="../include/footer.jsp"%>