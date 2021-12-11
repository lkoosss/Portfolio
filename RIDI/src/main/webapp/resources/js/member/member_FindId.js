function findId(){
			// 공백을 체크한다.
			if($.trim($(".find_Email").val()) == ""){
				alert("메일정보를 입력해주세요.");
				return false;
			}
			
			// 이메일 형식이 맞는지 확인한다.
			var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
			if(exptext.test($(".find_Email").val()) == false){
				alert("이메일 형식이 올바르지 않습니다.");
				return false;
			}
			
			// ajax로 조회되는 ID를 출력한다.
			sendData = {
					email: $(".find_Email").val()
			};
			$.ajax({
				url: "MemberFindId.do",
				data: sendData,
				type: "POST",
				success: function(result){
					$(".findIdResultBox").html("");
					let idList = result.idList;
					console.log(idList)
					if(idList.length == 0){
						$(".findIdResultBox").append(`<h3>해당 이메일로 가입된 ID가 <br>존재하지 않습니다.</h3>`);
					} else {
						$(".findIdResultBox").append("<h3>회원님의 아이디는 다음과 같습니다.</h3>");
						$.each(idList,function(i,item){
							$(".findIdResultBox").append(`<p id="resultId">${item.id}</p>`);
						})
						$(".findIdResultBox").append('<p id="secureInfo">개인 정보 보호를 위해 앞 두글자만 보여드립니다.</p>');
						
						$(".find_Id_Btn").remove();
						$(".find_Id_Input").append('<input type="submit" value="로그인" class="go_LoginForm_Btn">');
					}
					
				}
			})
		}