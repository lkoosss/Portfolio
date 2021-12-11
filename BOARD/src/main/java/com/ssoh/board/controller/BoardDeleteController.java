package com.ssoh.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssoh.model.BoardDao;
import com.ssoh.model.MemberDto;
import com.ssoh.utility.WebUtility;

@WebServlet("/BoardDelete.do")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardDeleteController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebUtility.setEncoding(request, response);
		HttpSession session = request.getSession();
		
		BoardDao boardDao = new BoardDao();
		MemberDto loggedMemberDto = (MemberDto)session.getAttribute("loggedMemberDto");
		
		int articleNumberToDelete =  Integer.parseInt(request.getParameter("articleNumberToDelete"));
		String loggedUserId = loggedMemberDto.getId();
		String loggedUserName = loggedMemberDto.getName();
		
		int result = boardDao.delteBoard(articleNumberToDelete, loggedUserId, loggedUserName);
		if(result > 0) {
			WebUtility.alertAndNextPage(response, "해당 글을 삭제 하였습니다.", "./GoBoardListViewPage.do");
		} else {
			WebUtility.alertAndNextPage(response, "해당 글을 삭제하지 못했습니다.", "./GoBoardListViewPage.do");
		}
	}
}