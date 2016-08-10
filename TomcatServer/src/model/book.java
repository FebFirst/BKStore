package model;

public class book {
	private String ISBN;
	private String bookName;
	private String author;
	private double price;
	
	public void setISBN(String ISBN){
		this.ISBN = ISBN;
	}
	
	public void setBookName(String bookname){
		this.bookName = bookname;
	}
	
	public void setAuthor(String author){
		this.author = author;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	
	public String getISBN(){
		return ISBN;
	}
	
	public String getBookName(){
		return bookName;
	}
	
	public String getAuthor(){
		return author;
	}
	
	public double getPrice(){
		return price;
	}
	
	@Override
	public String toString(){
		return "Book [ISBN=" + ISBN + ", bookName=" + bookName +
				", author=" + author + ", price=" + price + "]";
	}
}
