package club.codeqi.bean.file;

import lombok.Data;

import java.util.Date;

@Data
public class file {

    private Integer fid;
    private Integer p_id;
    private Integer s_id;
    private Integer t_id;
    private Integer m_id;
    private String oldname;
    private String filepath;
    private Date create_time;

    private String s = "fid,p_id,s_id,t_id,m_id,oldname,filepath,create_time";

}
