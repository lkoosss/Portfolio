package com.ssoh.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssoh.model.MemberDao;
import com.ssoh.model.MemberDto;
import com.ssoh.utility.WebUtility;

@WebServlet("/MemberJoin.do")
public class MemberJoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberJoinController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebUtility.setEncoding(request, response);
		HttpSession session = request.getSession();
		
		int result = 0;
		MemberDao memberDao = new MemberDao();
		
		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		int userZipcode = Integer.parseInt(request.getParameter("zipcode"));
		String userAddress = request.getParameter("address01")+"/"+request.getParameter("address02");
		String userPhoneNumber = request.getParameter("phoneNumber01")+request.getParameter("phoneNumber02")+request.getParameter("phoneNumber03");
		String userEmail = request.getParameter("userEmail");
		
		result = memberDao.insertMember(userId, userPw, userName, userZipcode, userAddress, userPhoneNumber, userEmail);
		
		if(result > 0) {
			MemberDto loggedMemberDto = memberDao.getOneMember(userId, userPw);
			session.setAttribute("loggedMemberDto", loggedMemberDto);
			WebUtility.alertAndNextPage(response, "회원가입이 완료 되었습니다.", "./GoBoardListViewPage.do");
		} else {
			WebUtility.alertAndBackPage(response, "회원가입에 실패하였습니다.");
		}
	}

}
