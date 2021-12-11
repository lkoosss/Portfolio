package ridi.model.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDao {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	// 댓글 입력
	public int insertReply(ReplyDto replyDto) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.insert("insertReply",replyDto);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	// 작성한 댓글 보여주는 리스트
	public List<ReplyDto> getAllReply(int boardId) {
		List<ReplyDto> replyList =  null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		replyList = sqlSession.selectList("getAllReply",boardId);
		sqlSession.close();
		return replyList;
	}
	
	// 댓글 하나 삭제
	public int deleteReply(ReplyDto replyDto) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.delete("deleteReply",replyDto);
		sqlSession.commit();
		sqlSession.close();
		
		return result;
	}
	
	// 해당글의 댓글수를 출력한다
	public int getReplyCount(int boardId) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.selectOne("getReplyCount",boardId);
		sqlSession.close();
		return result;
	}
	
	
}
