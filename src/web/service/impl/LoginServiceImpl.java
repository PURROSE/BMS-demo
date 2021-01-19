package web.service.impl;

import web.dao.BooksDao;
import web.dao.BorwTabDao;
import web.dao.UsersDao;
import web.entity.Books;
import web.entity.Borrows;
import web.entity.Users;
import web.service.LoginService;

import java.util.List;

public class LoginServiceImpl implements LoginService {
    private BorwTabDao borwTabDao;
    private BooksDao booksDao;
    private Borrows borrows;
    private Books books;
    private UsersDao usersDao;
    private Users user;
    @Override
    public List<Users> getUsers(Users users) {
        return usersDao.getUsers(users);
    }

    @Override
    public boolean isLogin(Users users) {
        boolean islogin = usersDao.getUsers(users).size()>0;
        return islogin;
    }

    @Override
    public boolean exit(Users users) {
        return usersDao.update(users);
    }

    @Override
    public Users register(Users users) {
        user = new Users();
        boolean isOk = usersDao.add(users);
        if (isOk){
            int user_id = usersDao.getUsers(user).size();
            users.setId(user_id);
            user = getUsers(user).get(0);
        }
        return user;
    }

    @Override
    public boolean update(Users users) {
        boolean bookIs=false,borwIs = false;
        //跟新书籍库管理员信息
        books = new Books();
        books.setUser_id(users.getId());
        //获取管理员操作的书籍
        List<Books> booksList = booksDao.getBooks(books);
        int i=0;
        //更新信息
        while (i<booksList.size()){

            if (booksList.size()!=0){
                System.out.println(i);
                books = new Books();
                books.setId(booksList.get(i).getId());
                books.setName(booksList.get(i).getName());
                books.setWriter(booksList.get(i).getWriter());
                books.setNum(booksList.get(i).getNum());
                books.setUser_id(booksList.get(i).getUser_id());
                books.setUser_name(users.getName());
                books.setAddtime(booksList.get(i).getAddtime());
                bookIs = booksDao.update(books);
            }else {
                System.out.println("未查询到管理员("+users.getName()+")添加的书籍");
            }
            i++;
        }
        //更新借书表管理员信息
        borrows = new Borrows();
        borrows.setUser_id(users.getId());
        //获取到管理员操作的借书表
        List<Borrows> borrowsList = borwTabDao.getBorwTab(borrows);
        int z = 0;
        while (z<borrowsList.size()){
            if (borrowsList.size()!=0){
                borrows = new Borrows();
                borrows.setId(borrowsList.get(z).getId());
                borrows.setBook_id(borrowsList.get(z).getBook_id());
                borrows.setBook_name(borrowsList.get(z).getBook_name());
                borrows.setClient_id(borrowsList.get(z).getClient_id());
                borrows.setClient_name(borrowsList.get(z).getClient_name());
                borrows.setNum(borrowsList.get(z).getNum());
                borrows.setBorrow_aftertime(borrowsList.get(z).getBorrow_aftertime());
                borrows.setBorrow_time(borrowsList.get(z).getBorrow_time());
                borrows.setUser_id(users.getId());
                borrows.setUser_name(users.getName());
                borwIs = borwTabDao.update(borrows);
            }else {
                System.out.println("未查询到管理员（"+users.getName()+"）操作的借书表");
            }
            z++;
        }
        //确认用户信息更新
        boolean userIs = usersDao.update(users);
        return bookIs&&borwIs&&userIs?true:false;
    }

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public void setBorwTabDao(BorwTabDao borwTabDao) {
        this.borwTabDao = borwTabDao;
    }

    public void setBooksDao(BooksDao booksDao) {
        this.booksDao = booksDao;
    }
}
