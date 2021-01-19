package web.action;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import web.action.model.LoginModel;
import web.entity.Users;
import web.service.LoginService;

import java.util.ArrayList;
import java.util.List;

public class LoginAction extends ActionSupport implements ModelDriven<LoginModel> {
    private LoginService loginService;
    private String returnData = null;
    private Gson gson;
    private Users users;
    private LoginModel loginModel = new LoginModel();

    public String loginUsers()throws Exception{
        users = new Users();
        gson = new Gson();
        users.setId(Integer.parseInt(loginModel.getuId()));
        users.setPassword(loginModel.getuPassword());
        List<Users> usersList = loginService.getUsers(users);
        if (usersList.size()>0){
            ActionContext.getContext().getSession().put("user",usersList);
            returnData = gson.toJson(usersList);
        }else {
            returnData = gson.toJson("error");
        }



        return SUCCESS;
    }
    public String register()throws Exception{
        users = new Users();
        gson = new Gson();
        users.setName(loginModel.getuName());
        users.setPassword(loginModel.getuPassword());
        users.setAddress(loginModel.getuAddress());
        users.setPhone(loginModel.getuPhone());

        users = loginService.register(users);
        List<Users> usersList = new ArrayList<>();
        usersList.add(users);
        returnData = gson.toJson(usersList);
        return SUCCESS;
    }
    public String isLogin()throws Exception{
        gson = new Gson();
        List<Users> usersList =(List<Users>) ActionContext.getContext().getSession().get("user");
        if (usersList!=null){
            returnData = gson.toJson(usersList);
        }else {
            returnData = gson.toJson("error");
        }
        return SUCCESS;
    }
    public String updateUser()throws Exception{
        gson = new Gson();
        users = new Users();
        users.setId(Integer.parseInt(loginModel.getuId()));
        users.setPassword(loginModel.getuPassword());
        users.setName(loginModel.getuName());
        users.setPhone(loginModel.getuPhone());
        users.setAddress(loginModel.getuAddress());

        boolean is = loginService.update(users);
        if (is){
            ActionContext.getContext().getSession().remove("user");
            List<Users> usersList = loginService.getUsers(users);
            ActionContext.getContext().getSession().put("user",usersList);
            returnData = gson.toJson("success");
        }else {
            returnData = gson.toJson("error");
        }

        return SUCCESS;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public String getReturnData() {
        return returnData;
    }

    @Override
    public LoginModel getModel() {
        return loginModel;
    }
}
