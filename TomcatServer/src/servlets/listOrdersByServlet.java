package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.book;
import model.order;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.bookService;
import service.orderService;

/**
 * Servlet implementation class listOrdersByUserServlet
 */
@WebServlet("/listOrdersByServlet")
public class listOrdersByServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listOrdersByServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String username = (String)request.getSession().getAttribute("getByname");
		String date = (String)request.getSession().getAttribute("getBydate");
		String logname = (String)request.getSession().getAttribute("logname");
		request.getSession().removeAttribute("getByname");
		request.getSession().removeAttribute("getBydate");
		request.getSession().removeAttribute("logname");
		System.out.println(logname + "feblalala");
		double income = 0;
		List<order> odrs;
		if(username == null &&date == null){
			odrs = orderService.getOrdersByUser(logname);
		}else{
			if(username == null){
				odrs = orderService.getOrdersByDate(date);
			}
			else{
			odrs = orderService.getOrdersByUser(username);
			}
		}
		
		JSONArray ja = new JSONArray();
		for(order i : odrs){
			JSONObject jo = new JSONObject();
			book bk = bookService.getBook(i.getISBN());
			jo.put("ISBN", i.getISBN());
			jo.put("bookname", bk.getBookName());
			jo.put("user", i.getUserName());
			jo.put("number", i.getNumber());
			jo.put("date", i.getDate());
			//income = income +i.getNumber() * bk.getPrice();
			jo.put("price", i.getNumber() * bk.getPrice());
			ja.add(jo);
		}
	//	request.getSession().setAttribute("income", income);
		response.getWriter().println(ja.toString());
		response.getWriter().flush();
		response.getWriter().close();

		
	}

}
