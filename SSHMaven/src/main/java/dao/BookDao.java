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

import model.Book;
import util.HibernateUtil;

public class BookDao {
    public static void addBook(Book bk) {
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
            Book bk = new Book();
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

    public static void updateBook(Book bk) {
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

    public static List<Book> getAllBooks() {
        List<Book> bks = new ArrayList<Book>();
        Transaction trns = null;
        SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
        Session session=sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            bks = session.createQuery("from Book").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return bks;
    }

    public static Book getBook(String ISBN) {
        Book bk = null;
        Transaction trns = null;
        SessionFactory sessionFactory= HibernateUtil.configureSessionFactory();
        Session session=sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Book where ISBN = :id";
            Query query = session.createQuery(queryString);
            query.setString("id", ISBN);
            bk = (Book) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return bk;
    }

}

