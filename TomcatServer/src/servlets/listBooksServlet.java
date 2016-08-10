package servlets;

import java.util.List;

import java.io.IOException;
//import java.io.PrintWriter;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import util.HibernateUtil;
import service.bookService;
import model.book;

/**
 * Servlet implementation class listBooksServlet
 */
@WebServlet("/listBooksServlet")
public class listBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listBooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();

		List<book> books = bookService.getAllBooks();
		
		JSONArray ja = new JSONArray();
		for(book i : books){
			JSONObject jo = new JSONObject();
			jo.put("ISBN",i.getISBN());
			jo.put("bookname", i.getBookName());
			jo.put("author", i.getAuthor());
			jo.put("price", i.getPrice());
			ja.add(jo);
		}
		

		if(ja.size() != 0){
		response.getWriter().println(ja.toString());
		response.getWriter().flush();
		response.getWriter().close();
		}else{
			String message = "No books";
			request.getSession().setAttribute("message", message);
			request.getSession().setAttribute("index", "adminHome.jsp");
			response.sendRedirect("error.jsp");
		}
	}

}
