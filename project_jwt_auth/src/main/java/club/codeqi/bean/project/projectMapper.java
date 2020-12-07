package club.codeqi.bean.project;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface projectMapper extends BaseMapper<project> {
    public int insert(project project);
    public int update(project project);
    public ArrayList<project> selectAll();
    public project selectByid(Integer pid);
    public int delete(int pid);
}
