package com.ssoh.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FAQDao {
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@152.70.233.96:1521:xe";
	String id = "SSOH";
	String pw = "dhtjdtlr103";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public FAQDao() {
		super();
	}
	
	public FAQDao(String driver, String url, String id, String pw, Connection conn, PreparedStatement pstmt,
			ResultSet rs) {
		super();
		this.driver = driver;
		this.url = url;
		this.id = id;
		this.pw = pw;
		this.conn = conn;
		this.pstmt = pstmt;
		this.rs = rs;
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
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	
	public ArrayList<FAQDto> getAllFAQ(){
		ArrayList<FAQDto> faqList = new ArrayList<FAQDto>();
		try {
			getConnection("SELECT * FROM PRACTICE_FAQ ORDER BY NO DESC");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				FAQDto faqDto = new FAQDto();
				faqDto.setNo(rs.getInt("no"));
				faqDto.setSubject(rs.getString("subject"));
				faqDto.setContents(rs.getString("contents"));
				faqList.add(faqDto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection(rs, pstmt, conn);
		return faqList;
	}
}