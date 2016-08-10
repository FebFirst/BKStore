package service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.order;
import util.HibernateUtil;


public class orderService {
	public static void addOrder(order ordr) {
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

	public static void deleteOrder(order odr) {
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

	public static void updateOrder(order odr) {
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

	public static List<order> getAllOrders() {
		List<order> bks = new ArrayList<order>();
		Transaction trns = null;
		SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
		Session session=sessionFactory.openSession();
		try {
			trns = session.beginTransaction();
			bks = session.createQuery("from order").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return bks;
	}
	public static List<order> getOrdersByUser(String username) {
		List<order> bks = new ArrayList<order>();
		Transaction trns = null;
		SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
		Session session=sessionFactory.openSession();
		try {
			trns = session.beginTransaction();
			String queryString = "from order where userName = '"+username+"'";
			bks = session.createQuery(queryString).list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return bks;
	}
	public static List<order> getOrdersByDate(String date) {
		List<order> bks = new ArrayList<order>();
		Transaction trns = null;
		SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
		Session session=sessionFactory.openSession();
		if(date.length()<3){
			return bks;
		}
		try {
			trns = session.beginTransaction();
			String queryString = "from order where date like '%"+date +"%'";
			bks = session.createQuery(queryString).list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return bks;
	}

	public static order getOrder(String username, String ISBN) {
		order odr = null;
		Transaction trns = null;
		SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
		Session session=sessionFactory.openSession();
		try {
			trns = session.beginTransaction();
			String queryString = "from order where userName = :name and ISBN = :book";
			Query query = session.createQuery(queryString);
			query.setString("name", username);
			query.setString("book", ISBN);
			odr = (order) query.uniqueResult();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return odr;
	}
}
