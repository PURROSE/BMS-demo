package web.action.model;

public class LoginModel {
    private String uId;
    private String uPassword;
    private String uName;
    private String uPhone;
    private String uAddress;

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuPhone() {
        return uPhone;
    }

    public String getuName() {
        return uName;
    }

    public String getuAddress() {
        return uAddress;
    }

    public String getuId() {
        return uId;
    }

    public String getuPassword() {
        return uPassword;
    }
}
