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

    private String s = "sid,p_id,remarks,create_time,state,stage_name,begin_time,end_time";
}
