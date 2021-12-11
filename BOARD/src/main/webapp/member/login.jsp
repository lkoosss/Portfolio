<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
	<div id="contents">
        <h2 class="contentsTitle">로그인</h2>
        <form action="./MemberLoginCheck.do" class="form" name="signUp" method="POST">
            <table>
                <colgroup>
                    <col style="width:80px;">
                    <col style="width:200px;">
                </colgroup>
                <tbody>
                    <tr>
                        <th>ID <span>*</span></th>
                        <td class="left"><input type="text" name="userId"></td>
                    </tr>
                    <tr>
                        <th>비밀번호 <span>*</span></th>
                        <td class="left"><input type="password" name="userPw"></td>
                    </tr>
                </tbody>
            </table>
            <div class="btns">
                <input type="submit" value="로그인" onClick="return checkEmptyData();">
                <input type="button" value="취소" onclick="cancle()">
            </div>
        </form>
    </div>
    <script>
        function checkEmptyData(){
            if(document.signUp.userId.value == ""){
           	 	alert("아이디를 입력하세요.");
                document.signUp.userId.focus();
                return false;
            } else if(document.signUp.userPw.value == ""){
                alert("패스워드를 입력하세요.");
                document.signUp.userId.focus();
                return false;
            } else{
                return true;
            }
        }
        function cancle(){
            location.href="./GoBoardListViewPage.do"
        }
    </script>
<%@ include file="../include/footer.jsp"%>