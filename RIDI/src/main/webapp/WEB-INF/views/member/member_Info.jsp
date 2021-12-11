<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
	 <div id="content">
        <div class="info_Content">
            <div class="info_Inner">
                <div class="info_Sub">
                    <div class="info_Table_Line">
                        <h2 class="info_Table">마이리디</h2>
                    </div>
                    <ul class="info_List">
                        <li><a href="MemberHomeForm.do">마이리디홈</a></li>
                        <li><a href="QnaList.do">문의하기</a></li>
                        <li><a href="MemberInfoModifyForm.do">정보변경</a></li>
                    </ul>
                </div>
                <div class="info">
                    <div class="info_Box">
                        <ul class="my_info">
                            <li>${sessionScope.loggedMember.id }</li>
                            <li>${sessionScope.loggedMember.email }</li>
                            <li>${sessionScope.loggedMember.name }</li>
                        </ul>
                        <ul class="my_cash">
                        	<li><i class="fas fa-wallet"></i></li>
                        	<li>리디캐시</li>
                        	<li><fmt:formatNumber value="${sessionScope.loggedMember.cash }" pattern="#,###"/><span>원</span></li>
                        	<li><a href="#">리디캐시 충전</a></li>
                        </ul>
                    </div>
                    <div class="info_Notice_Box">
                        <h3 class="info_Notice_Title">안내사항</h3>
                        <ul class="info_Notice">
                            <li>주문정보 수정은 (주문취소/배송지변경) 주문/배송 상세페이지에서 가능합니다.</li>
                            <li>배송조회는 택배사로 상품전달 후 조회 가능합니다.</li>
                            <li>주문한 상품이 품절될 경우 해당 상품은 자동 취소되며, 취소 금액은 승인 취소 또는 예치금으로 반환됩니다.</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>  
    </div>
<%@ include file="../include/footer.jsp"%>