package web.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import web.dao.ClientsDao;
import web.entity.Clients;

import java.util.List;

public class ClientsDaoImpl implements ClientsDao {
    private List<Clients> clientsList = null;
    private SessionFactory sessionFactory;
    private Session session;
    @Override
    public List<Clients> getClients(Clients clients) {
        String hql = "from Clients where 1=1";
        if(null!=clients.getId()){
            hql+=" and id="+clients.getId();
        }
        session = sessionFactory.openSession();
        clientsList = session.createQuery(hql).list();
        session.close();
        return clientsList;
    }

    @Override
    public boolean add(Clients clients) {
        session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(clients);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Clients clients) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(clients);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Clients clients) {
        session=sessionFactory.openSession();
        session.beginTransaction();
        session.update(clients);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
