<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
	<div id="contents">
        <h2 class="contentsTitle">회원 탈퇴</h2>
        <form action="./MemberDelete.do" class="form" name="signUp" method="GET">
            <table>
                <colgroup>
                    <col style="width:80px;">
                    <col style="width:200px;">
                </colgroup>
                <tbody>
                    <tr>
                        <th>ID</th>
                        <td class="left">${sessionScope.loggedMemberDto.id }</td>
                    </tr>
                    <tr>
                        <th>비밀번호 <span>*</span></th>
                        <td class="left"><input type="password" name="userPw"></td>
                    </tr>
                </tbody>
            </table>
            <div class="btns">
                <input type="submit" value="탈퇴" onClick="return checkEmptyData();">
                <input type="button" value="취소" onclick="cancle()">
            </div>
        </form>
    </div>
    <script>
        function checkEmptyData(){
            if(document.signUp.userPw.value == ""){
            	alert("패스워드를 입력하세요.");
                document.signUp.userPw.focus();
                return false;
            } 
            if(confirm("정말 회원 탈퇴하시겠습니까?") == true){
            	return true;
            } else {
            	return false;
            }
        }
        function cancle(){
            location.href="./GoBoardListViewPage.do"
        }
    </script>
<%@ include file="../include/footer.jsp"%>