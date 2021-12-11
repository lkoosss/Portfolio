package ridi.model.book;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import ridi.model.member.MemberDao;

@Repository
@Slf4j
public class BookDao {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	/////////////////////////// 기본 기능 ///////////////////////
	public int insertBook(BookDto bookDto) {

		int result = 0;

		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.insert("insertBook", bookDto);
		sqlSession.commit();
		sqlSession.close();

		return result;
	}

	// 모든 책 출력
	public List<BookDto> getAllBook() {
		List<BookDto> bookList = null;

		SqlSession sqlSession = sqlSessionFactory.openSession();
		bookList = sqlSession.selectList("getAllBook");
		sqlSession.close();

		return bookList;
	}

	// info 페이지
	public BookDto getOneBook(int no) {
		BookDto bookDto = null;
		infoCount(no);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		bookDto = sqlSession.selectOne("getOneBook", no);
		sqlSession.close();

		return bookDto;
	}
	// info 조회수
	public int infoCount(int no) {
		int result = 0;

		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.update("infoCount", no);
		sqlSession.commit();
		sqlSession.close();

		return result;
	}

	// 책 수정 페이지
	public int modifyBook(BookDto bookDto) {
		int result = 0;

		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.update("modifyBook", bookDto);
		sqlSession.commit();
		sqlSession.close();

		return result;
	}

	// 책 삭제 페이지
	public int deleteBook(int no) {
		int result = 0;

		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.delete("deleteBook", no);
		sqlSession.commit();
		sqlSession.close();

		return result;
	}
	///////////////////////////// 메인 페이지/////////////////////////

	// 메인 슬라이더
	public List<BookDto> getAdvSlider() {
		List<BookDto> bookList = null;

		SqlSession sqlSession = sqlSessionFactory.openSession();
		bookList = sqlSession.selectList("getAdvSlider");
		sqlSession.close();

		return bookList;
	}

	// 신작 추천 슬라이더
	public List<BookDto> getNewBook() {
		List<BookDto> newBookList = null;

		SqlSession sqlSession = sqlSessionFactory.openSession();
		newBookList = sqlSession.selectList("getNewBook");
		sqlSession.close();

		return newBookList;
	}

	// 베스트 샐러 9개를 얻는다
	// 오성식 추가
	public List<BookDto> getBestSeller() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BookDto> bestSellerList = null;
		bestSellerList = sqlSession.selectList("getBestSeller");
		sqlSession.close();
		return bestSellerList;
	}
	
	// 조회수 많은 9개 책
	public List<BookDto> getPopBook() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BookDto> popBookList = null;
		popBookList = sqlSession.selectList("getPopBook");
		sqlSession.close();
		return popBookList;
	}
	
	
	////////////////////// 재태크///////////////////////////////

	// 재태크 메인 베스트셀러 슬라이더
	public List<BookDto> getMoneyBestSlider() {
		List<BookDto> moneyBestBookList = null;

		SqlSession sqlSession = sqlSessionFactory.openSession();
		moneyBestBookList = sqlSession.selectList("getMoneyBestSlider");
		sqlSession.close();

		return moneyBestBookList;
	}

	// 재태크 시간추천
	public List<BookDto> getMoneyTimeBook() {
		List<BookDto> moneyTimeBookList = null;

		SqlSession sqlSession = sqlSessionFactory.openSession();
		moneyTimeBookList = sqlSession.selectList("getMoneyTimeBook");
		sqlSession.close();

		return moneyTimeBookList;
	}

	// 재태크 리디추천 슬라이더
	public List<BookDto> getMoneyRecomBook() {
		List<BookDto> moneyRecomBookList = null;

		SqlSession sqlSession = sqlSessionFactory.openSession();
		moneyRecomBookList = sqlSession.selectList("getMoneyRecomBook");
		sqlSession.close();

		return moneyRecomBookList;
	}
	
	//////////////////////// 만화 페이지 //////////////////
	
	// 만화 메인 베스트셀러 슬라이더
	public List<BookDto> getComicBestSlider() {
		List<BookDto> comicBestBookList = null;

		SqlSession sqlSession = sqlSessionFactory.openSession();
		comicBestBookList = sqlSession.selectList("getComicBestSlider");
		sqlSession.close();

		return comicBestBookList;
	}

	// 만화 시간추천
	public List<BookDto> getComicTimeBook() {
		List<BookDto> comicTimeBookList = null;

		SqlSession sqlSession = sqlSessionFactory.openSession();
		comicTimeBookList = sqlSession.selectList("getComicTimeBook");
		sqlSession.close();

		return comicTimeBookList;
	}
	
	// 재태크 리디추천 슬라이더
	public List<BookDto> getComicRecomBook() {
		List<BookDto> comicRecomBookList = null;

		SqlSession sqlSession = sqlSessionFactory.openSession();
		comicRecomBookList = sqlSession.selectList("getComicRecomBook");
		sqlSession.close();

		return comicRecomBookList;
	}
	
	////////////////////// 에세이 페이지 ///////////////////////
	
	// 만화 메인 베스트셀러 슬라이더
	public List<BookDto> getEssayBestSlider() {
		List<BookDto> essayBestBookList = null;

		SqlSession sqlSession = sqlSessionFactory.openSession();
		essayBestBookList = sqlSession.selectList("getEssayBestSlider");
		sqlSession.close();

		return essayBestBookList;
	}
	
	// 만화 시간추천
	public List<BookDto> getEssayTimeBook() {
		List<BookDto> essayTimeBookList = null;

		SqlSession sqlSession = sqlSessionFactory.openSession();
		essayTimeBookList = sqlSession.selectList("getEssayTimeBook");
		sqlSession.close();

		return essayTimeBookList;
	}
	
	// 만화 리디추천 슬라이더
	public List<BookDto> getEssayRecomBook() {
		List<BookDto> essayRecomBookList = null;

		SqlSession sqlSession = sqlSessionFactory.openSession();
		essayRecomBookList = sqlSession.selectList("getEssayRecomBook");
		sqlSession.close();

		return essayRecomBookList;
	}
	
}