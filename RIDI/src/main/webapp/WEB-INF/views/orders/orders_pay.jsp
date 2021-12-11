<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div id="order_Content" style="height: 100%">
        <div class="order_Inner">
            <div id="order_Form">
                <h4 class="order_Title">주문 / 결제</h4>
                <p>배송/결제 정보를 정확히 입력해 주세요.</p>
                <div class="order_Form_Inner">
                    <form action="" method="post">
                        <div class="order_Input">
                            <input type="text" name="name" value="${sessionScope.loggedMember.name }" class="order_Name" readonly>
                            <input type="text" name="email" value="${sessionScope.loggedMember.email }" class="join_Email" readonly>
                            <div class="order_Ph_Box">
                                <select name="hp" class="order_Ph">
                                    <option value="010">010</option>
                                    <option value="011">011</option>
                                    <option value="017">017</option>
                                </select><p>-</p><input type="number" name="hp_Middel" class="short" value="${ fn:substring(sessionScope.loggedMember.hp,4,8)}">
                                <p>-</p><input type="number" name="hp_Last" class="short" value="${ fn:substring(sessionScope.loggedMember.hp,9,13)}">
                            </div>
                            <input type="text" name="id" class="login_Id" value="${sessionScope.loggedMember.id }">
                            <div class="zipcode_Container">
                                <input type="number" name="zipcode" class="zipcode_Box" id="zipcode" value="${sessionScope.loggedMember.zipcode }">
                                <input type="button" name="zipCode_Btn" value="우편번호 검색" id="btnZip" class="zipcode_Btn" >
                            </div>
                            <div class="address_Container">
                                <div class="address01_Container">
                                    <input type="text" name="address01" id="address01" value="${fn:substringBefore(sessionScope.loggedMember.address,'/') }" class="order_box1">
                                </div>
                                <div class="address02_Container">
                                    <input type="text" name="address02" id="address02" value="${fn:substringAfter(sessionScope.loggedMember.address,'/') }" class="order_box2">
                                </div>
                            </div>
                        </div>
                    </form>
                    <div class="order_Book_Info">
                        <h4>주문상품</h4>
                        <table>
                            <thead>
                                <tr>
                                    <th>상품정보</th>
                                    <th>판매가</th>
                                    <th>배송비</th>
                                    <th>수량</th>
                                </tr>
                            </thead>
                            <!-- Jquery로 채운다 -->
                        </table>
                    </div>
                </div>
                <div class="pay_Order_Book_Info">
                        <h4>결제한 상품</h4>
                        <table>
                            <thead>
                                <tr>
                                    <th>상품정보</th>
                                    <th>판매가</th>
                                    <th>배송비</th>
                                    <th>주문 수량</th>
                                </tr>
                            </thead>
                            <!-- Jquery로 채운다 -->
                        </table>
                    </div>
            </div>
            <div class="order_Btn_Box">
                <div class="order_Btn_Box_Inner">
                    <ul>
                        <li>
                            <div><span>상품금액</span><span id="bookPriceSum">원</span></div>
                        </li>
                        <li>
                            <div><span>배송비</span><span id="shippingFeeSum">원</span></div>
                        </li>
                    </ul>
                    <div class="order_result_price"><div><span>최종 결제금액</span><span id="totalPirceSum">가격원</span></div></div>
                </div>
                <input type="button" value="결제하기" class="order_Btn">
                <a href="CartListForm.do" class="cart_Back">장바구니 가기</a>
            </div>
        </div>
    </div>
<script src="./js/order/orders_pay.js" defer></script>
<div style="display:none" id="loggedMemberId">${sessionScope.loggedMember.id }</div>
<%@ include file="../include/footer.jsp"%>