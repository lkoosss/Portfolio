package com.ssoh.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDao {
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@152.70.233.96:1521:xe";
	String id = "SSOH";
	String pw = "dhtjdtlr103";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public BoardDao() {
		super();
	}
	
	public void getConnection(String sql) {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pw);
			pstmt = conn.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection(PreparedStatement pstmt, Connection conn) {
		try {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public BoardDto getOneBoard(int no) {
		BoardDto boardDto = new BoardDto();
		
		try {
			getConnection("UPDATE PRACTICE_BOARD SET READCOUNT = READCOUNT +1 WHERE NO = ?");
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			
			getConnection("SELECT * FROM PRACTICE_BOARD WHERE NO = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				boardDto.setNo(rs.getInt("no"));
				boardDto.setId(rs.getString("id"));
				boardDto.setName(rs.getString("name"));
				boardDto.setEmail(rs.getString("email"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setContents(rs.getString("contents"));
				boardDto.setPostGroup(rs.getInt("postGroup"));
				boardDto.setReStep(rs.getInt("reStep"));
				boardDto.setReLevel(rs.getInt("reLevel"));
				boardDto.setReadCount(rs.getInt("readCount"));
				boardDto.setRegDate(rs.getString("regDate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeConnection(rs, pstmt, conn);
		return boardDto;
	}
	
	public ArrayList<BoardDto> getAllBoard(int firstSearchNum, int lastSearchNum) {
		ArrayList<BoardDto> boardList = new ArrayList<BoardDto>();
		getConnection("SELECT * FROM (SELECT B.*, ROWNUM AS NUM FROM "
									+ "(SELECT * FROM PRACTICE_BOARD ORDER BY POSTGROUP DESC, RELEVEL ASC) B) "
									+ "WHERE NUM >=? AND NUM <=?");
		try {
			pstmt.setInt(1, firstSearchNum);
			pstmt.setInt(2, lastSearchNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setNo(rs.getInt("no"));
				boardDto.setId(rs.getString("id"));
				boardDto.setName(rs.getString("name"));
				boardDto.setEmail(rs.getString("email"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setContents(rs.getString("contents"));
				boardDto.setPostGroup(rs.getInt("postGroup"));
				boardDto.setReStep(rs.getInt("reStep"));
				boardDto.setReLevel(rs.getInt("reLevel"));
				boardDto.setReadCount(rs.getInt("readCount"));
				boardDto.setRegDate(rs.getString("regDate"));
				boardList.add(boardDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeConnection(pstmt, conn);
		return boardList;
	}
	
	public ArrayList<BoardDto> getAllBoard(int firstSearchNum, int lastSearchNum, String field, String searchWord) {
		ArrayList<BoardDto> boardList = new ArrayList<BoardDto>();
		getConnection("SELECT * FROM (SELECT B.*, ROWNUM AS NUM FROM "+
					"(SELECT * FROM PRACTICE_BOARD WHERE "+field+" LIKE ? ORDER BY POSTGROUP DESC, RELEVEL ASC) B)"+
					" WHERE NUM >= ? AND NUM <= ?");
		try {
			pstmt.setString(1, "%"+searchWord+"%");
			pstmt.setInt(2, firstSearchNum);
			pstmt.setInt(3, lastSearchNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setNo(rs.getInt("no"));
				boardDto.setId(rs.getString("id"));
				boardDto.setName(rs.getString("name"));
				boardDto.setEmail(rs.getString("email"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setContents(rs.getString("contents"));
				boardDto.setPostGroup(rs.getInt("postGroup"));
				boardDto.setReStep(rs.getInt("reStep"));
				boardDto.setReLevel(rs.getInt("reLevel"));
				boardDto.setReadCount(rs.getInt("readCount"));
				boardDto.setRegDate(rs.getString("regDate"));
				boardList.add(boardDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeConnection(pstmt, conn);
		return boardList;
	}
	
	public int getBoardLength() {
		int boardLength = 0;
		try {
			getConnection("SELECT COUNT(NO) FROM PRACTICE_BOARD");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				boardLength = rs.getInt("COUNT(NO)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardLength;
	}
	
	public int getBoardLength(String field, String searchWord) {
		int boardLength = 0;
		try {
			getConnection("SELECT COUNT(NO) FROM PRACTICE_BOARD WHERE "+field+" LIKE ?");
			pstmt.setString(1, "%"+searchWord+"%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				boardLength = rs.getInt("COUNT(NO)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardLength;
	}
	
	public int updateBoard(String subject,String contents, int no) {
		int result = 0;
		getConnection("UPDATE PRACTICE_BOARD SET SUBJECT = ?, CONTENTS = ? WHERE NO = ?");
		try {
			pstmt.setString(1, subject);
			pstmt.setString(2, contents);
			pstmt.setInt(3, no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeConnection(pstmt, conn);
		return result;
	}
	
	public int delteBoard(int no, String id, String name) {
		int result = 0;
		getConnection("DELETE FROM PRACTICE_BOARD WHERE NO = ? AND ID = ? AND NAME = ?");
		try {
			pstmt.setInt(1, no);
			pstmt.setString(2, id);
			pstmt.setString(3, name);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeConnection(pstmt,conn);
		return result;
	}
	
	public int insertBoard(BoardDto boardDto) {
		int result = 0;
		int postGroup = 0;
		try {
			getConnection("SELECT MAX(POSTGROUP) FROM PRACTICE_BOARD");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				postGroup = rs.getInt("max(postgroup)") + 1;
			}
			
			getConnection("INSERT INTO PRACTICE_BOARD VALUES(SEQ_PRACTICE_BOARD.NEXTVAL,?,?,?,?,?,?,?,?,?,SYSDATE)");
			pstmt.setString(1, boardDto.getId());
			pstmt.setString(2, boardDto.getName());
			pstmt.setString(3, boardDto.getEmail());
			pstmt.setString(4, boardDto.getSubject());
			pstmt.setString(5, boardDto.getContents());
			pstmt.setInt(6, postGroup);
			pstmt.setInt(7, 0);
			pstmt.setInt(8, 1);
			pstmt.setInt(9, 0);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeConnection(pstmt, conn);
		return result;
	}
	
	public int insertReplyToBoard(BoardDto boardDto) {
		int result = 0;
		try {
			
			getConnection("SELECT POSTGROUP,RESTEP,RELEVEL FROM PRACTICE_BOARD WHERE NO = ?");
			pstmt.setInt(1, boardDto.getNo());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				boardDto.setPostGroup(rs.getInt("postGroup"));
				boardDto.setReStep(rs.getInt("reStep")+1);
				boardDto.setReLevel(rs.getInt("reLevel")+1);
			}
			getConnection("UPDATE PRACTICE_BOARD SET RELEVEL = RELEVEL + 1 WHERE POSTGROUP = ? AND RELEVEL >= ?");
			pstmt.setInt(1, boardDto.getPostGroup());
			pstmt.setInt(2, boardDto.getReLevel());
			pstmt.executeUpdate();
			
			getConnection("INSERT INTO PRACTICE_BOARD VALUES(SEQ_PRACTICE_BOARD.NEXTVAL,?,?,?,?,?,?,?,?,?,SYSDATE)");
			pstmt.setString(1, boardDto.getId());
			pstmt.setString(2, boardDto.getName());
			pstmt.setString(3, boardDto.getEmail());
			pstmt.setString(4, boardDto.getSubject());
			pstmt.setString(5, boardDto.getContents());
			pstmt.setInt(6, boardDto.getPostGroup());
			pstmt.setInt(7, boardDto.getReStep());
			pstmt.setInt(8, boardDto.getReLevel());
			pstmt.setInt(9, 0);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeConnection(rs, pstmt, conn);
		return result;
	}
}
