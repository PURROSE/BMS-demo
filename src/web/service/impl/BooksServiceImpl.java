package web.service.impl;

import web.dao.BooksDao;
import web.dao.BorwTabDao;
import web.entity.Books;
import web.entity.Borrows;
import web.service.BooksService;

import java.util.List;

public class BooksServiceImpl implements BooksService {
    private BorwTabDao borwTabDao;
    private Borrows borrows;
    private BooksDao booksDao;
    @Override
    public List<Books> getBooks(Books books) {
        return booksDao.getBooks(books);
    }

    @Override
    public boolean addBooks(Books books) {
        return booksDao.add(books);
    }

    @Override
    public boolean update(Books books) {
        boolean bookIs = false;
        boolean borwIs = false;
        borrows = new Borrows();
        borrows.setBook_id(books.getId());
        List<Borrows> borrowsList=borwTabDao.getBorwTab(borrows);
        for (int i =0;i<borrowsList.size();i++){
            borrows = new Borrows();
            borrows.setId(borrowsList.get(i).getId());
            borrows.setClient_id(borrowsList.get(i).getClient_id());
            borrows.setClient_name(borrowsList.get(i).getClient_name());
            borrows.setBook_id(borrowsList.get(i).getBook_id());

            borrows.setBook_name(books.getName());

            borrows.setUser_id(borrowsList.get(i).getUser_id());
            borrows.setUser_name(borrowsList.get(i).getUser_name());
            borrows.setNum(borrowsList.get(i).getNum());
            borrows.setBorrow_time(borrowsList.get(i).getBorrow_time());
            borrows.setBorrow_aftertime(borrowsList.get(i).getBorrow_aftertime());

            borwIs= borwTabDao.update(borrows);
        }
        bookIs = booksDao.update(books);
        return bookIs&&borwIs?true:false;
    }

    @Override
    public boolean delete(Books books) {
        return booksDao.delete(books);
    }

    public void setBooksDao(BooksDao booksDao) {
        this.booksDao = booksDao;
    }
}
