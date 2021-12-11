// 페이지 로딩시 리뷰 리스트를 출력함
getReviewList();
// 페이지 로딩시 책 평균 별점을 그린다.
drawStarRating();

// 평점 변수를 저장한다.
let star_Rating = 0;
$(".star-rating input").on("click",function(){
	star_Rating = $(this).val();
})

// 리뷰를 DB에 저장하고 화면에 출력한다.
// 값의 공백을 체크
function reviewWrite(writer_Id,book_No){
	if(writer_Id == ""){
		alert("로그인 후 리뷰를 등록할 수 있습니다.");
		return false;		
	} else if(star_Rating == 0){
		alert("평점을 입력하세요");
		return false;
	} else if($.trim($(".starRating_contents textarea").val()) == ""){
		alert("리뷰를 입력하세요");
		return false;
	}
	
	const sendData = {
		book_No: book_No,
		contents: $(".starRating_contents textarea").val(),
		writer_Id: writer_Id,
		star_Rating: star_Rating,
		password: "1234",
	}
	$.ajax({
		url:"ReviewWrite.do",
		type:"POST",
		data:sendData,
		success:function(result){
			if(result > 0){
				star_Rating = 0;
				$(".star-rating input").prop("checked",false);
				$(".starRating_contents textarea").val("");
				$(".bookContents_wrapper").html("");
				getReviewList();
			} else{
				alert("리뷰 등록에 실패하였습니다.");
			}
		}
	})
}


// 리뷰들을 출력한다.
function getReviewList(){
	const sendData = {
		book_No:$("#bookDtoBookNo").text()
	}
	$.ajax({
		url:"ReviewList.do",
		type:"POST",
		data:sendData,
		success:function(result){
			const reviewList = result.reviewList;
			$.each(reviewList,function(i,item){
				$(".bookContents_wrapper").append(`<li class="book_contents" id="review_no${item.no}" data-no=${item.no}></li>`);
				$(`#review_no${item.no}`).append(`<div class="review_head_info">
													<span><label class="star"></label></span>
													<p class="review_writer">${item.writer_Id}</p>
													<p class="review_date">${item.review_Date}</p>
												</div>
												<div class="review_contents">
													<p>${item.contents}</p>
												</div>`);
				if(item.writer_Id == $("#loggedMemberId").text()){
					$(`#review_no${item.no}`).append('<button class="reviewDeleteBtn">리뷰 삭제</button>');
				}
				for(var i=1; i<=5; i++){
					if(i<=`${item.star_Rating}`){
						$(`#review_no${item.no} .star`).append("★");
					} else {
						$(`#review_no${item.no} .star`).append("☆");
					}
				}
			})
		}
	})
}

//책의 평균별점을 그려준다.
function drawStarRating(){
	const starRating = $("#starRating").text();
	$("#starRating").html("");
	for(var i=1; i<=5; i++){
		if(i <= starRating){
			$("#starRating").append("★");			
		} else {
			$("#starRating").append("☆");
		}
	}
	$("#starRating").append(` <span>${starRating}</span>`);
}

// 리뷰를 삭제한다.
$(".bookContents_wrapper").on("click",".reviewDeleteBtn",function(){
	const reviewRow = $(this).parent();
	const reviewNo = reviewRow.data("no");
	const sendData = {
		no:reviewNo,
		book_No:$("#bookDtoBookNo").text()
	}
	$.ajax({
		url:"ReviewDelete.do",
		data:sendData,
		type:"POST",
		success:function(){
			reviewRow.remove();
		}
	})
})