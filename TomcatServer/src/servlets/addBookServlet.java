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
 * Servlet implementation class addBookServlet
 */
@WebServlet("/addBookServlet")
public class addBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addBookServlet() {
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
		String bk;
		String athr;
		String message;
		double prs;
		
		ISBN = request.getParameter("ISBN");
		bk = request.getParameter("bookname");
		athr = request.getParameter("author");
		prs = Double.valueOf(request.getParameter("price"));
		book buk = new book();
		buk.setISBN(ISBN);
		buk.setAuthor(athr);
		buk.setBookName(bk);
		buk.setPrice(prs);
		if(bookService.getBook(ISBN) != null){
			message="Error: Book exists!";
		}else{
			bookService.addBook(buk);
			message="Successfully added!";
			
		}
		request.getSession().setAttribute("message", message);
		request.getSession().setAttribute("index", "adminHome.jsp");
		response.sendRedirect("error.jsp");
		return;
	}

}
