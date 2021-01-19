package web.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import web.dao.BooksDao;
import web.entity.Books;

import java.util.List;

public class BooksDaoImpl implements BooksDao {
    private List<Books> booksList = null;
    private Session session;
    private SessionFactory sessionFactory;
    @Override
    public List<Books> getBooks(Books books) {
        String hql = "from Books where 1=1";
        if (null!=books.getId()){
            hql+=" and id="+books.getId();
        }
        if (null!=books.getWriter()){
            hql+=" and writer="+books.getWriter();
        }
        if(null!=books.getUser_id()){
            hql+= " and user_id="+books.getUser_id();
        }

        booksList = null;
        session = sessionFactory.openSession();
        booksList = session.createQuery(hql).list();
        session.close();
        return booksList;
    }

    @Override
    public boolean add(Books books) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(books);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Books books) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(books);
        session.getTransaction().commit();
        session.close();
        return true;
    }


    @Override
    public boolean delete(Books books) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(books);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
