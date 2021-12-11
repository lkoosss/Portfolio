package com.ssoh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssoh.model.MemberDao;
import com.ssoh.model.MemberDto;
import com.ssoh.utility.WebUtility;

@WebServlet("/MemberDelete.do")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberDeleteController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebUtility.setEncoding(request, response);
		HttpSession session = request.getSession();
		
		MemberDao memberDao = new MemberDao();
		MemberDto loggedMemberDto = (MemberDto)session.getAttribute("loggedMemberDto");
		
		String userId = loggedMemberDto.getId();
		String userPw = request.getParameter("userPw");
		
		int result = memberDao.deleteMember(userId, userPw);
		if(result > 0) {
			session.invalidate();
			WebUtility.alertAndNextPage(response, "탈퇴 완료 되었습니다.", "./GoBoardListViewPage.do");
		} else {
			WebUtility.alertAndBackPage(response, "비밀번호가 틀립니다.");
		}
	}

}
