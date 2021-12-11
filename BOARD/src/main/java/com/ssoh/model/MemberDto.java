package com.ssoh.model;

public class MemberDto {
	private int no;
	private String id;
	private String password;
	private String name;
	private int zipcode;
	private String address;
	private String hp;
	private String email;
	
	public MemberDto() {
		super();
	}

	public MemberDto(int no, String id, String password, String name, int zipcode, String address, String hp, String email) {
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.zipcode = zipcode;
		this.address = address;
		this.hp = hp;
		this.email = email;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "MemberDto [no=" + no + ", id=" + id + ", password=" + password + ", name=" + name + ", zipcode="
				+ zipcode + ", address=" + address + ", hp=" + hp + ", email=" + email + "]";
	}
}
