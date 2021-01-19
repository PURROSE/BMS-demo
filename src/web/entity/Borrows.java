package web.entity;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Borrows {
    private Integer id;
    private Integer client_id;
    private String client_name;
    private Integer book_id;
    private String book_name;
    private Integer user_id;
    private String user_name;
    private Integer num;
    private java.util.Date borrow_time;
    private java.util.Date borrow_aftertime;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public void setBorrow_time(Date borrow_time) {
        this.borrow_time = borrow_time;
    }

    public void setBorrow_aftertime(Date borrow_aftertime) {
        this.borrow_aftertime = borrow_aftertime;
    }

    public Date getBorrow_aftertime() {
        return borrow_aftertime;
    }

    public Date getBorrow_time() {
        return borrow_time;
    }
}
