package club.codeqi.bean.role;

import java.util.Date;

public class role {
    private Integer rid;
    private String role_name;
    private String role_info;
    private Integer is_lock;
    private Date create_time;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
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

    @Override
    public String toString() {
        return "role{" +
                "rid=" + rid +
                ", role_name='" + role_name + '\'' +
                ", role_info='" + role_info + '\'' +
                ", is_lock=" + is_lock +
                ", create_time=" + create_time +
                '}';
    }
}
