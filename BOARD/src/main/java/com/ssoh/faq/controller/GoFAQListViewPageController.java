package com.ssoh.faq.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssoh.model.FAQDao;
import com.ssoh.model.FAQDto;
import com.ssoh.utility.WebUtility;

@WebServlet("/GoFAQListViewPage.do")
public class GoFAQListViewPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GoFAQListViewPageController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebUtility.setEncoding(request, response);
		
		FAQDao faqDao = new FAQDao();
		FAQDto faqDto = new FAQDto();
		ArrayList<FAQDto> faqList = faqDao.getAllFAQ();
		
		request.setAttribute("faqList", faqList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./FAQ/list.jsp");
		dispatcher.forward(request, response);
	}

}
