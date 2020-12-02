package club.codeqi.bean.project;

import lombok.Data;

import java.util.Date;

@Data
public class project {
    private Integer id;
    private String p_name;
    private Integer creat_uid;
    private String remarks;
    private Date create_time;
    private Integer state;
    private Date begin_time;
    private Date end_time;
}
