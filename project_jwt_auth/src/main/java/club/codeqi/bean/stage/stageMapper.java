package club.codeqi.bean.stage;

import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface stageMapper {
    public int insert(stage stage);
    public int update(stage stage);
    public ArrayList<stage> selectAll();
    public stage selectByid(Integer sid);
    public int delete(int sid);
}
