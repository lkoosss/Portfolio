package ridi.controller;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import ridi.model.member.MemberDao;
import ridi.model.member.MemberDto;
import ridi.utlils.Mail;
import ridi.utlils.ScriptWriterUtil;

@Controller
@Slf4j
public class MemberController {
	 @Autowired
     MemberDao memberDao;
     
     @Autowired
     MemberDto memberDto;
     
     @Autowired
     MemberDto loggedMemberDto;
     
     @Autowired
     MemberDto tempMemberDto;
     
     private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  //아이디 찾기 페이지로 이동
  @RequestMapping("/MemberFindIdForm.do")
  public String memberFindIdForm() {
	  return "member/member_FindId";
  }
  
  //전달받은 email주소로 ID를 찾는다.
  @RequestMapping("/MemberFindId.do")
  @ResponseBody
  public Map<String,Object> memberFindId(MemberDto memberDto) {
	  Map<String,Object> hashMap = new HashMap<String,Object>();
	  List<MemberDto> idList = memberDao.memberFindId(memberDto);
	  
	  hashMap.put("idList", idList);
	  return hashMap;
  }
  
  //비밀번호 재설정 페이지로 이동
  @RequestMapping("/MemberFindPwForm.do")
  public String memberFindPwForm() {
	  return "member/member_FindPw";
  }
  
  //비밀번호 재설정 페이지에서 입력받은 id,email을 토대로 임시 비밀번호 생성,발급
  // 임시 비밀번호 생성, DB에 저장, 유효한 Email에 임시 비밀번호 발송
  @RequestMapping("/MemberFindPw.do")
  @ResponseBody
  public Map<String,String> memberFindPw(MemberDto memberDto) {
	  int result = 0;
	  Map<String,String> hashMap = new HashMap<String,String>();
	  
	  // 길이 20의 임시 패스워드 생성
	  String tempPassword = "";
		Random random = new Random();
		for(int i=0; i <20; i++) {
			int rIndex = random.nextInt(4);
			switch(rIndex) {
			case 0:
				// a-z
				tempPassword=tempPassword+(char)((int)random.nextInt(26)+97);
				break;
			case 1:
				// A-Z
				tempPassword=tempPassword+(char)((int)random.nextInt(26)+65);
				break;
			case 2:
				// 0-9
				tempPassword=tempPassword+random.nextInt(10);
				break;
			case 3:
				tempPassword=tempPassword+(char)(random.nextInt(15)+33);
				break;
			}
		}
	  String securePw = encoder.encode(tempPassword);
	  memberDto.setPassword(securePw);
	  result = memberDao.memberFindPw(memberDto);
	  
	  if(result > 0) {
		  Mail.NaverMail(memberDto.getEmail(), "[RIDI] 임시 비밀번호 발급.", "<p>안녕하세요 RIDI 임시 비밀번호 입니다. <br><br> 비밀번호 : <b>"+tempPassword+"</b></p>");
	  }
	  
	  hashMap.put("result", String.valueOf(result));
	  return hashMap;
  }
     
  //회원가입 페이지로 이동
  @RequestMapping("/MemberJoinForm.do")
  public String memberWriteForm() {
     return "member/member_Join";
  }
  
  //ID 중복체크를 실행합니다.
  //조회된 ID를 Ajax 에 전달
  @RequestMapping("/idDuplicationCheck.do")
  @ResponseBody
  public MemberDto idDuplicationCheck(MemberDto memberDto) {
	  tempMemberDto = memberDao.idDuplicationCheck(memberDto);
	  return tempMemberDto;
  }
  
  //Email 인증번호를 생성, 입력받은 메일로 발송
  @RequestMapping("/generateEmailAuthNum.do")
  @ResponseBody
  public int generateEmailAuthNum(@RequestParam Map<String,Object> map) {
	  String email = (String)map.get("email");
	  double random = Math.random()*1000000;
	  Mail.NaverMail(email, "[RIDI] 인증메일 발송드립니다.", "<p>안녕하세요 RIDI 이메일 인증번호 발송드립니다. <br><br> 인증번호 : <b>"+(int)random+"</b></p>");
	  return (int)random;
  }
  
  //로그인 페이지로 이동
  @RequestMapping("/MemberLoginForm.do")
  public String memberLoginForm() {
	  return "member/member_Login";
  }
  
  //ID,Password가 맞으면 로그인 실행
  @RequestMapping("/MemberLogin.do")
  public void memberLogin(MemberDto memberDto,HttpServletResponse response,HttpServletRequest request,HttpSession session) throws IOException {
	  
	  loggedMemberDto = memberDao.getLoggedMember(memberDto);
	  
	  if(loggedMemberDto != null) {
		  String inputPw = memberDto.getPassword();
		  String DBPw = loggedMemberDto.getPassword();
		  if(encoder.matches(inputPw, DBPw)) {
			  session.setAttribute("loggedMember", loggedMemberDto);
			  ScriptWriterUtil.alertAndNext(response, "로그인되었습니다.", "/");			  
		  } else {
			  ScriptWriterUtil.alertAndBack(response, "패스워드가 틀립니다.");
		  }
	  } else {
		  ScriptWriterUtil.alertAndBack(response, "존재하는 ID가 아닙니다.");
	  }
  }
  
  //로그아웃 실행
  @RequestMapping("/MemberLogout.do")
  public String memberLogout(HttpSession session) {
	  session.invalidate();
	  return "index";
  }
  
  //회원가입 실행
  //입력받은 정보를 DB에 저장
  @RequestMapping("/MemberJoin.do")
  public void memberJoin(MemberDto memberDto,HttpServletRequest request, HttpServletResponse response) throws IOException {
	  memberDto.setRRN(memberDto.getRrn_First()+"-"+memberDto.getRrn_Last());
	  memberDto.setAddress(memberDto.getAddress01()+"/"+memberDto.getAddress02());
	  memberDto.setHp(memberDto.getHp_First()+"-"+memberDto.getHp_Middle()+"-"+memberDto.getHp_Last());
	  String securePw = encoder.encode(memberDto.getPassword());
	  memberDto.setPassword(securePw);

	  int result = memberDao.insertMember(memberDto);
	  if(result > 0) {
		  ScriptWriterUtil.alertAndNext(response, "회원가입이 완료 되었습니다.", "/");
	  } else {
		  ScriptWriterUtil.alertAndBack(response, "회원가입 실패");
	  }
  }
  
  //회원정보 변경 페이지로 이동
  @RequestMapping("/MemberInfoModifyForm.do")
  public String memberInfoModifyForm() {
	  return "member/member_Modify";
  }
 
  //회원정보 변경 실행
  //패스워드 변경유무 구분하여 정보변경
  @RequestMapping("/MemberInfoModify.do")
  public void memberInfoModify(MemberDto memberDto,HttpServletResponse response,HttpSession session) throws IOException {
	  MemberDto loggedMemberDto = (MemberDto)session.getAttribute("loggedMember");
	  
	  memberDto.setId(loggedMemberDto.getId());
	  memberDto.setAddress(memberDto.getAddress01()+"/"+memberDto.getAddress02());
	  memberDto.setHp(memberDto.getHp_First()+"-"+memberDto.getHp_Middle()+"-"+memberDto.getHp_Last());
	  
	  if(!memberDto.getPassword().isBlank()) {
		  String securePw = encoder.encode(memberDto.getPassword());		  
		  memberDto.setPassword(securePw);		  
	  }
	  
	  int result = memberDao.modifyMember(memberDto);
	  
	  if(result > 0) {
		  loggedMemberDto = memberDao.getLoggedMember(memberDto);
		  session.setAttribute("loggedMember", loggedMemberDto);
		  ScriptWriterUtil.alertAndNext(response, "회원정보가 정상적으로 수정되었습니다.", "MemberInfoModifyForm.do");
	  } else {
		  ScriptWriterUtil.alertAndBack(response, "알수 없는 이유로 정보가 수정되지 못했습니다.");
	  }
  }
  
  //마이리디 페이지로 이동
  @RequestMapping("/MemberHomeForm.do")
  public String memberHomeForm() {
	  return "member/member_Info";
  }
  
  // 회원탈퇴 페이지로 이동
  @RequestMapping("/MemberDeleteForm.do")
  public String memberDeleteForm() {
	  return "member/member_delete";
  }
  
  // 회원탈퇴 동작을 실행
  @RequestMapping("/MemberDelete.do")
  public void memberDelete(MemberDto memberDto,HttpServletResponse response,HttpSession session) throws IOException {
	  MemberDto loggedMemberDto = (MemberDto)session.getAttribute("loggedMember");
	  memberDto.setId(loggedMemberDto.getId());
	  
	  String inputPw = memberDto.getPassword();
	  String DBPw = memberDao.getMemberPassword(memberDto);
	  
	  if(encoder.matches(inputPw, DBPw)) {
		  int result = memberDao.deleteMember(memberDto);
		  if(result > 0) {
			  session.invalidate();
			  ScriptWriterUtil.alertAndNext(response, "정상적으로 탈퇴가 되었습니다.", "/");
		  } 
	  } else {
		  ScriptWriterUtil.alertAndNext(response, "비밀번호를 확인해주세요","MemberDeleteForm.do");
	  }
	  
  }
  
  // 결제한 금액만큼 캐시를 차감하고 member 세션을 다시받는다.
  @RequestMapping("/minusCash.do")
  @ResponseBody
  public int minusCash(MemberDto memberDto, HttpSession session) {
	  int result = 0;
	  result = memberDao.minusCash(memberDto);
	  
		  loggedMemberDto = memberDao.getOneMember(memberDto);
		  session.setAttribute("loggedMember", loggedMemberDto);

	  
	  return result;
  }
}
