package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.bookService;
import model.book;
import model.order;
/**
 * Servlet implementation class sessionOrdersServlet
 */
@WebServlet("/sessionOrdersServlet")
public class sessionOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sessionOrdersServlet() {
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
		order ordr = (order)request.getSession().getAttribute("order");
		JSONObject jo = new JSONObject();
		JSONArray ja = new JSONArray();
		book bk = bookService.getBook(ordr.getISBN());
		jo.put("ISBN", ordr.getISBN());
		jo.put("bookname", bk.getBookName());
		jo.put("author", bk.getAuthor());
		jo.put("number", ordr.getNumber());
		jo.put("date", ordr.getDate());
		jo.put("price", ordr.getNumber() * bk.getPrice());
		ja.add(jo);
		
		response.getWriter().println(ja.toString());
		response.getWriter().flush();
		response.getWriter().close();
	}

}
