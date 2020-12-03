package club.codeqi.bean.task;

import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface taskMapper {
    public int insert(task task);
    public int update(task task);
    public ArrayList<task> selectAll();
    public task selectByid(Integer tid);
    public int delete(int tid);
}
