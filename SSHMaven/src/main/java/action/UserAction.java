package action;

import java.util.List;
/**
 * Created by apple on 16/6/7.
 */
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
import java.util.Map;
//import java.util.concurrent.ExecutionException;

//import model.Order;

import org.apache.struts2.interceptor.SessionAware;
//import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

//import util.HibernateUtil;
import model.User;
import dao.UserDao;
public class UserAction extends ActionSupport implements SessionAware{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String ,Object> userSession;
	private List<User> usr;
    private String username;
    private String password;
    private String phone;
    private String email;
    private User user;
   // private UserDao userDao;


    public String execute() throws Exception{

    	
        user = UserDao.getUser(username);
//        System.out.println(username);
//        System.out.println(password);
//        System.out.println(user.getUsername());
//        System.out.println(user.getPassword());
        if(user.getUsername().equals("ERROR") || !user.getPassword().equals(password)){
        	System.out.println(user.getUsername()+" "+user.getPassword());
        	System.out.println("lalala222");
            addFieldError("username","Invalid password or username!");
            
            return ERROR;
        }else if(user.getUsername().equals("feb")){
        	System.out.println("lalala");
        	 userSession.put("username", user);
        	return "admin";
        }else{
        	userSession.put("username", user);
        	System.out.println("Elegant");
            return SUCCESS;
        }

    }

    public String executeSignUp() throws Exception{
//        username = (String)userSession.get("username");
//        passWord = (String)userSession.get("password");

        user = UserDao.getUser(username);
        if(user.getUsername().equals("ERROR")){
            user.setUsername(username);
            user.setPassword(password);
            UserDao.insertUser(user);
            return SUCCESS;
        }else{
            addFieldError("Error","Username exists!");
            return ERROR;
        }
        
    }
    public String update() throws Exception{
   	 System.out.println(username + "Elegantly");
//      	System.out.println(phone + "Elegantly");
//      	System.out.println(email + "Elegantly");
    	 user = UserDao.getUser(username.trim());
    	// System.out.println("get");
    	 if(user.getUsername().equals("ERROR")){
    	//	 System.out.println("ERRORs");
    		 addFieldError("Error","Username exists!");
             return ERROR;
         }else{
        	 user.setUsername(username.trim());
        	 if(password != null &&password.length()>0)
        		 user.setPassword(password);
        	 else
        		 user.setPassword(user.getPassWord());
        	 if(phone != null&&phone.length()>0)
        		 user.setPhone(phone);
        	 else
        		 user.setPhone(user.getPhone());
        	 if(email != null&&email.length()>0)
        		 user.setEmail(email);
        	 else
        		 user.setEmail(user.getEmail());
             UserDao.updateUser(user);
             userSession.put("username", user);
             return SUCCESS;
         }
    }
    public String getUsers() throws Exception{
    	usr = UserDao.getAllUser();
    	 System.out.println(usr.size() + "size");
    	 System.out.println(usr.get(0).getUserName() + "name");
    	return SUCCESS;
    }
    public void setSession(Map<String, Object> map) {
        userSession = map;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<User> getUsr() {
		return usr;
	}

	public void setUsr(List<User> usr) {
		this.usr = usr;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    
    
}
