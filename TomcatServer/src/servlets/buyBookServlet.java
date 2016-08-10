package servlets;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.orderService;
import model.order;
/**
 * Servlet implementation class buyBookServlet
 */
@WebServlet("/buyBookServlet")
public class buyBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buyBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String ISBN;
		String username;
		String dat;
		int num;
		Date date= new Date();
		ISBN = request.getParameter("ISBN");
		username = (String)request.getSession().getAttribute("logname");
		num = Integer.valueOf(request.getParameter("number"));
		dat= String.valueOf(date.getYear()) + "."
				+ String.valueOf(date.getMonth()) + "."
				+ String.valueOf(date.getDate());
		
		order odr = new order();
		odr.setDate(dat);
		odr.setISBN(ISBN);
		odr.setNumber(num);
		odr.setUserName(username);
		//orderService.addOrder(odr);
		
		String message="Successfully added to cart!";
		request.getSession().setAttribute("order", odr);
		request.getSession().setAttribute("message", message);
		request.getSession().setAttribute("index", "userHome.jsp");
		response.sendRedirect("error.jsp");
		return;
	}

}
