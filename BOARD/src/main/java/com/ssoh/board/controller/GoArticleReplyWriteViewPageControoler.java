package com.ssoh.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssoh.model.BoardDao;
import com.ssoh.model.BoardDto;
import com.ssoh.utility.WebUtility;

@WebServlet("/GoArticleReplyWriteViewPage.do")
public class GoArticleReplyWriteViewPageControoler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GoArticleReplyWriteViewPageControoler() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebUtility.setEncoding(request, response);
		
		
		BoardDao boardDao = new BoardDao();
		BoardDto boardDto = boardDao.getOneBoard(Integer.parseInt(request.getParameter("articleNumberToReply")));
		request.setAttribute("boardDto", boardDto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./board/replyWrite.jsp");
		dispatcher.forward(request, response);
	}
}
