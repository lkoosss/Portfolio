<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
	<div id="content">
        <div class="info_Content">
            <div class="info_Inner">
                <div class="info_Sub">
                    <div class="info_Table_Line">
                        <h2 class="info_Table">마이리디</h2>
                    </div>
                    <ul class="info_List">
                        <li><a href="MemberHomeForm.do">마이리디홈</a></li>
                        <li><a href="#">문의하기</a></li>
                        <li><a href="MemberInfoModifyForm.do">정보변경</a></li>
                    </ul>
                </div>
                <div id="delete_check">
                    <form action="MemberDelete.do" method="POST">
                        <h4>회원탈퇴</h4>
                        <p>보안을 위해 비밀번호를 입력해 주세요.</p>
                        <input type="password" name="password" id="userPw" class="delete_Check">
                        <input type="submit" value="확인" class="delete_Btn">
                    </form>
                </div>
            </div>
        </div>  
    </div>
<%@ include file="../include/footer.jsp"%>