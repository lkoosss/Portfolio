<%@page import="com.ssoh.model.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ssoh.model.BoardDao"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div id="contents">
        <h2 class="contentsTitle">게시글</h2>
        <div class="form wide" name="writeContents" >
            <table>
                <colgroup>
                    <col style="width:90px;">
                    <col>
                    <col style="width:100px;">
                    <col style="width:100px;">
                </colgroup>
                <thead>
                    <th>No</th>
                    <th class="left">Subject</th>
                    <th>Name</th>
                    <th>Count</th>
                </thead>
                <tbody>
                	<c:forEach var="board" items="${boardList }">
               			<tr>
	                        <td>${board.no }</td>
	                        <c:if test="${board.reStep <= 0}">
		                        <td class="left"><a href="./GoArticleReadViewPage.do?articleNumber=${board.no }">${board.subject }</a></td>
	                        </c:if>
	                        <c:if test="${board.reStep > 0}">
		                        <td class="left"><a href="./GoArticleReadViewPage.do?articleNumber=${board.no }"><span class="indent${board.reStep }"><span class="material-icons">subdirectory_arrow_right</span>${board.subject }</span></a></td>
	                        </c:if>
	                        <td>${board.name }</td>
	                        <td>${board.readCount }</td>
	                    </tr>
                	</c:forEach>
                </tbody>
            </table>
            <div class="paginationBox">
            	<ul>
            		<c:if test="${firstNumOfPageList > 1 }">
	            		<li><a href="./GoBoardListViewPage.do?currentPage=${firstNumOfPageList - pageListLength}&searchWord=${searchWord}&searchField=${searchField}"><span class="material-icons">navigate_before</span></a></li>
            		</c:if>
            		<c:forEach var="i" begin="${firstNumOfPageList }" end="${lastNumOfPageList }" varStatus="status">
            			<li class="${currentPage == i ? 'active':'' }"><a href="./GoBoardListViewPage.do?currentPage=${i }&searchWord=${searchWord}&searchField=${searchField}">${i }</a></li>
            		</c:forEach>
            		<c:if test="${lastNumOfPageList < endPageNum }">
	            		<li><a href="./GoBoardListViewPage.do?currentPage=${firstNumOfPageList + pageListLength}&searchWord=${searchWord}&searchField=${searchField}"><span class="material-icons">navigate_next</span></a></li>
            		</c:if>
            	</ul>
            </div>
            <form action="GoBoardListViewPage.do" method="GET" class="searchForm">
            	<select name="searchField" class="searchSelect">
            		<option name="subject" value="subject" ${searchField == "subject" ? "selected":"" }>제목</option>
            		<option name="name" value="name" ${searchField == "name" ? "selected":"" }>작성자</option>
            		<option name="contents" value="contents" ${searchField == "contents" ? "selected":"" }>내용</option>
            	</select>
            	<input type="text" name="searchWord" value="${searchWord }" placeholder="검색어를 입력하세요">
            	<input type="submit" value="검색" class="btn">
        	</form>
           	<c:if test="${!empty loggedMemberDto }">
            	<div class="btns">
            		<a href="./GoArticleWriteViewPage.do" class="btn">글쓰기</a>
	            </div>
           	</c:if>
        </div>
        
    </div>
<%@ include file="../include/footer.jsp"%>