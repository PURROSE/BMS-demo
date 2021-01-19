package web.entity;

public class Users {
    private Integer id;
    private String password;
    private String name;
    private String address;
    private String phone;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }
}
