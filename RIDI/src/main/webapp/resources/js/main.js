let sendNo;
let clickedItem;
let plusNum;


/* 메인 슬라이더 */
$(document).ready(function(){
	$.ajax({
		type : 'GET',
		url:"BookJsonSliderList.do",
		dataType : 'json',
		success:function(resultData){
			//console.log(resultData.bookList);
			const bookList = resultData.bookList;
			$(".main_slider").append(`<ul class="list"></ul>`);
			$.each(bookList, function(i, item){
				let image = item.book_Image.replace("/RIDI","");
				$(".main_slider .list").append(`	<li>	
														<a href="#">
															<img src="${image}">
														</a>
													</li>
											`);
			});
			$(".main_slider").removeClass("slick-initialized slick-slider");
			
			$(".main_slider .list").slick({
	            slidesToShow: 1,
                slidesToScroll: 1,
                infinite : true,
                autoplay: true,
                autoplaySpeed: 1000,
                arrows: false,
                dots: true
	         });
		}
	});
 }); 
//오성식 추가
//베스트 셀러를 출력한다.
$(document).ready(function(){
	$.ajax({
		type:"GET",
		url:"BestSellerJsonList.do",
		dataType:"json",
		success:function(result){
			const bestSellerList = result.bestSellerList;
			$.each(bestSellerList,function(i,item){
				let image = item.book_Image.replace("/RIDI","");
				$(".grid").append(`<li class="img_Box${i+1}">
                         <a href="BookInfo.do?no=${item.no}">
                             <div>
                                 <img src="${image}" alt="">
                             </div>
                         </a>
                         <div>
                             <h4>${i+1}</h4>
                             <div>
                                 <a href="BookInfo.do?no=${item.no}">${item.book_Name}</a>
                                 <span>${item.author}</span>
                                 <span></span>
                             </div>
                         </div>
                     </li>`);
				for(var x=1; x<=5; x++){
					if(x<=`${item.star_Rating}`){
						$(`.grid .img_Box${i+1} > div > div span:nth-child(3)`).append("★");
						$(`.grid .img_Box${i+1} > div > div span:nth-child(3)`).attr("style","font-size:20px; color:gold;");
					} else {
						$(`.grid .img_Box${i+1} > div > div span:nth-child(3)`).append("☆");
						$(`.grid .img_Box${i+1} > div > div span:nth-child(3)`).attr("style","font-size:20px; color:gold;");
					}
				}		
			});
		},
		error:function(){
			alert("실패함");
		}
	})
});

/* 신작 */

$(document).ready(function(){
	$.ajax({
		type : 'GET',
		url:"NewBookJsonList.do",
		dataType : 'json',
		success:function(resultData){
			const newBookList = resultData.newBookList;
			//$(".newBook_Slide").append(`<div class="newBookList"></div>`);
			$.each(newBookList, function(i, item){
				let image = item.book_Image.replace("/RIDI","");
				$(".newBook_Slide").append(`
													<div class="newBookList">
														<a href="BookInfo.do?no=${item.no}">
															<img src="${image}">
															<div class="new_Book_Line">
																<span>${item.book_Name}</span>
																<span>${item.author}</span>
															</div>
														</a>
													</div>
											`);
			});
			 $(".newBook_Slide").removeClass("slick-initialized slick-slider");
			
	         $(".newBook_Slide").slick({
	            dots: false,
                infinite: true,
                speed: 300,
                slidesToShow: 6,
                slidesToScroll: 6,
                arrows: true
	         });	
		}
	});	
	
}); 

/* 조회수 많은 순으로 출력 */

$.ajax({
		type : 'GET',
		url:"PopBookJsonList.do",
		dataType : 'json',
		success:function(resultData){
			const popBookList = resultData.popBookList;
			//console.log(popBookList);
			$.each(popBookList, function(i, item){
				let image = item.book_Image.replace("/RIDI","");
				$(".Popgrid").append(`	
									<li class="img_Box${i+1}">
				                         <a href="BookInfo.do?no=${item.no}">
				                             <div>
				                                 <img src="${image}">
				                             </div>
				                         </a>
				                         <div>
				                             <h4>${i+1}</h4>
				                             <div>
				                                 <a href="BookInfo.do?no=${item.no}">${item.book_Name}</a>
				                                 <span>${item.author}</span>
				                             </div>
				                         </div>
				                     </li>`
									);
			});
			
		}
	});



/* 재태크페이지 메인 베스트 슬라이더 출력(미완) */
$(document).ready(function(){
	$.ajax({
		type : 'GET',
		url:"MoneyBestBookJsonList.do",
		dataType : 'json',
		success:function(resultData){
			const moneyBestBookList = resultData.moneyBestBookList;
			$(".best_slider").append(`<ul class="moneyList"></ul>`);
			$.each(moneyBestBookList, function(i, item){
				let image = item.book_Image.replace("/RIDI","");
				$(".best_slider .moneyList").append(`	<li>	
														<a href="#">
															<img src="${image}">
														</a>
													</li>
											`);
			});
			$(".best_slider").removeClass("slick-initialized slick-slider");
			
			$(".best_slider .moneyList").slick({
	            slidesToShow: 1,
                slidesToScroll: 1,
                infinite : true,
                autoplay: true,
                autoplaySpeed: 1000,
                arrows: false,
                dots: true
	         });
		}
	});
 }); 
/* 현재 시간 출력 */
let now = new Date();
const hour = now.getHours();
const minutes = now.getMinutes();
let time = hour + "시 " + minutes + "분";
//console.log(time);

/* 재태크페이지 지금시간페이지 출력(미완) */
$.ajax({
		type : 'GET',
		url:"MoneyTimeBookJsonList.do",
		dataType : 'json',
		success:function(resultData){
			const moneyTimeBookList = resultData.moneyTimeBookList;
			$(".time").append(time);
			$.each(moneyTimeBookList, function(i, item){
				let image = item.book_Image.replace("/RIDI","");
				$(".gridMoney").append(`	
									<li class="img_Box${i+1}">
				                         <a href="BookInfo.do?no=${item.no}">
				                             <div>
				                                 <img src="${image}">
				                             </div>
				                         </a>
				                         <div>
				                             <h4>${i+1}</h4>
				                             <div>
				                                 <a href="BookInfo.do?no=${item.no}">${item.book_Name}</a>
				                                 <span>${item.author}</span>
				                             </div>
				                         </div>
				                     </li>`
									);
			});
			
		}
	});

/* 재태크페이지 리디 추천 슬라이더 출력(미완) */

$(document).ready(function(){
	$.ajax({
		type : 'GET',
		url:"MoneyRecomBookJsonList.do",
		dataType : 'json',
		success:function(resultData){
			const moneyRecomBookList = resultData.moneyRecomBookList;
			$.each(moneyRecomBookList, function(i, item){
				let image = item.book_Image.replace("/RIDI","");
				$(".recomBook_Slide").append(`
													<div class="recomBookList">
														<a href="BookInfo.do?no=${item.no}">
															<img src="${image}">
															<div class="recom_Book_Line">
																<span>${item.book_Name}</span>
																<span>${item.author}</span>
															</div>
														</a>
													</div>
											`);
			});
			 $(".recomBook_Slide").removeClass("slick-initialized slick-slider");
			
	         $(".recomBook_Slide").slick({
	            dots: false,
                infinite: true,
                speed: 300,
                slidesToShow: 6,
                slidesToScroll: 6,
                arrows: true
	         });	
		}
	});	
	
}); 

/* 만화 페이지 메인 베스트 슬라이더 출력 */
$(document).ready(function(){
	$.ajax({
		type : 'GET',
		url:"ComicBestBookJsonList.do",
		dataType : 'json',
		success:function(resultData){
			const comicBestBookList = resultData.comicBestBookList;
			$(".best_slider_Comic").append(`<ul class="comicList"></ul>`);
			$.each(comicBestBookList, function(i, item){
				let image = item.book_Image.replace("/RIDI","");
				$(".best_slider_Comic .comicList").append(`	<li>	
														<a href="#">
															<img src="${image}">
														</a>
													</li>
											`);
			});
			$(".best_slider_Comic").removeClass("slick-initialized slick-slider");
			
			$(".best_slider_Comic .comicList").slick({
	            slidesToShow: 1,
                slidesToScroll: 1,
                infinite : true,
                autoplay: true,
                autoplaySpeed: 1000,
                arrows: false,
                dots: true
	         });
		}
	});
 }); 

/* 만화 페이지 지금시간페이지 출력 */
$.ajax({
		type : 'GET',
		url:"ComicTimeBookJsonList.do",
		dataType : 'json',
		success:function(resultData){
			const comicTimeBookList = resultData.comicTimeBookList;
			$(".comic_Time").append(time);
			$.each(comicTimeBookList, function(i, item){
				let image = item.book_Image.replace("/RIDI","");
				$(".gridComic").append(`	
									<li class="img_Box${i+1}">
				                         <a href="BookInfo.do?no=${item.no}">
				                             <div>
				                                 <img src="${image}">
				                             </div>
				                         </a>
				                         <div>
				                             <h4>${i+1}</h4>
				                             <div>
				                                 <a href="BookInfo.do?no=${item.no}">${item.book_Name}</a>
				                                 <span>${item.author}</span>
				                             </div>
				                         </div>
				                     </li>`
									);
			});
			
		}
	});

/* 만화 페이지 리디 추천 슬라이더 출력 */
$(document).ready(function(){
	$.ajax({
		type : 'GET',
		url:"ComicRecomBookJsonList.do",
		dataType : 'json',
		success:function(resultData){
			const comicRecomBookList = resultData.comicRecomBookList;
			$.each(comicRecomBookList, function(i, item){
				let image = item.book_Image.replace("/RIDI","");
				$(".comic_RecomBook_Slide").append(`
													<div class="recomBookList">
														<a href="BookInfo.do?no=${item.no}">
															<img src="${image}">
															<div class="recom_Book_Line">
																<span>${item.book_Name}</span>
																<span>${item.author}</span>
															</div>
														</a>
													</div>
											`);
			});
			 $(".comic_RecomBook_Slide").removeClass("slick-initialized slick-slider");
			
	         $(".comic_RecomBook_Slide").slick({
	            dots: false,
                infinite: true,
                speed: 300,
                slidesToShow: 6,
                slidesToScroll: 6,
                arrows: true
	         });	
		}
	});	
	
}); 

/* 에세이 페이지 베스트셀러 출력 */
$(document).ready(function(){
	$.ajax({
		type : 'GET',
		url:"EssayBestBookJsonList.do",
		dataType : 'json',
		success:function(resultData){
			const essayBestBookList = resultData.essayBestBookList;
			$(".best_slider_Essay").append(`<ul class="essayList"></ul>`);
			$.each(essayBestBookList, function(i, item){
				let image = item.book_Image.replace("/RIDI","");
				$(".best_slider_Essay .essayList").append(`	<li>	
														<a href="#">
															<img src="${image}">
														</a>
													</li>
											`);
			});
			$(".best_slider_Essay").removeClass("slick-initialized slick-slider");
			
			$(".best_slider_Essay .essayList").slick({
	            slidesToShow: 1,
                slidesToScroll: 1,
                infinite : true,
                autoplay: true,
                autoplaySpeed: 1000,
                arrows: false,
                dots: true
	         });
		}
	});
 }); 

/* 에세이 페이지 지금시간페이지 출력 */
$.ajax({
		type : 'GET',
		url:"EssayTimeBookJsonList.do",
		dataType : 'json',
		success:function(resultData){
			const essayTimeBookList = resultData.essayTimeBookList;
			$(".essay_Time").append(`<span>${time}</span>`);
			$.each(essayTimeBookList, function(i, item){
				let image = item.book_Image.replace("/RIDI","");
				$(".gridEssay").append(`	
									<li class="img_Box${i+1}">
				                         <a href="BookInfo.do?no=${item.no}">
				                             <div>
				                                 <img src="${image}">
				                             </div>
				                         </a>
				                         <div>
				                             <h4>${i+1}</h4>
				                             <div>
				                                 <a href="BookInfo.do?no=${item.no}">${item.book_Name}</a>
				                                 <span>${item.author}</span>
				                             </div>
				                         </div>
				                     </li>`
									);
			});
			
		}
	});

/* 에세이 페이지 리디 추천 슬라이더 출력 */
$(document).ready(function(){
	$.ajax({
		type : 'GET',
		url:"EssayRecomBookJsonList.do",
		dataType : 'json',
		success:function(resultData){
			const essayRecomBookList = resultData.essayRecomBookList;
			//console.log(essayRecomBookList);
			$.each(essayRecomBookList, function(i, item){
				let image = item.book_Image.replace("/RIDI","");
				$(".Essay_RecomBook_Slide").append(`
													<div class="recomBookList">
														<a href="BookInfo.do?no=${item.no}">
															<img src="${image}">
															<div class="recom_Book_Line">
																<span>${item.book_Name}</span>
																<span>${item.author}</span>
															</div>
														</a>
													</div>
											`);
			});
			 $(".Essay_RecomBook_Slide").removeClass("slick-initialized slick-slider");
			
	         $(".Essay_RecomBook_Slide").slick({
	            dots: false,
                infinite: true,
                speed: 300,
                slidesToShow: 6,
                slidesToScroll: 6,
                arrows: true
	         });	
		}
	});	
	
}); 



