package model;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//@Entity
public class user {
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO
	private String userName;
	private String passWord;
	
//	public void setUserID(int userid){
//		this.userID = userid;
//	}
	
	public void setUserName(String username){
		this.userName = username;
	}
	
	public void setPassWord(String password){
		this.passWord = password;
	}
	
	
	
//	public int getUserID(){
//		return userID;
//	}
	
	public String getUserName(){
		return userName;
	}
	
	public String getPassWord(){
		return passWord;
	}
	
	@Override
	public String toString(){
		return "User [userName=" + userName +
				", passWord=" + passWord + "]";
	}
}
