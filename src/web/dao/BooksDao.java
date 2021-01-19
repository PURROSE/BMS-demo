package web.dao;

import web.entity.Books;

import java.util.List;

public interface BooksDao {
    List<Books> getBooks(Books books);
    boolean add(Books books);
    boolean update(Books books);
    boolean delete(Books books);
}
