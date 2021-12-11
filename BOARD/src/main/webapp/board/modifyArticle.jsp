<%@page import="com.ssoh.model.MemberDto"%>
<%@page import="com.ssoh.model.BoardDto"%>
<%@page import="com.ssoh.model.BoardDao"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
	<div id="contents">
        <h2 class="contentsTitle">게시글 수정</h2>
        <form action="./BoardModify.do" method="POST"  class="form">
            <table>
                <colgroup>
                    <col style="width:80px;">
                    <col style="width:200px;">
                </colgroup>
                <tbody>
        			<tr>
                        <th>글쓴이 이름</th>
                        <td class="left">${boardDto.name }</td>
                    </tr>
                    <tr>
                        <th>글쓴이 ID</th>
                        <td class="left">${boardDto.id }</td>
                    </tr>
                    <tr>
                        <th>제목</th>
                        <td class="left"><input type="text" name="articleSubjectToModify" value='${boardDto.subject }'></td>
                    </tr>
                    <tr>
                        <th>내용</th>
                        <div class="container">
	                        <td class="left"><textarea class="summernote" name="articleContentsToModify" cols="30" rows="10">${boardDto.contents }</textarea></td>
                        </div>
                    </tr>
                    <input type="hidden" name="articleNumberToModify" value="${boardDto.no }">
                </tbody>
            </table>
            	<div class="btns">
	            	<input type="submit" value="수정 완료" onclick="">
	                <a onclick="cancle()">취소</a>
	            </div>
        </form>
    </div>
    <script>
    	function cancle(){
    		history.back();
    	}
    	
    	$(".summernote").summernote({
        	height: 300,
        	callbacks:{
        		onImageUpload: function(files){
        			uploadImg(files[0],this);
        		}
        	}
        });
        
        function uploadImg(file,editor){
        	var form_data = new FormData();
        	form_data.append('uploadFile',file);
        	$.ajax({
        		data: form_data,
        		type: "POST",
        		url: './SummerNoteFileUpload.do',
        		cache: false,
        		processData: false,
        		contentType: false,
        		dataType: "json",
        		success: function(data){
        			console.log(data);
        			$(editor).summernote('editor.insertImage',data.url);
        		}
        	});
        }
    </script>
<%@ include file="../include/footer.jsp"%>