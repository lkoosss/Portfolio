package com.ssoh.model;

public class FAQDto {
	private int no;
	private String subject;
	private String contents;
	
	public FAQDto() {
		super();
	}

	public FAQDto(int no, String subject, String contents) {
		super();
		this.no = no;
		this.subject = subject;
		this.contents = contents;
	}
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	
	@Override
	public String toString() {
		return "FAQDto [no=" + no + ", subject=" + subject + ", contents=" + contents + "]";
	}
	
	
}
