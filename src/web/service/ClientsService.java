package web.service;

import web.entity.Clients;

import java.util.List;

public interface ClientsService {
    List<Clients> getClients(Clients clients);
    boolean addClient(Clients clients);
    boolean update(Clients clients);
    boolean delete(Clients clients);
}
