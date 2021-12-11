<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="../include/header.jsp"%>
	<div id="contents">
        <h2 class="contentsTitle">회원정보 수정</h2>
        <form action="./MemberInfoModify.do" class="form" name="signUp" method="POST">
            <table>
                <colgroup>
                    <col style="width:80px;">
                    <col style="width:200px;">
                </colgroup>
                <tbody>
          				<tr>
                        <th>이름</th>
                        <td class="left">${sessionScope.loggedMemberDto.name }</td>
                    </tr>
                    <tr>
                        <th>ID</th>
                        <td class="left">${sessionScope.loggedMemberDto.id }</td>
                    </tr>
                    <tr>
                        <th>비밀번호</th>
                        <td class="left"><input type="password" name="userPw"></td>
                    </tr>
                    <tr>
                        <th>비밀번호 확인</th> 
                        <td class="left"><input type="password" name="userPwCheck" onkeyup="checkPw()"><label id="pwCheckResult"></label></td>
                    </tr>   
                    <tr>
                        <th>주소</th>
                        <td class="left">
                            <div>
                                <input type="text" name="zipcode" readonly value="${sessionScope.loggedMemberDto.zipcode }">
                                <input type="button" value="우편번호" onclick="findAddr()">
                            </div>
                            <c:forTokens var="address" items="${sessionScope.loggedMemberDto.address }" delims="/" varStatus="status">
                            	<c:if test="${status.first }">
                            		<div>
		                                <label><input type="text" name="address01" readonly value="${address }"> 기본 주소</label>
		                            </div>
                            	</c:if>
                            	<c:if test="${status.last }">
                            		<div>
		                                <label><input type="text" name="address02" value="${address }"> 나머지 주소</label>
		                            </div>
                            	</c:if>
                            </c:forTokens>
                        </td>
                    </tr>
                    <tr>
                        <th>휴대전화</th>
                        <td class="left">
                            <select name="phoneNumber01" class="short">
                            	<c:if test="${fn:substring(sessionScope.loggedMemberDto.hp,0,3) == 010 }">
                            		<option value="010" selected>010</option>
	                                <option value="011">011</option>
	                                <option value="012">012</option>
                            	</c:if>
                            	<c:if test="${fn:substring(sessionScope.loggedMemberDto.hp,0,3) == 011 }">
                            		<option value="010">010</option>
	                                <option value="011" selected>011</option>
	                                <option value="012">012</option>
                            	</c:if>
                            	<c:if test="${fn:substring(sessionScope.loggedMemberDto.hp,0,3) == 012 }">
                            		<option value="010">010</option>
	                                <option value="011">011</option>
	                                <option value="012" selected>012</option>
                            	</c:if>
                            </select> -
                            <input type="text" name="phoneNumber02" class="short" value="${fn:substring(sessionScope.loggedMemberDto.hp,3,7) }"> - <input type="text" name="phoneNumber03" class="short" value="${fn:substring(sessionScope.loggedMemberDto.hp,7,11) }">
                        </td>
                    </tr>
                    <tr>
                        <th>이메일</th>
                        <td class="left">
                            <input type="text" name="userEmail" value="${sessionScope.loggedMemberDto.email }">
                        </td>
                    </tr>
                </tbody>
            </table>
            <div class="btns">
                <input type="submit" value="확인" onClick="return checkEmptyData()">
                <input type="button" value="취소" onclick="cancleJoin()">
            </div>
        </form>
    </div>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script>
        function checkEmptyData(){
            if(document.signUp.userPw.value == "" && document.signUp.userPwCheck.value != ""){
            	 alert("패스워드를 입력하세요.");
                 document.signUp.userPw.focus();
                 return false;
            } else if(document.signUp.userPw.value != "" && document.signUp.userPwCheck.value == ""){
                alert("확인용 패스워드를 입력하세요.");
                document.signUp.userPwCheck.focus();
                return false;
            } else if(document.signUp.userPw.value != document.signUp.userPwCheck.value){
                alert("패스워드가 서로 다릅니다.");
                document.signUp.userPwCheck.focus();
                return false;
            } else if(document.signUp.zipcode.value == "" || document.signUp.address01.value == "" || document.signUp.address02.value == ""){
                alert("주소를 모두 입력해주세요.");
                document.signUp.address02.focus();
                return false;
            } else if(document.signUp.userEmail.value == ""){
                alert("메일주소를 입력하세요.");
                document.signUp.userEmail.focus();
                return false;
            } else{
                return true;
            }
        }
        function checkPw(){
            if(document.signUp.userPwCheck.value.length >= document.signUp.userPw.value.length){
                if(document.signUp.userPwCheck.value != document.signUp.userPw.value){
                    $("#pwCheckResult").css("color","red");
                    $("#pwCheckResult").text(" 비밀번호가 일치하지 않습니다.");
                } else {
                    $("#pwCheckResult").css("color","blue");
                    $("#pwCheckResult").text(" 비밀번호가 일치합니다.");
                }
            }
            
        }
        function cancleJoin(){
        	location.href="./GoBoardListViewPage.do"
        }
        function findAddr(){
            new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
                // 예제를 참고하여 다양한 활용법을 확인해 보세요.
                document.signUp.zipcode.value = data.zonecode;
                document.signUp.address01.value = data.address;
            }
        }).open();
        }
    </script>
<%@ include file="../include/footer.jsp"%>