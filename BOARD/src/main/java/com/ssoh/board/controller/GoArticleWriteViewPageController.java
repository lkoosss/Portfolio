package com.ssoh.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssoh.utility.WebUtility;

@WebServlet("/GoArticleWriteViewPage.do")
public class GoArticleWriteViewPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GoArticleWriteViewPageController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebUtility.setEncoding(request, response);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./board/write.jsp");
		dispatcher.forward(request, response);
	}

}
