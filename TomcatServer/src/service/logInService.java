package service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.user;
import util.HibernateUtil;

public class logInService {
	public static boolean authenticate(String username, String password) {
		// TODO Auto-generated method stub
		if(username!=null && username.trim()!=null && password!=null && password.trim()!="" ){
			
			SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			String hql = "from user u where u.userName=:name and u.passWord=:pass";
//			String sql="SELECT U.username, U.password FROM user U where U.username='"+username+"'"+" and U.password='"+password+"'";
			Query query = session.createQuery(hql).setParameter("name", username).setParameter("pass", password);
			List<user> results = query.list();
			if(results.size()==1){
				// session.getTransaction().commit();
				// session.close();
				return true;
			}
		}
		return false;
	}
	
	public static user getUser(String username) {
		// TODO Auto-generated method stub
		user usr=new user();
		SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		// user=(Users) session.get(Users.class, username);
		String sql="FROM user U WHERE U.userName='"+ username +"' ";
		Query query = session.createQuery(sql);
		List<user> results = query.list();
		if(results.size() == 0){
			usr.setUserName("ERROR");
			usr.setPassWord("ERROR");
			return usr;
		}else{
		usr=results.get(0);
		return usr;
		}
	}
}
