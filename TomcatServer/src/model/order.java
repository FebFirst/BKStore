package model;

//import java.util.Date;

public class order {
	private int ID;
	private String userName;
	private String ISBN;
	private Integer number;
	private String date;
	
	
//	public void setUserID(int userid){
//		this.userID = userid;
//	}
	
	public void setUserName(String username){
		this.userName = username;
	}
	
	public void setISBN(String ISBN){
		this.ISBN = ISBN;
	}
	
	public void setNumber(int num){
		this.number = num;
	}
//	
//	public void setPrice(double pri){
//		this.price = pri;
//	}
//	
//	
	public String getUserName(){
		return userName;
	}
	
	public String getISBN(){
		return ISBN;
	}
	
	public Integer getNumber(){
		return number;
	}
	
	
//	public double getPrice(){
//		return price;
//	}
	@Override
	public String toString(){
		return "User [userName=" + userName +
				", ISBN=" + ISBN + ", number=" + number + "]";
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	

}
