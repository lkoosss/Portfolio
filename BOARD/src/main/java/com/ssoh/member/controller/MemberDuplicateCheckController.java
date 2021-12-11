package com.ssoh.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssoh.model.MemberDao;
import com.ssoh.model.MemberDto;
import com.ssoh.utility.WebUtility;

@WebServlet("/MemberDuplicateCheck.do")
public class MemberDuplicateCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberDuplicateCheckController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebUtility.setEncoding(request, response);
		PrintWriter out = response.getWriter();
		
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = null;
		
		String userId = request.getParameter("userId");
		memberDto = memberDao.getOneMember(userId);
		
		if(memberDto != null) {
			out.println("<h2>이미 사용중인 아이디 입니다.</h2>");
		} else {
			out.println("<h2>사용 가능한 이이디 입니다.</h2>");
		}
		out.println("<div style=\"text-align:center;\">");
		out.println("<button onclick='window.close()' style='background-color:black; color:white; padding:10px;'>확인</button>");
		out.println("</div>");
	}

}
