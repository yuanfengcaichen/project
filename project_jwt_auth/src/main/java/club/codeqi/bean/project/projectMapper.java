package club.codeqi.bean.project;

import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface projectMapper {
    public int insert(project project);
    public int update(project project);
    public ArrayList<project> selectAll();
    public project selectByid(Integer id);
    public int delete(int id);
}
