package club.codeqi.bean.member;

import lombok.Data;

import java.util.Date;

@Data
public class member {

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

    private String s = "mid,p_id,s_id,t_id,u_id,remarks,content,create_time,state,begin_time,end_time";

}
