package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Cart;
import util.HibernateUtil;
public class CartDao {
	public static void addCart(Cart ct) {
        Transaction trns = null;
        SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
        Session session=sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            session.save(ct);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public static void deleteCart(Cart ct) {
        Transaction trns = null;
        SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
        Session session=sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            session.delete(ct);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public static void updateCart(Cart ct) {
        Transaction trns = null;
        SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
        Session session=sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            session.update(ct);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public static List<Cart> getAllCart() {
        List<Cart> ordrs = new ArrayList<Cart>();
        Transaction trns = null;
        SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
        Session session=sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            ordrs = session.createQuery("from Cart").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return ordrs;
    }
    public static List<Cart> getCartByUser(String username) {
        List<Cart> ordrs = new ArrayList<Cart>();
        Transaction trns = null;
        SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
        Session session=sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Cart where userName = '"+username+"'";
            ordrs = session.createQuery(queryString).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return ordrs;
    }
    public static List<Cart> getCartByDate(String date) {
        List<Cart> ordrs = new ArrayList<Cart>();
        Transaction trns = null;
        SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
        Session session=sessionFactory.openSession();
        if(date.length()<3){
            return ordrs;
        }
        try {
            trns = session.beginTransaction();
            String queryString = "from Cart where date like '%"+date +"%'";
            ordrs = session.createQuery(queryString).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return ordrs;
    }

    public static Cart getCart(String username, String ISBN) {
        Cart odr = null;
        Transaction trns = null;
        SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
        Session session=sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Cart where userName = :name and ISBN = :book";
            Query query = session.createQuery(queryString);
            query.setString("name", username);
            query.setString("book", ISBN);
            odr = (Cart) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return odr;
    }
    
    public static Cart getCartByID(int id) {
        Cart odr = null;
        Transaction trns = null;
        SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
        Session session=sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Cart where ID = :name";
            Query query = session.createQuery(queryString);
            query.setInteger("name", id);
            odr = (Cart) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return odr;
    }
}
