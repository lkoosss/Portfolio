<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/RIDI.css">
    <link rel="shortcut icon" href="./images/favicon.ico">
    <script src="js/jquery-3.6.0.min.js"></script>
    <title>Book</title>
</head>
<body id="book_bg">
    <header id="book_Form_Header">
        <div class="book_fFrm_Header_Inner">
                <h1 class="book_form_Logo"><a href="/">RIDI</a></h1>
        </div>
    </header>
    <div id="content_Book">
        <div id="book_Form_Inner">
          <form method="POST" action="BookWrite.do" class="book_Form" id="book" name="signUp" enctype="multipart/form-data">
            <div class="book_Form_Input">
                <div class="book_Form_Category">
                    <span>category</span>
                    <select name="category">
                        <option value="재태크">재태크</option>
                        <option value="만화">만화</option>
                        <option value="에세이">에세이</option>
                        <option value="mainadv">메인</option>
                    </select>
                </div>
                <input type="text" name="book_Name" placeholder="책 제목을 입력하세요">
                <input type="text" name="author" placeholder="저자를 입력하세요">
                <input type="date" name="publication_Date" placeholder="출간일을 입력하세요">
                <input type="number" name="pages" placeholder="쪽수를 입력하세요">
                <input type="number" name="stock" placeholder="재고수를 입력하세요">
                <input type="number" name="price" placeholder="가격을 입력하세요">
                <input type="number" name="shipping_Price" placeholder="배송비를 입력하세요">
                <input type="text" name="estimated_Time" placeholder="배송예상시간을 입력하세요">
                <textarea name="book_Intro" id="" cols="30" rows="10" placeholder="책 내용을 입력하세요" style="resize: none;"></textarea>
                <div class="book_Form_File">
                    <span>이미지파일</span><input type="file" name="multipartFile" id="book_Img">
                </div>
            </form>
            <div class="bookBtns">
                <input type="submit" value="확인" id="bookSign_Up">
                <input type="reset" value="취소" id="cancel" onclick="window.location.href='/'")>
            </div>
            </div>
        </div>
    </div>
</body>
</html>
