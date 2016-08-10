package action;

import java.util.List;
import java.util.Map;
//import java.util.concurrent.ExecutionException;
import org.apache.struts2.interceptor.SessionAware;
//import model.Order;


//import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;
//import net.sf.json.JSONObject;
//import util.HibernateUtil;
import model.Book;
import model.Order;
import dao.BookDao;
import dao.OrderDao;
public class HelperAction extends ActionSupport implements SessionAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> userSession;
    private List<Order> ordr;
    private String username;
    private String date;
    
    public String execute() throws Exception{
    	if(username != null){
    		userSession.put("name", username);
    	}else if(date != null){
    		userSession.put("date", date);
    	}
    	return SUCCESS;
    }
    public String executePara() throws Exception{
    	Integer num = 0;
    	double earn = 0;
    	if(username != null){
    		System.out.println("biubiubiu1");
    		ordr = OrderDao.getOrdersByUser(username);
    		for(Order i : ordr){
    			Book bk = BookDao.getBook(i.getISBN());
    			i.setAuthor(bk.getAuthor());
    			i.setBookName(bk.getBookName());
    			i.setPrice(i.getNumber() * bk.getPrice());
    			num += i.getNumber();
    			earn += i.getPrice();
    		}
    		System.out.println("biubiubiu2");
    	}else if(date != null){
    		
    		ordr = OrderDao.getOrdersByDate(date);
    		for(Order i : ordr){
    			Book bk = BookDao.getBook(i.getISBN());
    			i.setAuthor(bk.getAuthor());
    		    i.setBookName(bk.getBookName());
    			i.setPrice(i.getNumber() * bk.getPrice());
    			num += i.getNumber();
    			earn += i.getPrice();
    		}
    		
    	}
//    	System.out.println("lalala2");
//    	userSession.put("number", String.valueOf(num));
//    	System.out.println("lalala1");
//    	userSession.put("earn", String.valueOf(earn));
    	return SUCCESS;
    }
    
	
	public Map<String, Object> getUserSession() {
		return userSession;
	}


	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}


	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Order> getOrdr() {
		return ordr;
	}
	public void setOrdr(List<Order> ordr) {
		this.ordr = ordr;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		userSession = session;
	}
	
}