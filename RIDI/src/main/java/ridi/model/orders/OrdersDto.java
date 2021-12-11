package ridi.model.orders;

import java.sql.Date;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import ridi.model.member.MemberDao;

@Repository
public class OrdersDto {
	private int no;
	private int order_Group_No;
	private String book_Name;
	private int QTY; 
	private int price;
	private String order_Person;
	private String shipping_Address;
	private String shipping_Stage;
	private String order_Date;
	private String seller;
	private String payCheck;
	private String book_Image;
	private int book_No;
	private int shipping_Fee;
	public OrdersDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrdersDto(int no, int order_Group_No, String book_Name, int qTY, int price, String order_Person,
			String shipping_Address, String shipping_Stage, String order_Date, String seller, String payCheck,
			String book_Image, int book_No, int shipping_Fee) {
		super();
		this.no = no;
		this.order_Group_No = order_Group_No;
		this.book_Name = book_Name;
		QTY = qTY;
		this.price = price;
		this.order_Person = order_Person;
		this.shipping_Address = shipping_Address;
		this.shipping_Stage = shipping_Stage;
		this.order_Date = order_Date;
		this.seller = seller;
		this.payCheck = payCheck;
		this.book_Image = book_Image;
		this.book_No = book_No;
		this.shipping_Fee = shipping_Fee;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getOrder_Group_No() {
		return order_Group_No;
	}
	public void setOrder_Group_No(int order_Group_No) {
		this.order_Group_No = order_Group_No;
	}
	public String getBook_Name() {
		return book_Name;
	}
	public void setBook_Name(String book_Name) {
		this.book_Name = book_Name;
	}
	public int getQTY() {
		return QTY;
	}
	public void setQTY(int qTY) {
		QTY = qTY;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getOrder_Person() {
		return order_Person;
	}
	public void setOrder_Person(String order_Person) {
		this.order_Person = order_Person;
	}
	public String getShipping_Address() {
		return shipping_Address;
	}
	public void setShipping_Address(String shipping_Address) {
		this.shipping_Address = shipping_Address;
	}
	public String getShipping_Stage() {
		return shipping_Stage;
	}
	public void setShipping_Stage(String shipping_Stage) {
		this.shipping_Stage = shipping_Stage;
	}
	public String getOrder_Date() {
		return order_Date;
	}
	public void setOrder_Date(String order_Date) {
		this.order_Date = order_Date;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getPayCheck() {
		return payCheck;
	}
	public void setPayCheck(String payCheck) {
		this.payCheck = payCheck;
	}
	public String getBook_Image() {
		return book_Image;
	}
	public void setBook_Image(String book_Image) {
		this.book_Image = book_Image;
	}
	public int getBook_No() {
		return book_No;
	}
	public void setBook_No(int book_No) {
		this.book_No = book_No;
	}
	public int getShipping_Fee() {
		return shipping_Fee;
	}
	public void setShipping_Fee(int shipping_Fee) {
		this.shipping_Fee = shipping_Fee;
	}
	
	
	
}
