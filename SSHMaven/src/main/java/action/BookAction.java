package action;

/**
 * Created by apple on 16/6/7.
 */
import java.util.List;
import java.util.Map;
//import java.util.concurrent.ExecutionException;

//import model.Order;

import org.apache.struts2.interceptor.SessionAware;
//import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;

//import util.HibernateUtil;
import model.Book;
import dao.BookDao;

public class BookAction extends ActionSupport implements SessionAware{
   
	private Map<String, Object> bookSession;
    private String ISBN;
    private String bookName;
    private String author;
    private double price;
    private int cateID;
    private Book bk;
    //ISBN = (String)bookSession.get("ISBN");
    public String execute() throws Exception{//add
    	
    	Book bk = new Book();
        if(BookDao.getBook(ISBN) != null){
            addFieldError("Error", "Book exists!");
            return ERROR;
        }else{
            bk.setISBN(ISBN);
            bk.setBookName(bookName);
            bk.setAuthor(author);
            bk.setPrice(price);
            bk.setCataID(cateID);
            BookDao.addBook(bk);
            return SUCCESS;
        }
    }

    public String executeDelete() throws Exception{//delete
        Book buk = BookDao.getBook(ISBN);
        if(buk.getISBN() != null &&buk.getISBN().length()>0){
            BookDao.deleteBook(ISBN);
            return SUCCESS;
        }else {
            addFieldError("Error","Book does not exist!");
            return ERROR;
        }
    }

    public String executeUpdate() throws Exception{//update
    	Book bk = new Book();
    	 Book buk = BookDao.getBook(ISBN);
         if(buk.getISBN() != null &&buk.getISBN().length()>0){
        	
        	bk.setISBN(ISBN);
        	if(bookName != null && bookName.length()>0)
        		bk.setBookName(bookName);
        	else
        		bk.setBookName(buk.getBookName());
        	
        	if(author != null && author.length()>0)
        		bk.setAuthor(author);
        	else
        		bk.setAuthor(buk.getAuthor());
        	if(price == 0)
        		bk.setPrice(buk.getPrice());
        	else
        		bk.setPrice(price);
        	bk.setCataID(cateID);
        	System.out.println(cateID+"lalala");	
            BookDao.updateBook(bk);
            System.out.println(ISBN+"lalala");
            return SUCCESS;
        }else {
            addFieldError("Error","Book does not exist!");
            return ERROR;
        }
    }

    public String executeListBook() throws Exception{
        List<Book> bks = BookDao.getAllBooks();
//        JSONArray ja = new JSONArray();
//        for(Book i : bks){
//            JSONObject jo = new JSONObject();
//            jo.put("ISBN",i.getISBN());
//            jo.put("bookname", i.getBookName());
//            jo.put("author", i.getAuthor());
//            jo.put("price", i.getPrice());
//            ja.add(jo);
//        }
        
        return SUCCESS;
    }
    public void setSession(Map<String, Object> map) {
        bookSession = map;
    }
    public Map<String, Object> getBookSession() {
		return bookSession;
	}

	public void setBookSession(Map<String, Object> bookSession) {
		this.bookSession = bookSession;
	}

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
	
	public int getCateID() {
		return cateID;
	}

	public void setCateID(int cateID) {
		this.cateID = cateID;
	}

	public Book getBk() {
		return bk;
	}

	public void setBk(Book bk) {
		this.bk = bk;
	}
}
