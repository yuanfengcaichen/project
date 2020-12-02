package club.codeqi.bean.user;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

@Mapper
public interface userMapper {
    public int insert(user user);
    public int update(user user);
    public ArrayList<user> selectAll();
    public user selectByid(Integer uid);
    public int delete(int uid);

    public user findByName(String name);
}
