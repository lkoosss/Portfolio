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

@WebServlet("/MemberLoginCheck.do")
public class MemberLoginCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLoginCheckController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebUtility.setEncoding(request, response);
		HttpSession session = request.getSession();
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		MemberDao memberDao = new MemberDao();
		MemberDto loggedMemberDto =  memberDao.getOneMember(userId, userPw);
		
		if(loggedMemberDto != null) {
			session.setAttribute("loggedMemberDto", loggedMemberDto);
			WebUtility.alertAndNextPage(response, "로그인이 되었습니다.", "./GoBoardListViewPage.do");
		} else {
			WebUtility.alertAndBackPage(response, "없는 아이디 이거나 비밀번호가 틀렸습니다.");
		}
	}

}
