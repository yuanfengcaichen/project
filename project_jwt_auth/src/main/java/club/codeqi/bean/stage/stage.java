package club.codeqi.bean.stage;

import lombok.Data;

import java.util.Date;

@Data
public class stage {

    private Integer sid;
    private Integer p_id;
    private String remarks;
    private Date create_time;
    private Integer state;
    private String stage_name;
    private Date begin_time;
    private Date end_time;

}
