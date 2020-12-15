package club.codeqi.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Date;

public class permission implements GrantedAuthority, Serializable {
    private Integer perid;
    private Integer role_id;
    private String permission_code;
    private Date create_time;
    private String permission_info;

    public Integer getPerid() {
        return perid;
    }

    public void setPerid(Integer perid) {
        this.perid = perid;
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

    @Override
    public String toString() {
        return "permission{" +
                "perid=" + perid +
                ", role_id=" + role_id +
                ", permission_code='" + permission_code + '\'' +
                ", create_time=" + create_time +
                ", permission_info='" + permission_info + '\'' +
                '}';
    }

    @JsonIgnore
    @Override
    public String getAuthority() {
        return permission_code;
    }
}
