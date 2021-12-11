package com.ssoh.model;

public class BoardDto {
	private int no;
	private String id;
	private String name;
	private String email;
	private String subject;
	private String contents;
	private int postGroup;
	private int reStep;
	private int reLevel;
	private int readCount;
	private String regDate;
	
	
	public BoardDto() {
		super();
	}

	public BoardDto(int no, String id, String name, String email, String subject, String contents, int postGroup,
			int reStep, int reLevel, int readCount, String regDate) {
		super();
		this.no = no;
		this.id = id;
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.contents = contents;
		this.postGroup = postGroup;
		this.reStep = reStep;
		this.reLevel = reLevel;
		this.readCount = readCount;
		this.regDate = regDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getPostGroup() {
		return postGroup;
	}

	public void setPostGroup(int postGroup) {
		this.postGroup = postGroup;
	}

	public int getReStep() {
		return reStep;
	}

	public void setReStep(int reStep) {
		this.reStep = reStep;
	}

	public int getReLevel() {
		return reLevel;
	}

	public void setReLevel(int reLevel) {
		this.reLevel = reLevel;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "BoardDto [no=" + no + ", id=" + id + ", name=" + name + ", email=" + email + ", subject=" + subject
				+ ", contents=" + contents + ", postGroup=" + postGroup + ", reStep=" + reStep + ", reLevel=" + reLevel
				+ ", readCount=" + readCount + ", regDate=" + regDate + "]";
	}
}
