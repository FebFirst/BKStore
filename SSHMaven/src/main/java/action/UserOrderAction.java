package action;

import java.util.List;
import java.util.Map;
//import java.util.concurrent.ExecutionException;

//import model.Order;


//import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;
//import net.sf.json.JSONObject;
//import util.HibernateUtil;
import model.Book;
import model.Order;
import dao.BookDao;
import dao.OrderDao;
public class UserOrderAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> OrderSession;
    private List<Order> ordr;
    private String username;
   // private String
    public String execute() throws Exception{
        ordr = OrderDao.getAllOrders();
		for(Order i : ordr){
			//JSONObject jo = new JSONObject();
			Book bk = BookDao.getBook(i.getISBN());
			i.setAuthor(bk.getAuthor());
		    i.setBookName(bk.getBookName());
			i.setPrice(i.getNumber() * bk.getPrice());
		}
        return "success";

    }
    public void setSession(Map<String, Object> map) {
        OrderSession = map;
    }
	public Map<String, Object> getOrderSession() {
		return OrderSession;
	}
	public void setOrderSession(Map<String, Object> orderSession) {
		OrderSession = orderSession;
	}
	public List<Order> getOrdr() {
		return ordr;
	}
	public void setOrdr(List<Order> ordr) {
		this.ordr = ordr;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
