//주문 예정인 주문상품을 화면에 출력한다.
getOrderList();
function getOrderList() {
	const sendData = {
		order_Person: $("#loggedMemberId").text(),
		payCheck: "NOPAY"
	}
	$.ajax({
		url: "getOrdersList.do",
		type: "POST",
		data: sendData,
		success: function(result) {
			const orderList = result.orderList;
			$.each(orderList, function(i, item) {
				let image = item.book_Image.replace("/RIDI","");
				$(".order_Book_Info table").append(`<tr class="orderList" data-no=${item.order_Group_No}>
		                                <td>
		                                    <div>
		                                        <div>
			                                        <a href="BookInfo.do?no=${item.book_No}"><img src="${image}" alt=""></a>
			                                        <a href="BookInfo.do?no=${item.book_No}">${item.book_Name}</a>
												</div>
												<a href="#" class="orderDeleteBtn" data-no="${item.no}"><i class="fas fa-trash-alt"></i></a>
												<p>${item.shipping_Stage}</p>
		                                    </div>
		                                </td>
		                                <td><span class="bookPrice">${Number(item.price).toLocaleString()}원</span></td>
										<td><span class="shippingFee">${Number(item.shipping_Fee).toLocaleString()}원</span></td>
										<td><span>${item.qty}개</span></td>
		                            </tr>`);
			})
			calPriceSum();
		}
	})
}

// 결제완료한 주문상품을 출력한다.
getPayOrderList()
function getPayOrderList() {
	const sendData = {
		order_Person: $("#loggedMemberId").text(),
	}
	$.ajax({
		url: "getPayOrderList.do",
		type: "POST",
		data: sendData,
		success: function(result) {
			const orderList = result.orderList;
			let beforeOrderGruopNo = null;
			let nowOrderGroupNo = null;
			$.each(orderList, function(i, item) {
				nowOrderGroupNo = item.order_Group_No;
				let image = item.book_Image.replace("/RIDI","");
				$(".pay_Order_Book_Info table").append(`<tr class="orderList test${item.order_Group_No}" data-no=${item.order_Group_No}>
		                                <td>
		                                    <div>
												<div>
			                                        <a href="BookInfo.do?no=${item.book_No}"><img src="${image}" alt=""></a>
			                                        <a href="BookInfo.do?no=${item.book_No}">${item.book_Name}</a>
												</div>
												<p>${item.shipping_Stage}</p>
		                                    </div>
		                                </td>
		                                <td><span class="payBookPrice">${Number(item.price).toLocaleString()}원</span></td>
										<td><span class="payBookshippingFee">${Number(item.shipping_Fee).toLocaleString()}원</span></td>
										<td><span>${item.qty}개</span></td>
		                            </tr>`);
				if(beforeOrderGruopNo != nowOrderGroupNo && beforeOrderGruopNo != null){
					$(`.test${item.order_Group_No}`).addClass("borderLine");
				}
				beforeOrderGruopNo = nowOrderGroupNo;
			})
		}
	})
}

// 주문한 예정인 상품의 가격 총합을 계산한다.
function calPriceSum() {
	let bookPriceSum = 0;
	let shippingFeeSum = 0;
	$(".bookPrice").each(function() {
		let bookPrice = Number($(this).text().slice(0, -1).replace(",", ""));
		bookPriceSum = bookPriceSum + bookPrice;
	})
	$(".shippingFee").each(function() {
		let shippingFee = Number($(this).text().slice(0, -1).replace(",", ""));
		shippingFeeSum = shippingFeeSum + shippingFee;
	})
	$("#bookPriceSum").text(`${Number(bookPriceSum).toLocaleString()}원`);
	$("#shippingFeeSum").text(`${Number(shippingFeeSum).toLocaleString()}원`);
	$("#totalPirceSum").text(`${Number(bookPriceSum + shippingFeeSum).toLocaleString()}원`);
}


//  다음 카카오 주소 API를 호출한다.
$("#btnZip").on("click", function() {
	new daum.Postcode({
		oncomplete: function(data) {
			$("#zipcode").val(data.zonecode);
			$("#address01").val(data.address);

		}
	}).open();
	return false;
});

// 결제를 진행한다.
$(".order_Btn").on("click", function() {
	let order_Group_No = 0;
	if (confirm(`최종 결제 금액만큼 캐쉬가 차감됩니다.\n결제를 진행하시겠습니까?`) == true) {
		$.ajax({
			url: "GetOrderGroupNo.do",
			type: "POST",
			success: function(result) {
				order_Group_No = result;
			},
			complete: function() {
				let sendData = {
					order_Person: $("#loggedMemberId").text(),
					order_Group_No: order_Group_No
				}
				$.ajax({
					url: "SetOrderGroupNo.do",
					type: "POST",
					data: sendData,
					success: function(result) {
						if (result > 0) {
							const sendData2 = {
								minusCash: $("#totalPirceSum").text().slice(0, -1).replace(",", ""),
								id: $("#loggedMemberId").text()
							}
							$.ajax({
								url: "minusCash.do",
								type: "POST",
								data: sendData2,
								success: function(result) {
									if (result > 0) {
										alert("결제 완료되었습니다.")
										window.location.reload();
									}
								}
							})

						}

					}
				})
			}
		})
	}
})

// 주문예정인 상품을 삭제한다.
$(".order_Book_Info table").on("click",".orderDeleteBtn",function(){
	const orderListRow = $(this).parent().parent().parent();
	const sendData = {
		no:$(this).data("no"),
		order_Person:$("#loggedMemberId").text()
	}
	$.ajax({
		url:"DeleteShoppingCart.do",
		type:"POST",
		data:sendData,
		success:function(result){
			if(result > 0){
				orderListRow.remove();
				calPriceSum();
			}
		}
	})
	return false;
})

