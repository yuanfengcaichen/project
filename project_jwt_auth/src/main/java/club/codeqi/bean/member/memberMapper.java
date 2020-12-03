package club.codeqi.bean.member;


import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface memberMapper {
    public int insert(member member);
    public int update(member member);
    public ArrayList<member> selectAll();
    public member selectByid(Integer mid);
    public int delete(int mid);
}
