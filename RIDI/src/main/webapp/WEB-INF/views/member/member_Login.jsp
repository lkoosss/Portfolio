<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="./images/favicon.ico">
    <title>RIDI</title>
    <link rel="stylesheet" href="./css/RIDI.css">
</head>
<body id="login_Bg">
    <header id="login_Header">
        <div class="login_Inner">
                <h1 class="login_Logo"><a href="/">RIDI</a></h1>
        </div>
    </header>
    <div class="login_Form_Inner">
        <form method="POST" action="MemberLogin.do">
            <div class="login_Input">
                <input type="text" name="id" class="login_Id" placeholder="아이디">
                <input type="password" name="password" class="login_Password" placeholder="비밀번호">
                <ul class="infoFindListBox">
               		<li><a href="MemberFindIdForm.do">아이디 찾기</a></li>
               		<li><a href="MemberFindPwForm.do">비밀번호 재설정</a></li>
               	</ul>
                <input type="submit" value="로그인" class="login_Btn">
                <a href="MemberJoinForm.do" type="button" class="join_Btn">회원가입</a>
            </div>
        </form>
    </div>
</body>
</html>