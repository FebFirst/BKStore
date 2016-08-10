package action;

import java.util.List;


import java.io.PrintWriter;
//import java.util.concurrent.ExecutionException;

//import model.Order;

//import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

//import util.HibernateUtil;
import model.Book;
import dao.BookDao;
import dao.CateDao;

public class ListBookAction extends ActionSupport{
	private List<Book> bks;
	
	public String executeListBook() throws Exception{
		System.out.println("lalala");
	        bks = BookDao.getAllBooks();
	        System.out.println(bks.get(0).getCataID() + "aaa");
	        for(Book i : bks){
	        	i.setCatename(CateDao.getCate(i.getCataID()));
	        }
	        return "success";
	    }
	public String executeListBook2() throws Exception{
        bks = BookDao.getAllBooks();
        //a = bks.get(0).getBookName();
//        JSONArray ja = new JSONArray();
//        for(Book i : bks){
//            JSONObject jo = new JSONObject();
//            jo.put("ISBN",i.getISBN());
//            jo.put("bookname", i.getBookName());
//            jo.put("author", i.getAuthor());
//            jo.put("price", i.getPrice());
//            ja.add(jo);
//        }
//        PrintWriter out = ServletActionContext.getResponse().getWriter();  
//        out.println(ja.toString());
//        out.flush(); 
//        out.close(); 
        return null;
    }
	 public List<Book> getBks() {
			return bks;
		}
	 
		public void setBks(List<Book> bks) {
			this.bks = bks;
		}
}
