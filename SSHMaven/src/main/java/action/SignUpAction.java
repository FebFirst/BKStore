package action;

import java.util.Map;
//import java.util.concurrent.ExecutionException;

//import model.Order;

import org.apache.struts2.interceptor.SessionAware;
//import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

//import util.HibernateUtil;
import model.User;
import dao.UserDao;
public class SignUpAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
    private String password;
    private String passwdcmfrm;
    private User user;
    
    public String execute() throws Exception{
//      username = (String)userSession.get("username");
//      passWord = (String)userSession.get("password");

      user = UserDao.getUser(username);
      if(user.getUsername().equals("ERROR") && password.equals(passwdcmfrm)){
          user.setUsername(username);
          user.setPassword(password);
          UserDao.insertUser(user);
          return SUCCESS;
      }else{
          addFieldError("username","Username exists!");
          return ERROR;
      }
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

	public String getPasswdcmfrm() {
		return passwdcmfrm;
	}

	public void setPasswdcmfrm(String passwdcmfrm) {
		this.passwdcmfrm = passwdcmfrm;
	}
    
}
