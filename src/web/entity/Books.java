package web.entity;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Books {
    private Integer id;
    private String name;
    private String writer;
    private Integer num;
    private Integer user_id;
    private String user_name;
    private Date addtime;

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWriter() {
        return writer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Integer getNum() {
        return num;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Date getAddtime() {
        return addtime;
    }
}
