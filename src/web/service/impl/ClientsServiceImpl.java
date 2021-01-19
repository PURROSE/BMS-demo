package web.service.impl;

import web.dao.BorwTabDao;
import web.dao.ClientsDao;
import web.entity.Borrows;
import web.entity.Clients;
import web.service.ClientsService;

import java.util.List;

public class ClientsServiceImpl implements ClientsService {
    private BorwTabDao borwTabDao;
    private Clients clients;
    private Borrows borrows;
    private ClientsDao clientsDao;
    @Override
    public List<Clients> getClients(Clients clients) {
        return clientsDao.getClients(clients);
    }

    @Override
    public boolean addClient(Clients clients) {
        return clientsDao.add(clients);
    }

    @Override
    public boolean update(Clients clients) {
        boolean borwIs=false;
        borrows = new Borrows();
        borrows.setClient_id(clients.getId());
        //获取到管理员操作的借书表
        List<Borrows> borrowsList = borwTabDao.getBorwTab(borrows);
        int z = 0;
        while (z<borrowsList.size()){
            if (z!=0){
                borrows = new Borrows();
                borrows.setId(borrowsList.get(z).getId());
                borrows.setBook_id(borrowsList.get(z).getBook_id());
                borrows.setBook_name(borrowsList.get(z).getBook_name());

                borrows.setClient_id(clients.getId());
                borrows.setClient_name(clients.getName());

                borrows.setNum(borrowsList.get(z).getNum());
                borrows.setBorrow_aftertime(borrowsList.get(z).getBorrow_aftertime());
                borrows.setBorrow_time(borrowsList.get(z).getBorrow_time());
                borrows.setUser_id(borrowsList.get(z).getUser_id());
                borrows.setUser_name(borrowsList.get(z).getUser_name());
                borwIs = borwTabDao.update(borrows);
            }else {
                System.out.println("未查询到客户（"+clients.getName()+"）操作的借书表");
            }
            z++;
        }
        boolean clientIs = clientsDao.update(clients);
        return borwIs&&clientIs?true:false;
    }

    @Override
    public boolean delete(Clients clients) {
        return clientsDao.delete(clients);
    }

    public void setClientsDao(ClientsDao clientsDao) {
        this.clientsDao = clientsDao;
    }

    public void setBorwTabDao(BorwTabDao borwTabDao) {
        this.borwTabDao = borwTabDao;
    }
}
