package web.service;

import web.entity.Books;

import java.util.List;

public interface BooksService {
    List<Books> getBooks(Books books);
    boolean addBooks(Books books);
    boolean update(Books books);
    boolean delete(Books books);
}
