package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Category;
import util.HibernateUtil;
public class CateDao {
	public static String getCate(int ID){
		 Category cate = new Category();
		 SessionFactory sessionFactory = HibernateUtil.configureSessionFactory();
	     Session session = sessionFactory.openSession();
	     session.beginTransaction();
	     String sql = "FROM Category C WHERE C.cataID='" + ID + "' ";
	     Query query = session.createQuery(sql);
	        List<Category> results = query.list();
	        session.getTransaction().commit();
	        session.close();
	        if (results.size() == 0) {
	            cate.setCataID(-1);
	            cate.setName("ERROR");
	            return cate.getName();
	        } else {
	            cate = results.get(0);
	            return cate.getName();
	        }
	}
	public static int getID(String name){
		 Category cate = new Category();
		 SessionFactory sessionFactory = HibernateUtil.configureSessionFactory();
	     Session session = sessionFactory.openSession();
	     session.beginTransaction();
	     String sql = "FROM Category C WHERE C.name='" + name + "' ";
	     Query query = session.createQuery(sql);
	        List<Category> results = query.list();
	        session.getTransaction().commit();
	        session.close();
	        if (results.size() == 0) {
	            cate.setCataID(-1);
	            cate.setName("ERROR");
	            return cate.getCataID();
	        } else {
	            cate = results.get(0);
	            return cate.getCataID();
	        }
	}
}
