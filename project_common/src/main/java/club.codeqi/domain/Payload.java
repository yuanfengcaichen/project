package club.codeqi.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author codeqi
 * 为了方便后期获取token中的用户信息，将token中载荷部分单独封装成一个对象
 */
@Data
public class Payload<T> {
    private String id;
    private T userInfo;
    private Date expiration;
}