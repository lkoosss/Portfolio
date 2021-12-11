package ridi.model.review;

import java.sql.Date;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import ridi.model.member.MemberDao;

@Repository
public class ReviewDto {
	private int no;
	private int book_No;
	private String contents;
	private String writer_Id;
	private int star_Rating;
	private String password;
	private String review_Date;
	
	public ReviewDto() {
		super();
	}

	public ReviewDto(int no, int book_No, String contents, String writer_Id, int star_Rating, String password,
			String review_Date) {
		super();
		this.no = no;
		this.book_No = book_No;
		this.contents = contents;
		this.writer_Id = writer_Id;
		this.star_Rating = star_Rating;
		this.password = password;
		this.review_Date = review_Date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getBook_No() {
		return book_No;
	}

	public void setBook_No(int book_No) {
		this.book_No = book_No;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getWriter_Id() {
		return writer_Id;
	}

	public void setWriter_Id(String writer_Id) {
		this.writer_Id = writer_Id;
	}

	public int getStar_Rating() {
		return star_Rating;
	}

	public void setStar_Rating(int star_Rating) {
		this.star_Rating = star_Rating;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getReview_Date() {
		return review_Date;
	}

	public void setReview_Date(String review_Date) {
		this.review_Date = review_Date;
	}

	
	
}
