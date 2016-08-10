package dao;

/**
 * Created by apple on 16/6/7.
 */
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Order;
import util.HibernateUtil;
public class OrderDao {
    public static void addOrder(Order ordr) {
        Transaction trns = null;
        SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
        Session session=sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            session.save(ordr);
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

    public static void deleteOrder(Order odr) {
        Transaction trns = null;
        SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
        Session session=sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            session.delete(odr);
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

    public static void updateOrder(Order odr) {
        Transaction trns = null;
        SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
        Session session=sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            session.update(odr);
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

    public static List<Order> getAllOrders() {
        List<Order> ordrs = new ArrayList<Order>();
        Transaction trns = null;
        SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
        Session session=sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            ordrs = session.createQuery("from Order").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return ordrs;
    }
    public static List<Order> getOrdersByUser(String username) {
        List<Order> ordrs = new ArrayList<Order>();
        Transaction trns = null;
        SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
        Session session=sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Order where userName like '%"+username +"%'";
            ordrs = session.createQuery(queryString).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return ordrs;
    }
    public static List<Order> getOrdersByDate(String date) {
        List<Order> ordrs = new ArrayList<Order>();
        Transaction trns = null;
        SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
        Session session=sessionFactory.openSession();
        if(date.length()<3){
            return ordrs;
        }
        try {
            trns = session.beginTransaction();
            String queryString = "from Order where date like '%"+date +"%'";
            ordrs = session.createQuery(queryString).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return ordrs;
    }

    public static Order getOrder(String username, String ISBN) {
        Order odr = null;
        Transaction trns = null;
        SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
        Session session=sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Order where userName = :name and ISBN = :book";
            Query query = session.createQuery(queryString);
            query.setString("name", username);
            query.setString("book", ISBN);
            odr = (Order) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return odr;
    }

}
