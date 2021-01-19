package web.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import web.dao.BorwTabDao;
import web.entity.Borrows;

import java.util.List;

public class BorwTabDaoImpl implements BorwTabDao {
    private List<Borrows> borrowsList=null;
    private Session session;
    private SessionFactory sessionFactory;
    @Override
    public List<Borrows> getBorwTab(Borrows borrows) {
        String hql = "from Borrows where 1=1";
        if (null!=borrows.getId()){
            hql+=" and id="+borrows.getId();
        }
        if(null!=borrows.getClient_id()){
            hql+=" and client_id="+borrows.getClient_id();
        }
        if(null!=borrows.getBook_id()){
            hql+=" and book_id="+borrows.getBook_id();
        }
        if (null!=borrows.getUser_id()){
            hql+=" and user_id="+borrows.getUser_id();
        }
        session =sessionFactory.openSession();
        borrowsList = session.createQuery(hql).list();
        session.close();
        return borrowsList;
    }

    @Override
    public boolean add(Borrows borrows) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(borrows);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Borrows borrows) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(borrows);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Borrows borrows) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(borrows);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
