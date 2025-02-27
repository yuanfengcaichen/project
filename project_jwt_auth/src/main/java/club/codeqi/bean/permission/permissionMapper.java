package club.codeqi.bean.permission;

import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface permissionMapper {
    public int insert(permission permission);
    public int update(permission permission);
    public ArrayList<permission> selectAll();
    public permission selectByid(Integer perid);
    public ArrayList<permission> selectByrid(Integer rid);
    public int delete(int perid);
    public int deleteByrid(int rid);
}
