<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="./js/jquery-3.6.0.min.js" defer></script>
    <script src="./js/member/member_FindPw.js" defer></script>
    <link rel="shortcut icon" href="./images/favicon.ico">
    <title>RIDI</title>
    <link rel="stylesheet" href="./css/RIDI.css">
</head>
<body id=login_Bg>
    <header id="find_Pw_Header">
        <div class="find_Pw_Inner">
                <h1 class="find_Pw_Logo"><a href="/">RIDI</a></h1>
        </div>
    </header>
    <div class="find_Pw_Inner">
        <form method="POST" action="MemberLoginForm.do">
            <div class="find_Pw_Input">
            	<h3 class="find_Info_Subject">비밀번호 재설정</h3>
                <input type="text" name="id" class="find_Id" placeholder="아이디">
                <input type="text" name="email" class="find_Email" placeholder="이메일 주소">
               	<div class="findIdResultBox">
               	</div>
                <input type="button" value="찾기" class="find_Pw_Btn" onclick="return findPw()">
            </div>
        </form>
    </div>
</body>
</html>