package web.dao;

import web.entity.Users;

import java.util.List;

public interface UsersDao {
    public List<Users> getUsers(Users users);
    public boolean add(Users users);
    public boolean update(Users users);
    public boolean delete(Users users);
}
