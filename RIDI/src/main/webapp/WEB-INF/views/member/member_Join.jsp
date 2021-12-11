<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js" defer></script>
    <script src="./js/jquery-3.6.0.min.js" defer></script>
    <script src="./js/member/member_Join.js" defer></script>
    <link rel="shortcut icon" href="./images/favicon.ico">
    <title>RIDI</title>
    <link rel="stylesheet" href="./css/RIDI.css">
</head>
<body id="join_Bg">
    <header id="join_Header">
        <div class="join_Inner">
                <h1 class="join_Logo"><a href="/">RIDI</a></h1>
        </div>
    </header>
    <div class="join_Form_Inner">
        <form action="MemberJoin.do" method="POST" name="signUp" id="join" class="join_Form" enctype="multipart/form-data">
            <div class="join_Input">
                <input type="text" name="id" class="login_Id" placeholder="아이디" id="id">
                <p id="idCheckResult"></p>
				<input type="button" name="idDuplicateCheck" value="ID 중복 체크" id="idDuplicateCheck" class="idDuplicateCheckBox" onClick="checkIdDuplicate()">
                <input type="password" name="password" placeholder="비밀번호" id="userPw" class="join_Password">
                <input type="password" name="password02" placeholder="비밀번호 확인" id="userPw02" class="join_Password" onkeyup="checkPw()">
                <p id="pwCheckResult"></p>
                <input type="text" name="name" placeholder="이름" class="join_Name" id="name">
                <div id="join_Line">
                    <div class="rrn_Container">
                        <input type="text" name="rrn_First" placeholder="주민번호 앞자리" class="join_Rrn" id="rrn_First" maxlength="6">
                        <p> - </p> 
                        <input type="text" name="rrn_Last" placeholder="주민번호 뒷자리" class="join_Rrn" id="rrn_Last" maxlength="7">
                    </div>
                    <div class="join_Gender">
                        <label for="" class="gender_Box">
                            <input type="radio" name="gender" value="man" checked class="join_Gender">
                            <span>남</span>
                        </label>
                        <label for="" class="gender_Box">
                            <input type="radio" name="gender" value="woman" class="join_Gender">
                            <span>여</span>
                        </label>
                    </div>
                </div>
                <div class="zipcode_Container">
                    <input type="number" name="zipcode" class="zipcode_Box" id="zipcode" placeholder="우편번호" readonly>
                    <input type="button" name="zipCode_Btn" value="우편번호 검색" id="btnZip" class="zipcode_Btn" onClick="findAddr()">
                </div>
                <div class="address_Container">
                    <div class="address01_Container">
                        <input type="text" name="address01" id="address01" placeholder="기본주소" class="join_box1" readonly>
                    </div>
                    <div class="address02_Container">
                        <input type="text" name="address02" id="address02" placeholder="나머지주소" class="join_box2">
                    </div>
                </div>
                <div class="join_Ph_Box">
                    <select name="hp_First" class="join_Ph">
                        <option value="010">010</option>
                        <option value="011">011</option>
                        <option value="017">017</option>
                    </select><p>-</p><input type="type" name="hp_Middle" class="short" placeholder="번호 앞자리" id="hp_Middle" maxlength="4">
                    <p>-</p><input type="type" name="hp_Last" class="short" placeholder="번호 뒷자리" id="hp_Last" maxlength="4">
                </div>
                <input type="text" name="email" placeholder="이메일" class="join_Email" id="email">
                <input type="text" name="emailCheck" placeholder="이메일 인증번호" class="join_box" id="emailCheck">
				<input type="button" name="emailCheckBtn" value="메일 인증번호 발송" id="btnEmail" class="emailCheckBtn" onclick="generateEmailAuthNum()">
                <input type="submit" value="회원가입 완료" class="join_Btn_Box" onclick="return checkEmptyInput()")>
            </div>
        </form>
    </div>
</body>
</html>