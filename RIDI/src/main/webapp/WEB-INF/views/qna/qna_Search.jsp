<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div id="contents">
	<h2 class="contentsTitle">목록</h2>
	<div class="form">
				<tr>
					<th>No</th>
					<th>Subject</th>
					<th>Name</th>
					<th>Date</th>
					<th>Hit</th>
				</tr>
			</thead>
			<!-- 리스트 -->
			<tbody class="qnaList_contents">
				<c:forEach var="qnaDto" items="${qnaList }" varStatus = "status">
					 <tr class="contentsContainer">
						<td>${total - (currentPage-1)*listPerCount - status.index }</td>
						<td>${qnaDto.writerId}</td>
						<td>
							<a href="QnaView.do?no=${qnaDto.no }&clickedPage=${currentPage}&num=${qnaDto.num}">${qnaDto.subject }</a>
						</td>
						<td>
							<fmt:formatDate pattern="yy-MM-dd" value="${qnaDto.regDate }" />
						</td>
						<td>${qnaDto.readCount }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="paginationBox">
			<ul>
				<c:if test="${startPage!=1 }">
					<li>
						<a href="QnaSearchList.do?clickedPage=${startPage - pageGroupCount }&searchSelect=${param.searchSelect }&searchWord=${param.searchWord }">
						</a>
					</li>
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1" varStatus="status">
					<li class="${currentPage == i ? 'active':'' }">
						<a href="QnaSearchList.do?clickedPage=${i }&searchSelect=${param.searchSelect }&searchWord=${param.searchWord }">
							${i }
						</a>
					</li>
				</c:forEach>
				<c:if test="${endPage != lastPage}">
					<li>
						<a href="QnaSearchList.do?clickedPage=${startPage + pageGroupCount }&searchSelect=${param.searchSelect }&searchWord=${param.searchWord }">
						</a>
					</li>
				</c:if>
			</ul>
		</div>
		<form class="searchForm" method="GET" action="QnaSearchList.do">
			<select name="searchSelect" class="searchSelect">
				<option value="name"     ${param.searchSelect=="name"?"selected":"" }  >작성자</option>
				<option value="contents" ${param.searchSelect=="contents"?"selected":"" }>내용</option>
				<option value="subject"  ${param.searchSelect=="subject"?"selected":""}>제목</option>
			</select>
			<input type="text" name="searchWord" value="${param.searchWord }" placeholder="검색어를 입력하세요.">
			<input type="submit" class="btn"  value="검색">
		</form>
		<div class="btns center">
			<a href="BoardWriteForm.do">글쓰기</a>
		</div>
		
	</div>
</div>
<%@ include file="../include/footer.jsp"%>









