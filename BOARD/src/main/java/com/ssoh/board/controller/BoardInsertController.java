package com.ssoh.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssoh.model.BoardDao;
import com.ssoh.model.BoardDto;
import com.ssoh.utility.WebUtility;

@WebServlet("/BoardInsert.do")
public class BoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardInsertController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebUtility.setEncoding(request, response);
		
		int result = 0;
		BoardDao boardDao = new BoardDao();
		BoardDto boardDto = new BoardDto();
		BoardDto targetBoardDto = new BoardDto();
		boardDto.setId(request.getParameter("userId"));
		boardDto.setName(request.getParameter("userName"));
		boardDto.setEmail(request.getParameter("userEmail"));
		boardDto.setSubject(request.getParameter("subject"));
		boardDto.setContents(request.getParameter("contents"));
		
		if(request.getParameter("isReply") != null) {
			boardDto.setNo(Integer.parseInt(request.getParameter("articleNumberToReply")));
			result = boardDao.insertReplyToBoard(boardDto);
		} else {
			result = boardDao.insertBoard(boardDto);
		}
		
		if(result > 0) {
			WebUtility.alertAndNextPage(response, "내용이 정상적으로 저장되었습니다.", "./GoBoardListViewPage.do");
		} else {
			WebUtility.alertAndBackPage(response, "입력된 내용이 저장되지 않았습니다.");
		}
	}
}
