package web.action;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import web.action.model.BorwTabModel;
import web.entity.Borrows;
import web.service.BorwTabService;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

public class BorwTabAction extends ActionSupport implements ModelDriven<BorwTabModel> {
    private BorwTabService borwTabService;
    private String returnData;
    private BorwTabModel borwTabModel = new BorwTabModel();
    private Gson gson;
    private Borrows borrows;

    public String getBorwTab()throws Exception{
        gson = new Gson();
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        borrows = new Borrows();
        borrows.setClient_id(Integer.parseInt(borwTabModel.getcId()));
        List<Borrows> borrowsList = borwTabService.getBorwTab(borrows);
        returnData = gson.toJson(borrowsList);
        return SUCCESS;
    }

    public String addBorTab()throws Exception{
        gson = new Gson();
        borrows = new Borrows();

        borrows.setClient_id(Integer.parseInt(borwTabModel.getcId()));
        borrows.setClient_name(borwTabModel.getcName());
        borrows.setBook_id(Integer.parseInt(borwTabModel.getbId()));
        borrows.setBook_name(borwTabModel.getbName());
        borrows.setUser_id(Integer.parseInt(borwTabModel.getuId()));
        borrows.setUser_name(borwTabModel.getuName());
        borrows.setNum(1);
        borrows.setBorrow_time(new Date());
        boolean f = borwTabService.addBorwTab(borrows);
        if (f){
            returnData = gson.toJson("success");
        }else {
            returnData = gson.toJson("error");
        }

        return SUCCESS;
    }

    public String updateBorTab()throws Exception{

        Date date = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = format.parse(borwTabModel.getBtnTime());

        gson = new Gson();

        borrows = new Borrows();
        borrows.setId(Integer.parseInt(borwTabModel.getBtnId()));
        borrows.setClient_id(Integer.parseInt(borwTabModel.getcId()));
        borrows.setClient_name(borwTabModel.getcName());
        borrows.setBook_id(Integer.parseInt(borwTabModel.getbId()));
        borrows.setBook_name(borwTabModel.getbName());
        borrows.setUser_id(Integer.parseInt(borwTabModel.getuId()));
        borrows.setUser_name(borwTabModel.getuName());
        borrows.setBorrow_time(date);
        borrows.setBorrow_aftertime(new Date());
        borrows.setNum(1);

        boolean is = borwTabService.update(borrows);
        if(is){
            returnData = gson.toJson("success");
        }else {
            returnData = gson.toJson("error");
        }
        return SUCCESS;
    }

    public void setBorwTabService(BorwTabService borwTabService) {
        this.borwTabService = borwTabService;
    }

    public String getReturnData() {
        return returnData;
    }

    @Override
    public BorwTabModel getModel() {
        return borwTabModel;
    }
}
