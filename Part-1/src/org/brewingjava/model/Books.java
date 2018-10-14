package org.brewingjava.model;

public class Books {

	private int bookid;
	private String title;
	private float price;
	private String author;
	private String category;
	
	public Books() {
		bookid=0;
	}

	public Books(int bookid, String title, float price, String author, String category) {
		
		this.bookid = bookid;
		this.title = title;
		this.price = price;
		this.author = author;
		this.category = category;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Categories [bookid=" + bookid + ", title=" + title + ", price=" + price + ", author=" + author
				+ ", category=" + category + "]";
	}

}
