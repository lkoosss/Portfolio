package com.ssoh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssoh.utility.WebUtility;

@WebServlet("/GoMemberInfoViewPage.do")
public class GoMemberInfoViewPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GoMemberInfoViewPageController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebUtility.setEncoding(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher("./member/member_info.jsp");
		dispatcher.forward(request, response);
	}
}
