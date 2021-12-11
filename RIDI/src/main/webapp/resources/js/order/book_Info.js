// 찜한 책을 카트에 담는다.
$("#dibs").on("click",function(){
	if($("#loggedMemberId").text() == ""){
		alert("로그인 후 이용하실 수 있습니다.");
		return false;
	}
	const sendData = {
		book_Name: $(".book_Tag ul li:nth-child(2)").text(),
		QTY:1,
		price: $("#bookDtoPrice").text(),
		order_Person:$("#loggedMemberId").text(),
		shipping_Address:$("#loggedMemberAddress").text(),
		shipping_Stage:"찜한 상태",
		seller:"RIDI",
		payCheck: "NOPAY",
		book_Image: $("#bookDtoImage").text(),
		book_No: $("#bookDtoBookNo").text(),
		shipping_Fee:$("#bookDtoShippingPrice").text()
	}

	$.ajax({
		url:"PutInShoppingCart.do",
		type:"POST",
		data:sendData,
		success:function(result){
			alert("카트에 정상적으로 담겼습니다.");
		}
	})
})

// 구매할 책을 처리하고 결제페이지로 넘어간다.
function bookPay(){
	if($("#loggedMemberId").text() == ""){
		alert("로그인 후 이용하실 수 있습니다.");
		return false;
	}
	const sendData = {
		book_Name: $(".book_Tag ul li:nth-child(2)").text(),
		QTY:1,
		price: $("#bookDtoPrice").text(),
		order_Person:$("#loggedMemberId").text(),
		shipping_Address:$("#loggedMemberAddress").text(),
		shipping_Stage:"결제 대기중",
		seller:"RIDI",
		payCheck: "NOPAY",
		book_Image: $("#bookDtoImage").text(),
		book_No: $("#bookDtoBookNo").text(),
		shipping_Fee:$("#bookDtoShippingPrice").text()
	}
	$.ajax({
		url:"PutInShoppingCart.do",
		type:"POST",
		data:sendData,
		error:function(result){
			console.log(result);
		}
	})
}