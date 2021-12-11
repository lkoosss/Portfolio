package ridi.model.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class MemberDao {
	  
	   @Autowired
	   private SqlSessionFactory sqlSessionFactory;
	   
	   //회원정보를 DB에 저장
	   public int insertMember(MemberDto memberDto) {
	      int result = 0;
	      
	      SqlSession sqlSession = sqlSessionFactory.openSession();
	      result = sqlSession.insert("insertMember", memberDto);
	      sqlSession.commit();
	      sqlSession.close();
	      
	      return result;
	   }
	   
	   //로그인된 회원정보를 반환
	   public MemberDto getLoggedMember(MemberDto memberDto) {
	      MemberDto loggedMember = null;
	      SqlSession sqlSession = sqlSessionFactory.openSession();
	      loggedMember = sqlSession.selectOne("getLoggedMember", memberDto);
	      sqlSession.close();
	      return loggedMember;
	   }
	   
	   //변경된 회원정보를 DB에 저장
	   public int modifyMember(MemberDto memberDto) {
		   int result = 0;
		   
		   SqlSession sqlSession = sqlSessionFactory.openSession();
		   
		   if(memberDto.getPassword().isBlank()) {
			   result = sqlSession.update("modifyMemberNotPw", memberDto);
		   } else {
			   result = sqlSession.update("modifyMember",memberDto);			   
		   }
		   
		   sqlSession.commit();
		   sqlSession.close();
		   return result;
	   }
	   
	   //탈퇴할 회원정보를 DB에서 삭제
	   public int deleteMember(MemberDto memberDto) {
		   int result = 0;
		   
		   SqlSession sqlSession = sqlSessionFactory.openSession();
		   result = sqlSession.delete("deleteMember",memberDto);
		   sqlSession.commit();
		   sqlSession.close();
		   
		   return result;
	   }
	   
	   // 회원의 암호화 된 PW를 반환
	   public String getMemberPassword(MemberDto memberDto) {
		   String result = "";
		   SqlSession sqlSession = sqlSessionFactory.openSession();
		   
		   result = sqlSession.selectOne("getMemberPassword",memberDto);
		   sqlSession.close();
		   return result;
	   }

	   //ID중복 체크시 탐색된 ID값을 반환
	   public MemberDto idDuplicationCheck(MemberDto memberDto) {
		   SqlSession sqlSession = sqlSessionFactory.openSession();
		   
		   MemberDto tempMemberDto = sqlSession.selectOne("idDuplicationCheck",memberDto);
		   sqlSession.close();
		   return tempMemberDto;
	   }
	   
	   //ID 찾기 시 탐색된 ID값을 반환(위랑 같아보이지만 select 결과가 다름)
	   public List<MemberDto> memberFindId(MemberDto memberDto) {
		   SqlSession sqlSession = sqlSessionFactory.openSession();
		   List<MemberDto> idList = sqlSession.selectList("memberFindId",memberDto);
		   
		   sqlSession.close();
		   return idList;
	   }
	   
	   //PW찾기 시 임시 패스워드를 DB에 저장
	   public int memberFindPw(MemberDto memberDto) {
		   int result = 0;
		   
		   SqlSession sqlSession = sqlSessionFactory.openSession();
		   result = sqlSession.update("memberFindPw",memberDto);
		   sqlSession.commit();
		   sqlSession.close();
		   return result;
	   }
	   
	   //결제한 금액만큼 캐시를 차감하고 member 세션을 다시받는다.
	   public int minusCash(MemberDto memberDto) {
		   int result = 0;
		   
		   SqlSession sqlSession = sqlSessionFactory.openSession();
		   result = sqlSession.update("minusCash",memberDto);
		   sqlSession.commit();
		   sqlSession.close();
		   
		   return result;
	   }
	   
	   public MemberDto getOneMember(MemberDto memberDto) {
		   MemberDto loggedMember = null;
		   SqlSession sqlSession = sqlSessionFactory.openSession();
		   loggedMember = sqlSession.selectOne("getOneMember",memberDto);
		   sqlSession.close();
		   return loggedMember;
	   }
}
