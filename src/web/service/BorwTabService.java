package web.service;

import web.entity.Borrows;

import java.util.List;

public interface BorwTabService {
    List<Borrows> getBorwTab(Borrows borrows);
    boolean addBorwTab(Borrows borrows);
    boolean update(Borrows borrows);
    boolean delete(Borrows borrows);
}
