package ridi.model.qna;

import org.springframework.stereotype.Repository;

@Repository
public class ReplyDto {
	private int no;
	private int boardId;
	private String reply;
	public ReplyDto() {
		super();
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	@Override
	public String toString() {
		return "ReplyDto [no=" + no + ", boardId=" + boardId + ", reply=" + reply + "]";
	}
	
	
}
