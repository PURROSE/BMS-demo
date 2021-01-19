package web.service.impl;

import web.dao.BooksDao;
import web.dao.BorwTabDao;
import web.entity.Books;
import web.entity.Borrows;
import web.service.BorwTabService;

import java.util.List;

public class BorwTabServiceImpl implements BorwTabService {
    private BooksDao booksDao;
    private BorwTabDao borwTabDao;
    @Override
    public List<Borrows> getBorwTab(Borrows borrows) {
        return borwTabDao.getBorwTab(borrows);
    }

    @Override
    public boolean addBorwTab(Borrows borrows) {
        Books books = new Books();
        books.setId(borrows.getBook_id());
        books = booksDao.getBooks(books).get(0);
        books.setNum(books.getNum()-borrows.getNum());
        boolean bookIs = booksDao.update(books);
        boolean borwIs = borwTabDao.add(borrows);
        return bookIs&&borwIs?true:false;
    }

    @Override
    public boolean update(Borrows borrows) {
        Books books = new Books();
        books.setId(borrows.getBook_id());
        books = booksDao.getBooks(books).get(0);
        books.setNum(books.getNum()+borrows.getNum());
        boolean bookIs = booksDao.update(books);
        boolean borwIs = borwTabDao.update(borrows);
        return bookIs&&borwIs?true:false;
    }

    @Override
    public boolean delete(Borrows borrows) {
        return borwTabDao.delete(borrows);
    }

    public void setBooksDao(BooksDao booksDao) {
        this.booksDao = booksDao;
    }

    public void setBorwTabDao(BorwTabDao borwTabDao) {
        this.borwTabDao = borwTabDao;
    }
}
