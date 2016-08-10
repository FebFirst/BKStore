package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.user;
//import util.HibernateUtil;
import service.logInService;
/**
 * Servlet implementation class logInServlet
 */
@WebServlet("/logInServlet")
public class logInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logInServlet() {
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
		
		String username;
		String password;
		username = request.getParameter("logname");
		password = request.getParameter("password");
		//System.out.println(username+','+password);
		boolean res = logInService.authenticate(username, password);
		
		if(res){
			user usr=logInService.getUser(username);
			// request.setAttribute("user", user);
			// RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
			// dispatcher.forward(request, response);
			
			request.getSession().setAttribute("logname", usr.getUserName());
			//System.out.println(request.getSession().getAttribute("logname"));
			//request.getSession().removeAttribute("logname");
			//request.getSession().setAttribute("message", "Welcome, "+usr.getUserName());
			if(usr.getUserName().equals("feb")){
				response.sendRedirect("adminHome.jsp");
			}else{
			response.sendRedirect("userHome.jsp");
			}
			return;
		} else {
			String message="Username or Password do not match!";
			request.getSession().setAttribute("message", message);
			request.getSession().setAttribute("index", "logIn.jsp");
			response.sendRedirect("error.jsp");
			return;
		}
		
		
	}

}
