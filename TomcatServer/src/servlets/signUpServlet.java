package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.SessionFactory;

import model.user;
import util.HibernateUtil;
import service.logInService;
/**
 * Servlet implementation class signUpServlet
 */
@WebServlet("/signUpServlet")
public class signUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signUpServlet() {
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
		String passWdCfrm;
		
		
		username = request.getParameter("username");
		password = request.getParameter("password");
		passWdCfrm = request.getParameter("passwdchk");
		
//		
//		request.getSession().setAttribute("passwd1", password);
//		request.getSession().setAttribute("passwd2", passWdCfrm);
//		response.sendRedirect("error.jsp");
		if(logInService.getUser(username).getUserName().equals("ERROR")){
			if(password.equals(passWdCfrm)){
				user usr = new user();
				usr.setUserName(username);
				usr.setPassWord(password);
				
				
				    
				SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
				Session session=sessionFactory.openSession();
				session.beginTransaction();
				session.save(usr);
				session.getTransaction().commit();
				session.close();
				
				
				//request.getSession().setAttribute("message", usr.getUserName()+" "+usr.getPassWord());
				response.sendRedirect("home.jsp");
			}else{
				//System.out.print("Inconsistent password!");
				request.getSession().setAttribute("message", "ERROR: Inconsistent password!");
				response.sendRedirect("error.jsp");
			}
		}else{
			request.getSession().setAttribute("message", "ERROR: Username exists!");
			request.getSession().setAttribute("index", "signUp.jsp");
			response.sendRedirect("error.jsp");
		
	}
	}

}
