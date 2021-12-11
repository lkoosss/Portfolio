package com.ssoh.board.controller;

import java.io.IOException;
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

@WebServlet("/BoardModify.do")
public class BoardModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardModifyController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebUtility.setEncoding(request, response);
		HttpSession session = request.getSession();
		
		BoardDao boardDao = new BoardDao();
		BoardDto boardDto = new BoardDto();
		MemberDto loggedMemberDto = (MemberDto)session.getAttribute("loggedMemberDto");
		
		int articleNumberToModify = Integer.parseInt(request.getParameter("articleNumberToModify"));
		String articleSubjectToModify = request.getParameter("articleSubjectToModify");
		String articleContentsToModify = request.getParameter("articleContentsToModify");
		
		int result = boardDao.updateBoard(articleSubjectToModify, articleContentsToModify, articleNumberToModify);
		if(result > 0) {
			WebUtility.alertAndNextPage(response, "수정이 완료 되었습니다.", "./GoArticleReadViewPage.do?articleNumber="+articleNumberToModify);
		} else {
			
		}
	}
}
