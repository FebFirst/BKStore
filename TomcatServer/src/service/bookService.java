package service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.book;
import util.HibernateUtil;

public class bookService {
	public static void addBook(book bk) {
		Transaction trns = null;
		SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
		Session session=sessionFactory.openSession();
		try {
			trns = session.beginTransaction();
			session.save(bk);
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

	public static void deleteBook(String ISBN) {
		Transaction trns = null;
		SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
		Session session=sessionFactory.openSession();
		try {
			trns = session.beginTransaction();
			//book bk = (book) session.load(book.class, new String(ISBN));
			book bk = new book();
			bk.setISBN(ISBN);
			session.delete(bk);
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

	public static void updateBook(book bk) {
		Transaction trns = null;
		SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
		Session session=sessionFactory.openSession();
		try {
			trns = session.beginTransaction();
			session.update(bk);
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

	public static List<book> getAllBooks() {
		List<book> bks = new ArrayList<book>();
		Transaction trns = null;
		SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
		Session session=sessionFactory.openSession();
		try {
			trns = session.beginTransaction();
			bks = session.createQuery("from book").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return bks;
	}

	public static book getBook(String ISBN) {
		book bk = null;
		Transaction trns = null;
		SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
		Session session=sessionFactory.openSession();
		try {
			trns = session.beginTransaction();
			String queryString = "from book where ISBN = :id";
			Query query = session.createQuery(queryString);
			query.setString("id", ISBN);
			bk = (book) query.uniqueResult();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return bk;
	}
}
