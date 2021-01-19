package web.action.model;

public class BorwTabModel {
    private String bId;
    private String bName;
    private String uId;
    private String uName;
    private String cId;
    private String cName;
    private String btnId;
    private String btnTime;

    public void setcName(String cName) {
        this.cName = cName;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public void setBtnId(String btnId) {
        this.btnId = btnId;
    }

    public void setBtnTime(String btnTime) {
        this.btnTime = btnTime;
    }

    public String getcName() {
        return cName;
    }

    public String getcId() {
        return cId;
    }

    public String getbName() {
        return bName;
    }

    public String getbId() {
        return bId;
    }

    public String getuName() {
        return uName;
    }

    public String getuId() {
        return uId;
    }

    public String getBtnId() {
        return btnId;
    }

    public String getBtnTime() {
        return btnTime;
    }
}
