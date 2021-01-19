package web.action;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import web.action.model.AdminModel;
import web.entity.Books;
import web.entity.Clients;
import web.entity.Users;
import web.service.BooksService;
import web.service.ClientsService;
import web.service.LoginService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AdminAction extends ActionSupport implements ModelDriven<AdminModel> {
    private Users users;
    private Gson gson;
    private Clients clients;
    private Books books;
    private BooksService booksService;
    private ClientsService clientsService;
    private LoginService loginService;
    private AdminModel adminModel = new AdminModel();
    private String returnData;

    public String getClient()throws Exception{
        gson = new Gson();
        clients = new Clients();
        if (adminModel.getcId()!=""){
            clients.setId(Integer.parseInt(adminModel.getcId()));
        }
        List<Clients> clientsList = clientsService.getClients(clients);
        returnData = gson.toJson(clientsList);
        System.out.println(returnData);
        return SUCCESS;
    }

    public String getBook()throws Exception{
        gson = new Gson();
        books = new Books();
        if (adminModel.getbId()!=""){
            books.setId(Integer.parseInt(adminModel.getbId()));
        }
        List<Books> booksList = booksService.getBooks(books);
        returnData = gson.toJson(booksList);
        System.out.println(returnData);
        return SUCCESS;
    }

    public String addBooks()throws Exception{

        gson = new Gson();
        books = new Books();
        books.setName(adminModel.getbName());
        books.setWriter(adminModel.getbWriter());
        System.out.println(adminModel.getuId());
        books.setUser_id(Integer.parseInt(adminModel.getuId()));
        books.setUser_name(adminModel.getuName());
        books.setNum(Integer.parseInt(adminModel.getbNum()));
        books.setAddtime(new Date());
        boolean is = booksService.addBooks(books);
        if (is){
            returnData = gson.toJson("success");
        }else {
            returnData = gson.toJson("error");
        }
        return SUCCESS;
    }

    public String addClients()throws Exception{
        gson = new Gson();
        clients = new Clients();
        clients.setName(adminModel.getcName());
        clients.setPhone(adminModel.getcPhone());
        clients.setAddress(adminModel.getcAddress());

        boolean is = clientsService.addClient(clients);
        if (is){
            returnData = gson.toJson("success");
        }else {
            returnData = gson.toJson("error");
        }
        return SUCCESS;
    }

    public String updateBooks()throws Exception{
        gson = new Gson();
        books = new Books();
        Date date = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = format.parse(changeTime(adminModel.getAddTime()));
        books.setId(Integer.parseInt(adminModel.getbId()));
        books.setName(adminModel.getbName());
        books.setWriter(adminModel.getbWriter());
        books.setNum(Integer.parseInt(adminModel.getbNum()));
        books.setUser_id(Integer.parseInt(adminModel.getuId()));
        books.setUser_name(adminModel.getuName());
        books.setAddtime(date);
        boolean is = booksService.update(books);
        if (is){
            returnData = gson.toJson("success");
        }else {
            returnData = gson.toJson("error");
        }
        return SUCCESS;
    }

    public String updateClient()throws Exception{
        gson = new Gson();
        clients = new Clients();
        clients.setId(Integer.parseInt(adminModel.getcId()));
        clients.setName(adminModel.getcName());
        clients.setPhone(adminModel.getcPhone());
        clients.setAddress(adminModel.getcAddress());
        boolean is = clientsService.update(clients);
        if (is){
            returnData = gson.toJson("success");
        }else {
            returnData = gson.toJson("error");
        }
        return SUCCESS;
    }

    public String deleteBooks()throws Exception{
        gson = new Gson();
        books = new Books();
        books.setId(Integer.parseInt(adminModel.getbId()));
        books.setName(adminModel.getbName());
        books.setWriter(adminModel.getbWriter());
        books.setNum(Integer.parseInt(adminModel.getbNum()));
        books.setUser_id(Integer.parseInt(adminModel.getuId()));
        books.setUser_name(adminModel.getuName());
        books.setAddtime(new Date(adminModel.getAddTime()));
        boolean is = booksService.delete(books);
        if (is){
            returnData = gson.toJson("success");
        }else {
            returnData = gson.toJson("error");
        }
        return SUCCESS;
    }

    public String deleteClient()throws Exception{
        gson = new Gson();
        clients = new Clients();
        clients.setId(Integer.parseInt(adminModel.getcId()));
        clients.setName(adminModel.getcName());
        clients.setPhone(adminModel.getcPhone());
        clients.setAddress(adminModel.getcAddress());
        boolean is = clientsService.delete(clients);
        if (is){
            returnData = gson.toJson("success");
        }else {
            returnData = gson.toJson("error");
        }
        return SUCCESS;
    }

    public void setClientsService(ClientsService clientsService) {
        this.clientsService = clientsService;
    }

    public void setBooksService(BooksService booksService) {
        this.booksService = booksService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public AdminModel getModel() {
        return adminModel;
    }

    public String getReturnData() {
        return returnData;
    }

    //转换时间格式
    public static String changeTime(String time){
        String t[] = time.split(" ");
        String M[] = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        String day="";
        for (int i=0;i<12;i++){
            if (t[0].equals(M[i])){
                i+=1;
                if (i>9){
                    t[0]=""+i;
                }else {
                    t[0]="0"+i;
                }
                break;
            }
        }
        if (t[1].length()>2){
            t[1]=t[1].substring(0,2);
        }else {
            t[1]=t[1].substring(0,1);
            t[1]="0"+day;
        }
        String d[] = t[3].split(":");

        if (t[4]!="AM"){
            int i = Integer.parseInt(d[0])+12;
            d[0] =""+i;
        }
        return t[2]+"-"+t[0]+"-"+t[1]+" "+d[0]+":"+d[1]+":"+d[2];
    }
}
