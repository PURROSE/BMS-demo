package web.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import web.dao.NewsDao;
import web.entity.News;

import java.util.List;

public class NewsDaoImpl implements NewsDao {
    private SessionFactory sessionFactory;
    private Session session=null;

    @Override
    public List<News> getNews(News news) {
        session = sessionFactory.openSession();
        String hql = "from News where 1=1";
        if (!news.getId().equals(null)){
            hql+=" and id="+news.getId();
        }
        if (!news.getUser_id().equals(null)){
            hql+=" and user_id="+news.getUser_id();
        }
        List<News> newsList = session.createQuery(hql).list();
        session.close();
        return newsList;
    }

    @Override
    public boolean add(News news) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(news);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(News news) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(news);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(News news) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(news);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
