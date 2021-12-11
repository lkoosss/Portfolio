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

@WebServlet("/MemberInfoModify.do")
public class MemberInfoModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberInfoModifyController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebUtility.setEncoding(request, response);
		HttpSession session = request.getSession();
		
		MemberDto loggedMemberDto = (MemberDto)session.getAttribute("loggedMemberDto");
		int result = 0;
		
		MemberDao memberDao = new MemberDao();
		MemberDto tempMemberDto = new MemberDto();
		
		tempMemberDto.setName(loggedMemberDto.getName());
		tempMemberDto.setId(loggedMemberDto.getId());
		tempMemberDto.setZipcode(Integer.parseInt(request.getParameter("zipcode")));
		tempMemberDto.setAddress(request.getParameter("address01")+"/"+request.getParameter("address02"));
		tempMemberDto.setHp(request.getParameter("phoneNumber01")+request.getParameter("phoneNumber02")+request.getParameter("phoneNumber03"));
		tempMemberDto.setEmail(request.getParameter("userEmail"));
		
		if(request.getParameter("userPw") == ""){
			tempMemberDto.setPassword(loggedMemberDto.getPassword());
			result = memberDao.updateMember(tempMemberDto, false);
		} else{
			tempMemberDto.setPassword(request.getParameter("userPw"));
			result = memberDao.updateMember(tempMemberDto, true);
		}
		if(result > 0) {
			tempMemberDto = memberDao.getOneMember(tempMemberDto.getId(), tempMemberDto.getPassword());
			session.setAttribute("loggedMemberDto", tempMemberDto);
			WebUtility.alertAndNextPage(response, "회원정보가 수정되었습니다.", "./GoMemberInfoViewPage.do");
		}else {
			WebUtility.alertAndNextPage(response, "오류가 발생하여 회원정보가 수정되지 못했습니다.", "./GoMemberInfoViewPage.do");
		}
	}

}
