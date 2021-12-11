package ridi.model.qna;


import java.sql.Date;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Repository
public class QnaDto {
	private int no;
	private String writerId;
	public String subject;
	public String password;
	private Date regDate;
	private int readCount;
	private String contents;
	private String searchField;
	private String searchWord;
	private int num;
	
	public QnaDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QnaDto(int no, String writerId, String subject, String password, Date regDate, int readCount,
			String contents, String searchField, String searchWord, int num) {
		super();
		this.no = no;
		this.writerId = writerId;
		this.subject = subject;
		this.password = password;
		this.regDate = regDate;
		this.readCount = readCount;
		this.contents = contents;
		this.searchField = searchField;
		this.searchWord = searchWord;
		this.num = num;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	
	
	
	
	
	
	
	}
	