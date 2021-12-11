package com.ssoh.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@152.70.233.96:1521:xe";
	String id = "SSOH";
	String pw = "dhtjdtlr103";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public MemberDao() {
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
		} catch (Exception e) {
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
	
	public MemberDto getOneMember(String userId, String userPw) {
		MemberDto memberDto = null;
		
		getConnection("SELECT * FROM PRACTICE_MEMBER WHERE ID = ? AND PASSWORD = ?");
		
		try {
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setNo(Integer.parseInt(rs.getString("no")));
				memberDto.setId(rs.getString("id"));
				memberDto.setPassword(rs.getString("password"));
				memberDto.setName(rs.getString("name"));
				memberDto.setZipcode(Integer.parseInt(rs.getString("zipcode")));
				memberDto.setAddress(rs.getString("address"));
				memberDto.setHp(rs.getString("hp"));
				memberDto.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeConnection(rs, pstmt, conn);
		return memberDto;
	}
	
	public MemberDto getOneMember(String userId) {
		MemberDto memberDto = null;
		
		getConnection("SELECT * FROM PRACTICE_MEMBER WHERE ID = ?");
		
		try {
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setNo(Integer.parseInt(rs.getString("no")));
				memberDto.setId(rs.getString("id"));
				memberDto.setPassword(rs.getString("password"));
				memberDto.setName(rs.getString("name"));
				memberDto.setZipcode(Integer.parseInt(rs.getString("zipcode")));
				memberDto.setAddress(rs.getString("address"));
				memberDto.setHp(rs.getString("hp"));
				memberDto.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeConnection(rs, pstmt, conn);
		return memberDto;
	}
	
	public int updateMember(MemberDto memberDto, boolean isChangePw) {
		int result = 0;
			try {
				if(isChangePw) {
					getConnection("UPDATE PRACTICE_MEMBER SET ZIPCODE = ?, ADDRESS = ?, HP = ?, EMAIL = ?, PASSWORD = ? WHERE ID = ?");
					pstmt.setInt(1,memberDto.getZipcode());
					pstmt.setString(2,memberDto.getAddress());
					pstmt.setString(3, memberDto.getHp());
					pstmt.setString(4, memberDto.getEmail());
					pstmt.setString(5, memberDto.getPassword());
					pstmt.setString(6, memberDto.getId());
					result = pstmt.executeUpdate();
				} else {
					getConnection("UPDATE PRACTICE_MEMBER SET ZIPCODE = ?, ADDRESS = ?, HP = ?, EMAIL = ? WHERE ID = ?");
					pstmt.setInt(1,memberDto.getZipcode());
					pstmt.setString(2,memberDto.getAddress());
					pstmt.setString(3, memberDto.getHp());
					pstmt.setString(4, memberDto.getEmail());
					pstmt.setString(5, memberDto.getId());
					result = pstmt.executeUpdate();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			closeConnection(pstmt,conn);
		return result;
	}
	
	public int deleteMember(String userId, String userPw) {
		int result = 0;
		getConnection("DELETE FROM PRACTICE_MEMBER WHERE ID = ? AND PASSWORD = ?");
		try {
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeConnection(pstmt,conn);
		return result;
	}
	
	public int insertMember(String userId, String userPw, String userName, int userZipcode, String userAddress, String userPhoneNumber, String userEmail) {
		int result = 0;
		getConnection("INSERT INTO PRACTICE_MEMBER VALUES(SEQ_PRACTICE_MEMBER.NEXTVAL,?,?,?,?,?,?,?)");
		try {
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			pstmt.setString(3, userName);
			pstmt.setInt(4, userZipcode);
			pstmt.setString(5, userAddress);
			pstmt.setString(6, userPhoneNumber);
			pstmt.setString(7, userEmail);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeConnection(pstmt, conn);
		return result;
	}
}
