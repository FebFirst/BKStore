package action;

import java.util.Map;
import java.util.List;


import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import model.Cart;
import model.Order;
import dao.CartDao;
import dao.OrderDao;
public class AddOrderAction extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 1L;
	private Map<String ,Object> userSession;
	private String ID;
	private String username;
	public String execute() throws Exception{
		 if(ID == null){
			 System.out.println("biubiubiu");
			 List<Cart> ct = CartDao.getCartByUser(username.trim());
			 Order od = new Order();
			 for(Cart i : ct){
				 od.setDate(i.getDate());
				 od.setISBN(i.getISBN());
				 od.setNumber(i.getNumber());
				 od.setUserName(i.getUserName());
				 OrderDao.addOrder(od);
				 CartDao.deleteCart(i);
			 }
			 return SUCCESS;
		 }
		 else{
			 System.out.println("lalala");
			 Cart ct = CartDao.getCartByID(Integer.parseInt(ID));
			 Order od = new Order();
			 od.setDate(ct.getDate());
			 od.setISBN(ct.getISBN());
			 od.setNumber(ct.getNumber());
			 od.setUserName(ct.getUserName());
			 OrderDao.addOrder(od);
			 CartDao.deleteCart(ct);
			 return SUCCESS;
		 }
	 }
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		userSession = session;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public Map<String, Object> getUserSession() {
		return userSession;
	}
	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
