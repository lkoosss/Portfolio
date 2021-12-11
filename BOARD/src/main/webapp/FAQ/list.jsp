<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div id="contents">
        <h2 class="contentsTitle">자주하는 질문</h2>
        <form action="write.jsp" class="form" name="writeContents" method="POST">
            <table>
                <colgroup>
                    <col style="width:10px;">
                    <col style="width:600px;">
                </colgroup>
                <thead>
                    <th>No</th>
                    <th class="left">Subject</th>
                </thead>
                <tbody>
                	<c:forEach var="faqDto" items="${requestScope.faqList }">
	         		  <tr>
	                     <td>${faqDto.no }</td>
	                     <td class="left faqSubjects")>${faqDto.subject }</td>
	                  </tr>
	                  <tr class="faqContent" id="faq${faqDto.no }" style="background-color:#f8f8f8;">
	                  	<td colspan="2">${faqDto.contents }</td>
	                  </tr>
                	</c:forEach>
                </tbody>
            </table>
        </form>
    </div>
    <script>
			$(document).ready(function(){
				$(".faqSubjects").parent().next().children("td").hide();
				$(".faqSubjects").click(function(){
					$(".faqSubjects").parent().next().children("td").hide();
					$(this).parent().next().children("td").slideDown();
					// $(".faqContent").show();
				})
			});
    </script>
<%@ include file="../include/footer.jsp"%>