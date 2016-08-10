package action;

import java.util.Map;
import java.util.Date;

//import model.Order;

import org.apache.struts2.interceptor.SessionAware;


import com.opensymphony.xwork2.ActionSupport;

//import util.HibernateUtil;
import model.Book;
import model.Cart;
import dao.BookDao;
import dao.CartDao;
import dao.UserDao;
public class BuyAction extends ActionSupport{
	private String ISBN;
    private String number;
    private String username;
    
    public String execute() throws Exception{
    	System.out.println(ISBN);
    	System.out.println(number);
    	System.out.println(username+username.length());
      String dt;
      Book bk = new Book();
      Date date = new Date();
      bk = BookDao.getBook(ISBN);
      dt= String.valueOf(date.getYear()) + "."
				+ String.valueOf(date.getMonth()) + "."
				+ String.valueOf(date.getDate());
      Cart odr = new Cart();
      odr.setDate(dt);
      odr.setISBN(ISBN);
      odr.setAuthor(bk.getAuthor());
      odr.setBookName(bk.getBookName());
      odr.setNumber(Integer.parseInt(number));
      odr.setUserName(username.trim());
      CartDao.addCart(odr);
      return SUCCESS;
    }

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
    
}
