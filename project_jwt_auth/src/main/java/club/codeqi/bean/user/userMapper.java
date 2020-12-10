package club.codeqi.bean.user;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

@Mapper
public interface userMapper extends BaseMapper<user> {
    public int insert(user user);
    public int update(user user);
    public ArrayList<user> selectAll();
    public user selectByid(Integer uid);
    public int delete(int uid);

    public ArrayList<user> select_roleAll();

    public user findByName(String name);
}
