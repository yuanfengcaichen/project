package club.codeqi.bean.project;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class project implements Serializable {
    private Integer pid;
    private String p_name;
    private Integer creat_uid;
    private String remarks;
    private Date create_time;
    private Integer state;
    private Date begin_time;
    private Date end_time;
}
