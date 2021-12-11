package com.ssoh.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssoh.model.BoardDao;
import com.ssoh.model.BoardDto;

@WebServlet("/GoBoardListViewPage.do")
public class GoBoardListViewPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GoBoardListViewPageController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao boardDao = new BoardDao();
		String searchWord = null;
		searchWord = request.getParameter("searchWord");
		String searchField = request.getParameter("searchField");
		if(searchWord == null || searchWord.isBlank()) {
			int totalBoardLength = boardDao.getBoardLength(); //모든 글 개수
			
			int currentPage = 1;    //유저가 클릭한 페이지
			if(request.getParameter("currentPage") != null) currentPage = Integer.parseInt(request.getParameter("currentPage")); 
			
			int boardListLengthPerPage = 5;   //한 페이지에 나오는 게시글 갯수
			
			int pageListLength = 3;  //페이지 네비게이션 의 길이
			int firstNumOfPageList = ((currentPage-1)/(pageListLength))*pageListLength +1; // 페이지 네비게이션의 처음 숫자
			int lastNumOfPageList = firstNumOfPageList + pageListLength-1; //페이지 네비게이션의 마지막 숫자
			int endPageNum = (int)Math.ceil((double)totalBoardLength / (double)boardListLengthPerPage); // 마지막 페이지 숫자
			if(lastNumOfPageList > endPageNum) lastNumOfPageList = endPageNum; // lastNumOfPageList가 젤 마지막 페이지 표시숫자보다 크면 젤 마지막 페이지 숫자로 바꿈
			
			int firstSearchNum = currentPage*boardListLengthPerPage -4; // DB에서 몇번째 글부터
			int lastSearchNum = firstSearchNum + boardListLengthPerPage -1; // 몇번째 글까지 찾을지 나타내는 수자들
			
			ArrayList<BoardDto> boardList = boardDao.getAllBoard(firstSearchNum,lastSearchNum);
			request.setAttribute("boardList", boardList);
			request.setAttribute("firstNumOfPageList", firstNumOfPageList);
			request.setAttribute("lastNumOfPageList", lastNumOfPageList);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("pageListLength", pageListLength);
			request.setAttribute("endPageNum", endPageNum);
		} else {
			int totalBoardLength = boardDao.getBoardLength(searchField, searchWord); //모든 글 개수
			
			int currentPage = 1;    //유저가 클릭한 페이지
			if(request.getParameter("currentPage") != null) currentPage = Integer.parseInt(request.getParameter("currentPage")); 
			
			int boardListLengthPerPage = 5;   //한 페이지에 나오는 게시글 갯수
			
			int pageListLength = 3;  //페이지 네비게이션 의 길이
			int firstNumOfPageList = ((currentPage-1)/(pageListLength))*pageListLength +1; // 페이지 네비게이션의 처음 숫자
			int lastNumOfPageList = firstNumOfPageList + pageListLength-1; //페이지 네비게이션의 마지막 숫자
			int endPageNum = (int)Math.ceil((double)totalBoardLength / (double)boardListLengthPerPage); // 마지막 페이지 숫자
			if(lastNumOfPageList > endPageNum) lastNumOfPageList = endPageNum; // lastNumOfPageList가 젤 마지막 페이지 표시숫자보다 크면 젤 마지막 페이지 숫자로 바꿈
			
			int firstSearchNum = currentPage*boardListLengthPerPage -4; // DB에서 몇번째 글부터
			int lastSearchNum = firstSearchNum + boardListLengthPerPage -1; // 몇번째 글까지 찾을지 나타내는 수자들
			
			ArrayList<BoardDto> boardList = boardDao.getAllBoard(firstSearchNum,lastSearchNum,searchField,searchWord);
			request.setAttribute("boardList", boardList);
			request.setAttribute("firstNumOfPageList", firstNumOfPageList);
			request.setAttribute("lastNumOfPageList", lastNumOfPageList);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("pageListLength", pageListLength);
			request.setAttribute("endPageNum", endPageNum);
			request.setAttribute("searchWord", searchWord);
			request.setAttribute("searchField", searchField);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./board/list.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
