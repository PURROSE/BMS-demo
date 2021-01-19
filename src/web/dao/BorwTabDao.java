package web.dao;

import web.entity.Borrows;

import java.util.List;

public interface BorwTabDao {
    List<Borrows> getBorwTab(Borrows borrows);
    boolean add(Borrows borrows);
    boolean update(Borrows borrows);
    boolean delete(Borrows borrows);
}
