package ridi.model.member;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Repository
public class MemberDto {
	private int no;
	private String name;
	private String RRN;
	private String rrn_First;
	private String rrn_Last;
	private String id; 
	private String password;
	private String email;
	private String gender;
	private int zipcode;
	private String address;
	private String address01;
	private String address02;    
	private String hp;
	private String hp_First;
	private String hp_Middle;
	private String hp_Last;
	private String creation_Date;
	private int cash;
	private int minusCash;
	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberDto(int no, String name, String rRN, String rrn_First, String rrn_Last, String id, String password,
			String email, String gender, int zipcode, String address, String address01, String address02, String hp,
			String hp_First, String hp_Middle, String hp_Last, String creation_Date, int cash, int minusCash) {
		super();
		this.no = no;
		this.name = name;
		RRN = rRN;
		this.rrn_First = rrn_First;
		this.rrn_Last = rrn_Last;
		this.id = id;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.zipcode = zipcode;
		this.address = address;
		this.address01 = address01;
		this.address02 = address02;
		this.hp = hp;
		this.hp_First = hp_First;
		this.hp_Middle = hp_Middle;
		this.hp_Last = hp_Last;
		this.creation_Date = creation_Date;
		this.cash = cash;
		this.minusCash = minusCash;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRRN() {
		return RRN;
	}
	public void setRRN(String rRN) {
		RRN = rRN;
	}
	public String getRrn_First() {
		return rrn_First;
	}
	public void setRrn_First(String rrn_First) {
		this.rrn_First = rrn_First;
	}
	public String getRrn_Last() {
		return rrn_Last;
	}
	public void setRrn_Last(String rrn_Last) {
		this.rrn_Last = rrn_Last;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress01() {
		return address01;
	}
	public void setAddress01(String address01) {
		this.address01 = address01;
	}
	public String getAddress02() {
		return address02;
	}
	public void setAddress02(String address02) {
		this.address02 = address02;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getHp_First() {
		return hp_First;
	}
	public void setHp_First(String hp_First) {
		this.hp_First = hp_First;
	}
	public String getHp_Middle() {
		return hp_Middle;
	}
	public void setHp_Middle(String hp_Middle) {
		this.hp_Middle = hp_Middle;
	}
	public String getHp_Last() {
		return hp_Last;
	}
	public void setHp_Last(String hp_Last) {
		this.hp_Last = hp_Last;
	}
	public String getCreation_Date() {
		return creation_Date;
	}
	public void setCreation_Date(String creation_Date) {
		this.creation_Date = creation_Date;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	public int getMinusCash() {
		return minusCash;
	}
	public void setMinusCash(int minusCash) {
		this.minusCash = minusCash;
	}
	
	
	
}
