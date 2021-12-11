package ridi.model.qna;

import org.springframework.stereotype.Repository;

@Repository
public class SearchDto {
	private String field;
	private String searchWord;
	private int start;
	private int end;
	public SearchDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return "SearchDto [field=" + field + ", searchWord=" + searchWord + ", start=" + start + ", end=" + end + "]";
	}
	
	
}
