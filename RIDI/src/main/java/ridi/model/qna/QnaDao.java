package ridi.model.qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import ridi.model.member.MemberDao;

@Repository
public class QnaDao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	// 게시글 작성
	public int insertQna(QnaDto qnaDto) {
		int result = 0 ;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result =  sqlSession.insert("insertQna",qnaDto);
		sqlSession.commit();
		sqlSession.close();
		
		return result;
	}
	
	// 게시글 리스트
	public List<QnaDto> getAllList(int start, int end){
		HashMap<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", start);
		page.put("end", end);
		
		List<QnaDto> qnaList = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		qnaList = sqlSession.selectList("getAllList",page);		
		sqlSession.close();
		return qnaList;
	}
	
	// 총 게시글 개수
	public int getTotal() {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.selectOne("getTotal");
		sqlSession.close();
		
		return result;
	}
	
	// 검색된 게시글의 총 개수
	public int getSearchTotal(Map hashMap) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.selectOne("getSearchTotal",hashMap);
		sqlSession.close();
		return result;
	}
	
	// 게시글 읽을때 마다 1씩 증가 
	public int updateReadCount(int no) {
		int result =0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.update("updateReadCount",no);
		sqlSession.commit();
		sqlSession.close();
		
		return result;
	}
	
	// 한 페이지 선택
	public QnaDto getQnaSelectOne(int no) {
		QnaDto qnaDto = null;
		updateReadCount(no);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		qnaDto = sqlSession.selectOne("getQnaSelectOne",no);
		sqlSession.close();
		
		return qnaDto;
	}
	
	// 이전 페이지로 이동
	public QnaDto prevQnaDto(int num) {
		QnaDto qnaDto = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		qnaDto = sqlSession.selectOne("prevQnaDto",num);
		sqlSession.close();
		
		return qnaDto;
	}
	// 다음 페이지로 이동
	public QnaDto nextQnaDto(int num) {
		QnaDto qnaDto = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		qnaDto = sqlSession.selectOne("nextQnaDto",num);
		sqlSession.close();
		
		return qnaDto;		
	}
	
	// 검색할 시 이전페이지로 이동
	public QnaDto prevSearchQnaDto(Map hashMap) {
		QnaDto qnaDto = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		qnaDto = sqlSession.selectOne("prevSearchQnaDto",hashMap);
		sqlSession.close();
		
		return qnaDto;
	}
	
	// 검색할 시 이전페이지로 이동
		public QnaDto nextSearchQnaDto(Map hashMap) {
			QnaDto qnaDto = null;
			SqlSession sqlSession = sqlSessionFactory.openSession();
			qnaDto = sqlSession.selectOne("nextSearchQnaDto",hashMap);
			sqlSession.close();
			
			return qnaDto;
		}
	// 페스워드 입력
	public String getPassword(int no) {
		String password = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		password = sqlSession.selectOne("getPassword", no);
		sqlSession.close();
		return password;
	}
	
	// 게시글 삭제 및 게시글 삭제시 게시글에 달려있는 댓글도 삭제
	public int deleteQna(QnaDto qnaDto) {
		int result1 = 0;
		int result2 = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result1 = sqlSession.delete("deleteQna",qnaDto);
		result2 = sqlSession.delete("deleteAllReply",qnaDto);
		sqlSession.commit();
		sqlSession.close();
		
		return result1+result2;
	}
	
	public List<QnaDto> getQnaSearchList(Map hashMap){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<QnaDto> qnaSearchList = sqlSession.selectList("getSearchAllList",hashMap);
		sqlSession.close();
		return qnaSearchList;
	}
	
}
