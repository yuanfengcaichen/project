package club.codeqi.bean.permission;

import java.util.Date;

public class permission {
    private Integer id;
    private Integer role_id;
    private String permission_code;
    private Date create_time;
    private String permission_info;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getPermission_code() {
        return permission_code;
    }

    public void setPermission_code(String permission_code) {
        this.permission_code = permission_code;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getPermission_info() {
        return permission_info;
    }

    public void setPermission_info(String permission_info) {
        this.permission_info = permission_info;
    }
}
