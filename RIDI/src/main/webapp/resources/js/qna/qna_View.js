replySelectAll();




// <button class="btnDelete"><span class="material-icons">delete</span></button> 
// 댓글을 DB에 저장한다.
$(".btnReply").on("click",function(){
	const _parent = $(this).parent();
	const sendData = {
		boardId:$("#qnaNo").text(),
		reply:_parent.find("#reply").val()
	}
	$.ajax({
		url:"ReplyWrite.do",
		type:"POST",
		data:sendData,
		success:function(resultData){
			$(".replyList .list").html("");
			$("#reply").val("");
			replySelectAll();
		},
		error:function(errorMsg){
			console.log(errorMsg);
		}
	});
});

// 댓글 입력 글자수를 제한한다.
$(".replyBox textarea").on("keyup", function(e){
	const content = $(this).val();
	if(content.length > 100) {
		alert("100자까지 입력 가능합니다.");
	} else {
		$("#currentCount").text(content.length);
	}
});



// 모든 댓글을 출력한다.
function replySelectAll(){
	const sendData = {
		boardId:$("#qnaNo").text()
	}
	$.ajax({
		url:"ReplySelectAll.do",
		type:"POST",
		data:sendData,
		success:function(resultData){
			$(".replyList .list").html(""); // 기존꺼 지우기
            const list=$(".replyList .list");
            const replyList = resultData.replyList;
            $.each(replyList,function(i,item){
                list.append(`
                <li data-no="${item.no}" data-boardid="${item.boardId}">
                	<div class="txt">${item.reply} </div>
					<button><span class="material-icons">delete</span></button>
                </li>
                `)
            });
		}
	});
}

$(".replyList").on("click","li button",function(e){
	const _parent = $(this).parent();
	const sendData = {
		no:_parent.data("no")
	}
	$.ajax({
		url:"DeleteReply.do",
		type:"POST",
		data:sendData,
		success:function(resultData){
			console.log(resultData);
			if(resultData > 0){
				_parent.remove();
				alert("댓글이 삭제되었습니다.");
			} else{
				alert("뎃글 삭제에 실패했습니다.");
			}
		},
		error:function(error){
			console.log(error);
		}
	})
});

$("#qnaDeleteBtn").on("click",function(e){
	console.log("hihihih");
	let password = prompt("Qna 패스워드를 입력하세요");
	const sendData ={
		no:$("#qnaNo").text(),
		password: password
	}
	console.log(sendData);
	$.ajax({
		url:"QndDelete.do",
		type:"POST",
		data:sendData,
		success:function(result){
			if(result > 0){
				alert("게시글이 삭제되었습니다.")
				location.href="QnaList.do";
			} else {
				alert("비밀번호가 달라서 삭제 실패하였습니다.")
			}
		}
	})
	
	
	
	
});
