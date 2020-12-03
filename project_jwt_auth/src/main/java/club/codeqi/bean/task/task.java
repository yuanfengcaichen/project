package club.codeqi.bean.task;

import lombok.Data;

import java.util.Date;

@Data
public class task {

    private Integer tid;
    private Integer p_id;
    private Integer s_id;
    private String task_name;
    private String remarks;
    private Date create_time;
    private Integer state;
    private Date begin_time;
    private Date end_time;

    private String s = "tid,p_id,s_id,task_name,remarks,create_time,state,begin_time,end_time";
}
