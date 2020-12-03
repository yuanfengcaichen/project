package club.codeqi.bean.file;

import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface fileMapper {
    public int insert(file file);
    public int update(file file);
    public ArrayList<file> selectAll();
    public file selectByid(Integer fid);
    public int delete(int fid);
}
