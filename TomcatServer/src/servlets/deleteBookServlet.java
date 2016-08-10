package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.book;
import service.bookService;

/**
 * Servlet implementation class updateBookServlet
 */
@WebServlet("/deleteBookServlet")
public class deleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteBookServlet() {
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
		String message;
		ISBN = request.getParameter("ISBN");
		
		if(bookService.getBook(ISBN) == null){
			message="Error: Book does NOT exist!";
		}else{
			bookService.deleteBook(ISBN);
			message="Successfully removed!";
			
		}
		request.getSession().setAttribute("message", message);
		request.getSession().setAttribute("index", "adminHome.jsp");
		response.sendRedirect("error.jsp");
		return;
	}

}
