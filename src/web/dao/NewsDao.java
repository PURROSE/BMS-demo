package web.dao;

import web.entity.News;

import java.util.List;

public interface NewsDao {
    List<News> getNews(News news);
    boolean add(News news);
    boolean update(News news);
    boolean delete(News news);
}
