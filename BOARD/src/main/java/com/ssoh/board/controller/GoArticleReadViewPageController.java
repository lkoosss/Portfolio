package com.ssoh.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssoh.model.BoardDao;
import com.ssoh.model.BoardDto;
import com.ssoh.model.MemberDto;
import com.ssoh.utility.WebUtility;

@WebServlet("/GoArticleReadViewPage.do")
public class GoArticleReadViewPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GoArticleReadViewPageController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebUtility.setEncoding(request, response);
		HttpSession session = request.getSession();
		
		BoardDao boardDao = new BoardDao();
		BoardDto boardDto = new BoardDto();
		String loggedUserId = null;
		
		if(session.getAttribute("loggedMemberDto") != null) {
			MemberDto loggedMemberDto = (MemberDto)session.getAttribute("loggedMemberDto");
			loggedUserId = loggedMemberDto.getId();
		}
		int articleNumber = Integer.parseInt(request.getParameter("articleNumber"));
		
		boardDto = boardDao.getOneBoard(articleNumber);
		request.setAttribute("boardDto", boardDto);
		request.setAttribute("loggedUserId", loggedUserId);
		request.setAttribute("articleNumber", articleNumber);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./board/article.jsp");
		dispatcher.forward(request, response);
	}
}
