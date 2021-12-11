<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../include/header.jsp"%>

<div id="content" style="height: 100%;">
        <div id="book_Box">
            <h2>수정페이지</h2>
            <form method="POST" action="BookModify.do" class="book_Form" id="book" name="signUp" enctype="multipart/form-data">
                <table>
                    <tbody>
                        <tr>
                            <th>책제목</th>
                            <td>
                                <input type="text" name="book_Name" value="${ param.book_Name }">
                            </td>
                        </tr>
                        <tr>
                            <th>가격</th>
                            <td>
                                <input type="number" name="price" placeholder="가격을 입력하세요">
                            </td>
                        </tr>
                        <tr>
                            <th>재고수</th>
                            <td>
                                <input type="number" name="stock" placeholder="재고수를 입력하세요">
                            </td>
                        </tr>
                        <tr>
                            <th>배송예상시간</th>
                            <td>
                                <input type="text" name="estimated_Time" placeholder="배송예상시간을 입력하세요">
                            </td>
                        </tr>
                        <tr>
                            <th>배송비</th>
                            <td>
                                <input type="number" name="shipping_Price" placeholder="배송비를 입력하세요">
                            </td>
                        </tr>
                        <tr>
                            <th>카테고리</th>
                            <td>
                                <select name="category">
                                    <option value="money">재태크</option>
                                    <option value="comic">만화</option>
                                    <option value="essay">에세이</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>쪽수</th>
                            <td>
                                <input type="number" name="pages" placeholder="쪽수를 입력하세요">
                            </td>
                        </tr>
                        <tr>
                            <th>저자</th>
                            <td>
                                <input type="text" name="author" placeholder="저자를 입력하세요">
                            </td>
                        </tr>
                        <tr>
                            <th>책 소개</th>
                            <td>
                                <textarea name="book_Intro" id="" cols="30" rows="10" placeholder="책 내용을 입력하세요" id="summernote"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <th>이미지파일</th>
                            <td>
                                <input type="file" name="multipartFile" id="book_Img">
                            </td>
                        </tr>
                    </tbody>
                </table>
                <div class="btns">
              		<input type="hidden" name="no" value="${param.no}">
                    <input type="submit" value="확인" id="bookSign_Up">
                    <input type="reset" value="취소" id="cancel">
                </div>
            </form>
        </div>
    </div>


<%@ include file="../include/footer.jsp"%>