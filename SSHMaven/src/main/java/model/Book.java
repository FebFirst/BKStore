package model;

/**
 * Created by apple on 16/6/4.
 */
public class Book {
    private String ISBN;
    private String bookName;
    private String author;
    private int cataID;
    private String catename;
    private double price;


    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    

    public int getCataID() {
		return cataID;
	}

	public void setCataID(int cataID) {
		this.cataID = cataID;
	}

	public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public String getCatename() {
		return catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

	public Book setBook(String ISBN, String bookname, String author, double price){
        Book bk = new Book();
        bk.setISBN(ISBN);
        bk.setBookName(bookname);
        bk.setAuthor(author);
        bk.setPrice(price);

        return bk;
    }


}
