package club.codeqi.bean.role;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface roleMapper  extends BaseMapper<role> {
    public int insert(role role);
    public int update(role role);
    public ArrayList<role> selectAll();
    public role selectByid(Integer rid);
    public int delete(int rid);
}
