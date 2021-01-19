package web.service;

import web.entity.Users;

import java.util.List;

public interface LoginService {
    List<Users> getUsers(Users users);
    boolean isLogin(Users users);
    boolean exit(Users users);
    Users register(Users users);
    boolean update(Users users);
}
