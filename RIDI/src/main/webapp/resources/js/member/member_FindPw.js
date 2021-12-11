 function findPw(){
	    	// ID,Email의 공백을 체크한다.
	    	if($.trim($(".find_Id").val()) == ""){
	    		alert("아이디를 입력해주세요.");
	    		$(".find_Id").focus();
	    		return false;
	    	} else if($.trim($(".find_Email").val()) == ""){
				alert("메일정보를 입력해주세요.");
				$(".find_Email").focus();
				return false;
			}
	    	
	    	// 이메일 형식이 맞는지 확인한다.
			var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
			if(exptext.test($(".find_Email").val()) == false){
				alert("이메일 형식이 올바르지 않습니다.");
				return false;
			}
	    	const sendData = {
				id: $(".find_Id").val(),
				email: $(".find_Email").val()
			}
			$.ajax({
				url:"MemberFindPw.do",
				data: sendData,
				type:"POST",
				success:function(result){
					if(result.result == 1){
						alert("해당 메일로 임시 패스워드를 전송하였습니다. 확인해주세요");
						$(".find_Pw_Btn").remove();
						$(".find_Pw_Input").append('<input type="submit" value="로그인" class="go_LoginForm_Btn">');
					} else{
						alert("일치하는 회원 정보가 없습니다.");
					}
				}
			})
	    	
		}