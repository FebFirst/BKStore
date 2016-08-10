package action;

import java.util.List;
import java.util.Map;
//import java.util.concurrent.ExecutionException;

//import model.Order;


//import org.hibernate.Session;

//import com.opensymphony.xwork2.ActionSupport;
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//import util.HibernateUtil;
import model.Book;
import model.Cart;
import model.Order;
import dao.BookDao;
import dao.CartDao;
import dao.OrderDao;
public class CartAction {
	 private Map<String, Object> OrderSession;
	    private List<Cart> ct;
	   // private JSONArray ja;
	   // private String
	    public String execute() throws Exception{
	        ct = CartDao.getAllCart();
			for(Cart i : ct){
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
		
		public List<Cart> getCt() {
			return ct;
		}
		public void setCt(List<Cart> ct) {
			this.ct = ct;
		}
}
