package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.hibernate.Session;
//import org.hibernate.SessionFactory;

import model.order;
import model.book;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.orderService;
import service.bookService;
//import util.HibernateUtil;

/**
 * Servlet implementation class listOrdersServlet
 */
@WebServlet("/listOrdersServlet")
public class listOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listOrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
//		SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
//		Session session=sessionFactory.openSession();
//		session.beginTransaction();
//		PrintWriter out = response.getWriter();
//        out.println("<html><head><title>User Manager</title></head><body>");
        
        
		//PrintWriter out = response.getWriter();
		List<order> odrs = orderService.getAllOrders();
		
		JSONArray ja = new JSONArray();
		for(order i : odrs){
			JSONObject jo = new JSONObject();
			book bk = bookService.getBook(i.getISBN());
			jo.put("ISBN", i.getISBN());
			jo.put("bookname", bk.getBookName());
			jo.put("user", i.getUserName());
			jo.put("number", i.getNumber());
			jo.put("date", i.getDate());
			jo.put("price", i.getNumber() * bk.getPrice());
			ja.add(jo);
			//i.setPrice()
		}
		
		response.getWriter().println(ja.toString());
		response.getWriter().flush();
		response.getWriter().close();
	}

}
