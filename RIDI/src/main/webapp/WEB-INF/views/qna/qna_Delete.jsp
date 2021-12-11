<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<main>
	<div id="contents">
		<h2 class="contentsTitle">게시글 삭제</h2>
		
			<table >
				<tbody>
					<tr>
						<th>password</th>
						<td><input type="password" placeholder="패스워드를 입력하시오." name="password"></td>
					</tr>
				</tbody>
			</table>
			<form method="POST" action="QndDelete.do" class="form">
			<div class="btns center">
				<input type="submit" value="삭제">
				<a href="QnaView.do">취소</a>
			</div>
			<input type="hidden" name="no" value="${param.no }" >
		</form>
	</div>
</main>
<%@ include file="../include/footer.jsp"%>