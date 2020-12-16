package club.codeqi.Aspect.user;

import java.io.Serializable;

public class SMS implements Serializable {
    private String phone;
    private String code;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "SMS{" +
                "phone='" + phone + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
