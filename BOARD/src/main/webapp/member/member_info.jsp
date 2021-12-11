<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>

	<div id="contents">
        <h2 class="contentsTitle">회원 정보</h2>
        <div class="form">
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
                        <th>우편번호</th>
                        <td class="left">${sessionScope.loggedMemberDto.zipcode }</td>
                    </tr>
                    <tr>
                        <th>주소</th>
                        <td class="left">
                        <c:forTokens var="address" items="${sessionScope.loggedMemberDto.address }" delims="/">
	                        <div>${address }</div>
                        </c:forTokens>
                        </td>
                    </tr>
                    <tr>
                        <th>휴대전화</th>
                        <td class="left">${sessionScope.loggedMemberDto.hp }</td>
                    </tr>
                    <tr>
                        <th>이메일</th>
                        <td class="left">${sessionScope.loggedMemberDto.email }</td>
                    </tr>
                </tbody>
            </table>
            <div class="btns">
            	<a href="./GoMemberInfoModifyViewPage.do">회원정보 수정</a>
                <a href="./GoMemberDeleteViewPage.do">회원 탈퇴</a>
            </div>
        </div>
    </div>
<%@ include file="../include/footer.jsp"%>