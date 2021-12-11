package ridi.model.book;

import java.sql.Date;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Repository
public class BookDto {
	private int no;
	private String book_Name;
	private int price;
	private int stock;
	private int star_Rating;
	private String estimated_Time;
	private int shipping_Price;
	private String category;
	private String publication_Date;
	private int pages;
	private String author;
	private String book_Intro;
	private String book_Image;
	private String book_RealImage;
	private int count;
	public BookDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookDto(int no, String book_Name, int price, int stock, int star_Rating, String estimated_Time,
			int shipping_Price, String category, String publication_Date, int pages, String author, String book_Intro,
			String book_Image, String book_RealImage, int count) {
		super();
		this.no = no;
		this.book_Name = book_Name;
		this.price = price;
		this.stock = stock;
		this.star_Rating = star_Rating;
		this.estimated_Time = estimated_Time;
		this.shipping_Price = shipping_Price;
		this.category = category;
		this.publication_Date = publication_Date;
		this.pages = pages;
		this.author = author;
		this.book_Intro = book_Intro;
		this.book_Image = book_Image;
		this.book_RealImage = book_RealImage;
		this.count = count;
	}
	@Override
	public String toString() {
		return "BookDto [no=" + no + ", book_Name=" + book_Name + ", price=" + price + ", stock=" + stock
				+ ", star_Rating=" + star_Rating + ", estimated_Time=" + estimated_Time + ", shipping_Price="
				+ shipping_Price + ", category=" + category + ", publication_Date=" + publication_Date + ", pages="
				+ pages + ", author=" + author + ", book_Intro=" + book_Intro + ", book_Image=" + book_Image
				+ ", book_RealImage=" + book_RealImage + ", count=" + count + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getBook_Name() {
		return book_Name;
	}
	public void setBook_Name(String book_Name) {
		this.book_Name = book_Name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getStar_Rating() {
		return star_Rating;
	}
	public void setStar_Rating(int star_Rating) {
		this.star_Rating = star_Rating;
	}
	public String getEstimated_Time() {
		return estimated_Time;
	}
	public void setEstimated_Time(String estimated_Time) {
		this.estimated_Time = estimated_Time;
	}
	public int getShipping_Price() {
		return shipping_Price;
	}
	public void setShipping_Price(int shipping_Price) {
		this.shipping_Price = shipping_Price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPublication_Date() {
		return publication_Date;
	}
	public void setPublication_Date(String publication_Date) {
		this.publication_Date = publication_Date;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBook_Intro() {
		return book_Intro;
	}
	public void setBook_Intro(String book_Intro) {
		this.book_Intro = book_Intro;
	}
	public String getBook_Image() {
		return book_Image;
	}
	public void setBook_Image(String book_Image) {
		this.book_Image = book_Image;
	}
	public String getBook_RealImage() {
		return book_RealImage;
	}
	public void setBook_RealImage(String book_RealImage) {
		this.book_RealImage = book_RealImage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
		
}
