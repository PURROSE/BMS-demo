package web.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import web.dao.UsersDao;
import web.entity.Users;

import java.util.List;

public class UsersDaoImpl implements UsersDao {
    private Session session = null;
    private SessionFactory sessionFactory;
    private List<Users> usersList = null;
    @Override
    public List<Users> getUsers(Users users) {
        String hql = "from Users where 1=1";
        usersList = null;
        if (null!=users.getId()&&null!=users.getPassword()){
            hql+=" and id="+users.getId()+" and password='"+users.getPassword()+"'";
        }
        session = sessionFactory.openSession();
        usersList = session.createQuery(hql).list();
        session.close();
        return usersList;
    }

    @Override
    public boolean add(Users users) {
        usersList = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(users);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Users users) {
        usersList = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(users);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Users users) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(users);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
