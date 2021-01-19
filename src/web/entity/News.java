package web.entity;

import java.util.Date;

public class News {
    private Integer id;
    private String title;
    private Integer user_id;
    private String user_name;
    private String body;
    private Date add_time;

    public void setBody(String body) {
        this.body = body;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setAdd_time(Date add_time) {
        this.add_time = add_time;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }

    public String getUser_name() {
        return user_name;
    }

    public Date getAdd_time() {
        return add_time;
    }
}
