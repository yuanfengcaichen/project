package club.codeqi.bean.member;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class member implements Serializable {

    private Integer mid;
    private Integer p_id;
    private Integer s_id;
    private Integer t_id;
    private Integer u_id;
    private String remarks;
    private String content;
    private Date create_time;
    private Integer state;
    private Date begin_time;
    private Date end_time;


}
