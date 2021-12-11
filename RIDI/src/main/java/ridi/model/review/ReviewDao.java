package ridi.model.review;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ReviewDao {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	// 리뷰 작성시 DB에 저장한다.
	public int reviewWrite(ReviewDto reviewDto) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.insert("reviewWrite",reviewDto);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	// 리뷰 목록들을 출력한다.
	public List<ReviewDto> getAllReview(ReviewDto reviewDto){
		List<ReviewDto> reviewList = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		reviewList = sqlSession.selectList("getAllReview",reviewDto);
		sqlSession.close();
		return reviewList;
	}
	
	// 리뷰 삭제를 실행한다.
	public int deleteReview(ReviewDto reviewDto) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.delete("deleteReview",reviewDto);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	// 책의 평균별점을 BOOK 테이블에 업데이트한다.
	public void updateStarRatingAvg(ReviewDto reviewDto) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("updateStarRatingAvg",reviewDto);
		sqlSession.commit();
		sqlSession.close();
	}
}

