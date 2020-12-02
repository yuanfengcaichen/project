package club.codeqi.bean.role;

import java.util.Date;

public class role {
    private Integer id;
    private String role_name;
    private String role_info;
    private Integer is_lock;
    private Date create_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_info() {
        return role_info;
    }

    public void setRole_info(String role_info) {
        this.role_info = role_info;
    }

    public Integer getIs_lock() {
        return is_lock;
    }

    public void setIs_lock(Integer is_lock) {
        this.is_lock = is_lock;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
