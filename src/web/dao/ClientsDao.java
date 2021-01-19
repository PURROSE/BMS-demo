package web.dao;

import web.entity.Clients;

import java.util.List;

public interface ClientsDao {
    public List<Clients> getClients(Clients clients);
    public boolean add(Clients clients);
    public boolean delete(Clients clients);
    public boolean update(Clients clients);
}
