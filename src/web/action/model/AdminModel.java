package web.action.model;

public class AdminModel {
    private String uId;
    private String uName;
    private String cId;
    private String cName;
    private String cPhone;
    private String cAddress;
    private String bId;
    private String bName;
    private String bWriter;
    private String bNum;
    private String addTime;

    public void setuId(String uId) {
        this.uId = uId;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public void setbNum(String bNum) {
        this.bNum = bNum;
    }

    public void setbWriter(String bWriter) {
        this.bWriter = bWriter;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone;
    }

    public String getuId() {
        return uId;
    }

    public String getuName() {
        return uName;
    }

    public String getbId() {
        return bId;
    }

    public String getbName() {
        return bName;
    }

    public String getbWriter() {
        return bWriter;
    }

    public String getbNum() {
        return bNum;
    }

    public String getcAddress() {
        return cAddress;
    }

    public String getcId() {
        return cId;
    }

    public String getcName() {
        return cName;
    }

    public String getcPhone() {
        return cPhone;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getAddTime() {
        return addTime;
    }
}
