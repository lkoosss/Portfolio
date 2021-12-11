<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
    <div id="contents">
        <h2 class="contentsTitle">글쓰기</h2>
        <form action="./BoardInsert.do" class="form" name="writeContents" method="POST">
            <table>
                <colgroup>
                    <col style="width:50px;">
                    <col style="width:200px;">
                </colgroup>
                <tbody>
               		<tr>
                        <th>ID</th>
                        <td class="left"><input type="text" name=userId readonly value="${sessionScope.loggedMemberDto.id }"></td>
                    </tr>
                    <tr>
                        <th>Name</th>
                        <td class="left"><input type="text" name=userName readonly value="${sessionScope.loggedMemberDto.name }"></td>
                    </tr>
                    <tr>
                        <th>Email</th>
                        <td class="left"><input type="text" name="userEmail" readonly value="${sessionScope.loggedMemberDto.email }"></td>
                    </tr>
                    <tr>
                        <th>Subject</th>
                        <td class="left"><input type="text" name="subject"></td>
                    </tr>
                    <tr>
                        <th>contents</th>
                        <div class="container">
	                        <td class="left"><textarea class="summernote" name="contents" cols="30" rows="10"></textarea></td>
                        </div>
                    </tr>
                </tbody>
            </table>
            <div class="btns">
                <input type="submit" value="확인" onClick="return checkInfo();">
                <a href="./GoBoardListViewPage.do">취소</a>
            </div>
        </form>
    </div>
    <script>
        function checkInfo(){
            if(document.writeContents.subject.value == ""){
                alert("제목을 입력하세요");
                document.writeContents.subject.focus();
                return false;
            } else if(document.writeContents.contents.value == ""){
                alert("글내용을 입력하세요");
                document.writeContents.contents.focus();
                return false;
            } else{
                return true;
            }
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
        			$(editor).summernote('editor.insertImage',data.url);
        		}
        	});
        }
    </script>
<%@ include file="../include/footer.jsp"%>