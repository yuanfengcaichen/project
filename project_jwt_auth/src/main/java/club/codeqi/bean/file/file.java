package club.codeqi.bean.file;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class file implements Serializable {

    private Integer fid;
    private Integer p_id;
    private Integer s_id;
    private Integer t_id;
    private Integer m_id;
    private String oldname;
    private String filepath;
    private Date create_time;


}
