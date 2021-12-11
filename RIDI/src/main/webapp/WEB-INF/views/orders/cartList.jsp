<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
	<div class="cartList_wrapper">   
            <div class="cartList_inner">
                <div class="cartList_container">
                    <div class="cartList_left">
                        <div class="cartList_top">
                            <div><i class="fas fa-shopping-cart"></i><span>장바구니</span></div>
                        </div>
                        <div class="cartList_middle">
                            <div class="cartList_checkbox">
                                <div><input type="checkbox"></div>
                                <div><span>전체선택</span></div>
                            </div>
                        </div>
                        <!-- 
                        <ul class="cartList_btm">
                            <li>
                                <div><input id="cartCheckBox${i}" type="checkbox" onclick="calCheckedCartList()"></div>
                            </li>
                            <li>
                                <div><img src="${item.book_Image}"></div>
                            </li>
                            <li>
                                <div><span>${item.book_Name}</span></div>
                                <div><span>${item.seller}</span></div>
                                <div><button onclick="deleteCartItem(${item.no})">삭제</button></div>
                            </li>
                            <li>
                                <div class="bookPriceBox"><span class="bookPrice" id="bookPrice${i}">${item.price}원</span></div>
                            </li>
                        </ul>
                         -->
                    </div>
                    <div class="cartList_right">
                        <div class="cartList_select">
                            <div class="cartList_sum">
                                <div><span>0권을 선택하셨습니다.</span></div>
                                <div><span>총 상품 금액</span></div>
                                <div><span>0원</span></div>
                                <div class="select_btm">
                                    <div><span>합계</span></div>
                                    <div><span>0원</span></div>
                                </div>
                            </div>
                            <div class="cartList_selectBtn">
                                <div><button id="selectedItemPayBtn">선택구매</button></div>
                            </div>
                        </div>
                    </div><!--cartList_right-->
                </div> <!--cartList_container-->
        </div>   <!--cartList_inner-->
</div> <!--cartList_wrapper-->
<link rel="stylesheet" property="stylesheet" href="./css/cartList.css"></link>
<!-- 오성식 추가(21.10.26) -->
<script src="./js/order/cartList.js" defer></script>
<div style="display: none" id="loggedMemberId">${sessionScope.loggedMember.id }</div>
<%@ include file="../include/footer.jsp"%>