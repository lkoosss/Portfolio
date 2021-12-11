package com.ssoh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssoh.model.MemberDto;
import com.ssoh.utility.WebUtility;

@WebServlet("/MemberLogout.do")
public class MemberLogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLogoutController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebUtility.setEncoding(request, response);
		HttpSession session = request.getSession();
		MemberDto loggedMemberDto =  (MemberDto)session.getAttribute("loggedMemberDto");
		String alertMessage = loggedMemberDto.getName()+"님 안녕히 가세요";
		
		WebUtility.alert(response, alertMessage);
		session.invalidate();
		WebUtility.nextPage(response, "./GoBoardListViewPage.do");
		
	}
}