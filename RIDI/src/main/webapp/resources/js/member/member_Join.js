	
// ID 중복을 체크한다.
function checkIdDuplicate(){
	if($.trim($("#id").val())== ""){
		alert("아이디를 입력하세요");
		$("#id").focus();
		return false;
	} 
	const sendData = {
			id : $("#id").val()
	}
	$.ajax({
		type:"POST",
		url:"idDuplicationCheck.do",
		data:sendData,
		success: function(result){
			if(result.id == $("#id").val()){
				$("#idCheckResult").text("이미 사용중인 아이디 입니다.");
			} else {
				$("#idCheckResult").text("사용가능한 아이디 입니다.");
			}
		},
		error: function(error){
			console.log(error)
		}
	})
}

// 다음 카카오 API로 zipcode와 주소를 받아온다.
function findAddr(){
	new daum.Postcode({
        oncomplete: function(data) {
        	$("#zipcode").val(data.zonecode);
        	$("#address01").val(data.address);
        }
    }).open();
    return false;	
}

// 패스워드, 확인용 패스워드가 일치하는지 검사한다.
function checkPw(){
	if($("#userPw02").val().length >= $("#userPw").val().length){
		if($("#userPw02").val() == $("#userPw").val()){
			$("#pwCheckResult").text("패스워드가 일치합니다.");
		} else {
			$("#pwCheckResult").text("패스워드가 서로 다릅니다. 확인해주세요.");
		}
	}
}

// 성별박스 체크시 색상변경, Checked 해준다.
$(".gender_Box").on("click",function(){
	$(".gender_Box").children("input").attr('checked',false);
	$(".gender_Box").attr("style","background-color:#fff");
	$(".gender_Box").children("span").attr("style","color:#738096");
	$(this).children("input").attr('checked',true);
	$(this).attr("style","background-color:#1f8ce6;");
	$(this).children("span").attr('style','color:#fff');
})

// 유저정보 입력란이 비어있는지 확인한다.
// 이메일 인증 진행을 확인하고 인증번호를 체크한다.
// 주민번호, 핸드폰 번호 자리를 체크한다.
function checkEmptyInput(){
	if($.trim($("#id").val()) == ""){
		alert("아이디를 입력해주세요");
		$("#id").focus();
		return false;
	} else if($.trim($("#userPw").val()) == ""){
		alert("패스워드를 입력해주세요");
		$("#userPw").focus();
		return false;
	} else if($.trim($("#userPw02").val()) == ""){
		alert("확인용 패스워드를 입력해주세요");
		$("#userPw02").focus();
		return false;
	} else if($.trim($("#name").val()) == ""){
		alert("본인의 성함을 입력해주세요");
		$("#name").focus();
		return false;
	} else if($.trim($("#rrn_First").val()) == ""){
		alert("주민번호 앞자리를 입력하세요");
		$("#rrn_First").focus();
		return false;
	} else if($.trim($("#rrn_Last").val()) == ""){
		alert("주민번호 뒷자리를 입력하세요");
		$("#rrn_Last").focus();
		return false;
	} else if($.trim($("#zipcode").val()) == ""){
		alert("주소를 입력해주세요");
		$("#zipcode").focus();
		return false;
	} else if($.trim($("#address02").val()) == ""){
		alert("나머지 주소를 입력해주세요");
		$("#address02").focus();
		return false;
	} else if($.trim($("#hp_Middle").val()) == ""){
		alert("핸드폰 중간 4자리를 입력하세요");
		$("#phoneMiddleNumber").focus();
		return false;
	} else if($.trim($("#hp_Last").val()) == ""){
		alert("핸드폰 끝 4자리를 입력하세요");
		$("#phoneLastNumber").focus();
		return false;
	} else if($.trim($("#email").val()) == ""){
		alert("이메일을 입력해주세요");
		$("#email").focus();
		return false;
	}
	
	if($("#rrn_First").val().length < 6){
		alert("주민번호 앞자리를 모두 입력하세요");
		return false;
	}
	
	if($("#rrn_Last").val().length < 7){
		alert("주민번호 뒷자리를 모두 입력하세요");
		return false;
	}
	
	if($("#hp_Middle").val().length < 4){
		alert("핸드폰 중간번호를 모두 입력하세요");
		return false;
	}
	
	if($("#hp_Last").val().length < 4){
		alert("핸드폰 끝 네자리를 모두 입력하세요.");
		return false;
	}
	
	if(emailValidationCheck() == false){return false;}
	
	if(typeof emailAuthNum == "undefined"){
		alert("이메일 인증을 진행해주세요");
		return false;
	} else{
		if(emailAuthNum == $("#emailCheck").val()){
		} else{
			alert("이메일 인증번호가 틀립니다.");
			return false;
		}
	}
}

// 이메일 형식이 맞는지 확인한다.
function emailValidationCheck(){
	var email = $("#email").val();
	var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	if(exptext.test(email) == false){
		alert("이메일 형식이 올바르지 않습니다.");
		return false;
	}
	return true;
}

// 이름박스에 한글만 입력되게함
$("#name").on("keyup",function(input){
	var inputVal = $(this).val();
	$(this).val(inputVal.replace(/[a-z0-9]|[ \[\]{}()<>?|`~!@#$%^&*-_+=,.;:\"\\]/g,""));
});

// 주민번호 앞자리에 숫자만입력, 앞번호 6자리, 뒷번호 7자리를 꼭 입력되게함
$("#rrn_First").on("keyup",function(input){
	var inputVal = $(this).val();
	$(this).val(inputVal.replace(/[^0-9]/gi,""));
});

// 주민번호에 뒷자리에 숫자만입력, 앞번호 6자리, 뒷번호 7자리를 꼭 입력되게함
$("#rrn_Last").on("keyup",function(input){
	var inputVal = $(this).val();
	$(this).val(inputVal.replace(/[^0-9]/gi,""));
});

// 핸드폰번호 중간 4자리 숫자만 입력되게
$("#hp_Middle").on("keyup",function(input){
	var inputVal = $(this).val();
	$(this).val(inputVal.replace(/[^0-9]/gi,""));
});

$("#hp_Last").on("keyup",function(){
	var inputVal = $(this).val();
	$(this).val(inputVal.replace(/[^0-9]/gi,""));
});

// 이메일 인증번호를 생성하고 유저가 입력한 메일주소로 인증번호를 전송한다.
let emailAuthNum;
function generateEmailAuthNum(){
	if($.trim($("#email").val()) == ""){
		alert("메일정보를 입력해주세요.");
		return false;
	}
	
	if(emailValidationCheck() == true){
		$.ajax({
			url:"generateEmailAuthNum.do",
			type:"post",
			data: {"email":$("#email").val()},
			success:function(result){
				emailAuthNum = result
				alert("인증메일을 발송했습니다. 메일함을 확인해주세요");
			},
			error:function(error){
				alert(error);
			}
		})
	}
}