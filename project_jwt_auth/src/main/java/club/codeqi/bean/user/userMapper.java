package club.codeqi.bean.user;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

@Mapper
@CacheConfig(cacheNames = "users")
public interface userMapper extends BaseMapper<user> {
    public int insert(user user);
    @CachePut(key = "#p0")
    public int update(user user);
    public ArrayList<user> selectAll();
    @Cacheable(key ="#p0")
    public user selectByid(Integer uid);
    @CacheEvict(key ="#p0",allEntries=true)
    public int delete(int uid);

    public ArrayList<user> select_roleAll();
    @Cacheable(key ="#p0")
    public user findByName(String name);
}
