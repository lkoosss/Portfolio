<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
	<script src="./js/member/member_Modify.js" defer></script>
	 <div id="content">
        <div class="info_Content">
            <div class="info_Inner">
                <div class="info_Sub">
                    <div class="info_Table_Line">
                        <h2 class="info_Table">마이리디</h2>
                    </div>
                    <ul class="info_List">
                        <li><a href="MemberHomeForm.do">마이리디홈</a></li>
                        <li><a href="QnaList.do">문의하기</a></li>
                        <li><a href="MemberInfoModifyForm.do">정보변경</a></li>
                    </ul>
                </div>
                <div id="modify_Form">
                    <h4>정보 변경</h4>
                    <form action="MemberInfoModify.do" method="post">
                        <table>
                            <tbody>
                                <tr>
                                    <th>이름</th>
                                    <td class="modify_Name"><span>${sessionScope.loggedMember.name }</span><a href="MemberDeleteForm.do" class="delete_Btn" onClick="return checkRealDelete();">회원탈퇴</a></td>
                                </tr>
                                <tr>
                                    <th>아이디</th>
									<td><span>${sessionScope.loggedMember.id }</span></td>

                                </tr>
                                <tr>
                                    <th>이메일</th>
                                    <td><span>${sessionScope.loggedMember.email }</span></td>
                                </tr>
                                <tr>
                                    <th>휴대폰 번호</th>
                                    <td class="modify_Ph_Box">
                                        <select name="hp_First" class="modify_Ph">
                                            <option value="010">010</option>
                                            <option value="011">011</option>
                                            <option value="017">017</option>
                                        </select> - <input type="number" name="hp_Middle" class="short" value="${ fn:substring(sessionScope.loggedMember.hp,4,8)}">
                                        - <input type="number" name="hp_Last" class="short" value="${ fn:substring(sessionScope.loggedMember.hp,9,13)}">
                                    </td>
                                </tr>
                                <tr>
                                    <th>비밀번호 변경</th>
                                    <td class="modify_Pw_Box">
                                        <ul>
                                            <li class="modify_pw">
                                                <input type="password" name="password" placeholder="변경을 원할때만 입력"  id="userPw" class="modify_box">
                                            </li>
                                            <li class="modify_pw2">
                                                <input type="password" name="password02" placeholder="비밀번호 확인" id="userPw02" class="modify_box">
                                            </li>
                                        </ul>
                                    </td>
                                </tr>
                                <tr>
                                    <th>주소변경</th>
                                    <td class="modify_Add">
                                        <div class="zipcode_Container">
                                            <input type="number" name="zipcode" class="zipcode_Box" id="zipcode" value="${sessionScope.loggedMember.zipcode }" readonly> 
                                            <input type="button" name="zipCode_Btn" value="우편번호 검색" id="btnZip" class="zipcode_Btn" onclick="findAddr()">
                                        </div>
                                        <div class="address_Container">
	                                        <div class="address01_container">
	                                            <input type="text" name="address01" id="address01" class="modify_box1" value="${fn:substringBefore(sessionScope.loggedMember.address,'/') }" readonly>
	                                        </div>
	                                        <div class="address02_Container">
	                                            <input type="text" name="address02" id="address02" class="modify_box2" value="${fn:substringAfter(sessionScope.loggedMember.address,'/') }">
	                                        </div>
                                        </div>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="modify_Btn_Box">
                            <input type="submit" value="회원수정" class="modify_Btn">
                            <a href="MemberHomeForm.do" class="modify_Cancel">취소</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>  
    </div>
    <script>
		function findAddr(){
			new daum.Postcode({
	            oncomplete: function(data) {
	            	$("#zipcode").val(data.zonecode);
	            	$("#address01").val(data.address);
	            }
	        }).open();
	        return false;	
		}
	   
	    function checkRealDelete(){
	    	if(confirm("정말 탈퇴를 진행하시겠습니까?") == true){
	    		return true;
	    	} else{
	    		return false;
	    	}
	    	
	    }
    </script>
<%@ include file="../include/footer.jsp"%>