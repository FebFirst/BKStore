package dao;

/**
 * Created by apple on 16/6/5.
 */
import java.sql.Connection;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.procedure.ProcedureCall;

import model.Order;
import model.User;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class UserDao {
    public static boolean authentic(String username) {
        if (username != null && username.trim() != null) {

            SessionFactory sessionFactory = HibernateUtil.configureSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            String hql = "from User u where u.userName=:name";
//			String sql="SELECT U.username, U.password FROM user U where U.username='"+username+"'"+" and U.password='"+password+"'";
            Query query = session.createQuery(hql).setParameter("name", username);
            List<User> results = query.list();
            session.getTransaction().commit();
            session.close();
            if (results.size() == 1) {
                return true;
            }
        }
        return false;
    }

    public static User getUser(String username) {
    	System.out.println("DAO" + username);
        User usr = new User();
        SessionFactory sessionFactory = HibernateUtil.configureSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        // user=(Users) session.get(Users.class, username);
        String sql = "FROM User U WHERE U.userName='" + username + "' ";
        
        Query query = session.createQuery(sql);
        List<User> results = query.list();
        session.getTransaction().commit();
        session.close();
        if (results.size() == 0) {
            usr.setUsername("ERROR");
            usr.setPassword("ERROR");
            return usr;
        } else {
            usr = results.get(0);
            return usr;
        }
    }

    public static List<User> getAllUser() {
    	List<User> ordrs = new ArrayList<User>();
        Transaction trns = null;
        SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
        Session session=sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            ordrs = session.createQuery("from User").list();
           
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return ordrs;
    }
    public static boolean insertUser(User user) {
        Transaction transaction = null;
        if (authentic(user.getUsername())) {
            return false;
        } else {
            SessionFactory sessionFactory = HibernateUtil.configureSessionFactory();
            Session session = sessionFactory.openSession();
            try {
                transaction = session.beginTransaction();
                session.save(user);
                session.getTransaction().commit();
            }catch (RuntimeException e){
                if(transaction != null)
                    transaction.rollback();
                e.printStackTrace();
            }finally {
                session.flush();
                session.close();
            }
            return true;
        }
    }

    public static boolean updateUser(User user) {
        Transaction transaction = null;
        if(authentic(user.getUsername())){
            SessionFactory sessionFactory = HibernateUtil.configureSessionFactory();
            Session session = sessionFactory.openSession();
            try {
                transaction = session.beginTransaction();
                session.update(user);
                session.getTransaction().commit();
            }catch (RuntimeException e){
                if(transaction != null)
                    transaction.rollback();
                e.printStackTrace();
            } finally {
                session.flush();
                session.close();
            }
            return true;
        }
        return false;
    }

    public static boolean deleteUser(User user){
        Transaction transaction = null;
         if(authentic(user.getUsername())){
             SessionFactory sessionFactory = HibernateUtil.configureSessionFactory();
             Session session = sessionFactory.openSession();
             try {
                 transaction = session.beginTransaction();
                 session.delete(user);
                 session.getTransaction().commit();
             }catch (RuntimeException e){
                 if(transaction != null)
                     transaction.rollback();
                 e.printStackTrace();
             }finally {
                 session.flush();
                 session.close();
             }
             return true;
         }
         return false;
    }
}

