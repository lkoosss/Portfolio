$(".qnaListRow").each(function(i,item){
	let qnaListRow = $(this).find("a");
	let qnaListRowValue = qnaListRow.text();
	let sendData = {
		boardId : $(this).data("no")
	}
	$.ajax({
		url:"GetReplyCount.do",
		type:"POST",
		data:sendData,
		success:function(result){
			if(result > 0){
				qnaListRow.text(`${qnaListRowValue} (${result})`);				
			}
		}
	})
})