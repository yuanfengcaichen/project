package club.codeqi.bean.role;

import club.codeqi.bean.user.user;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class roleMapperTest {

    @Autowired
    roleMapper roleMapper;

    @Test
    void insert() {
        role role = new role();
        role.setRole_name("测试角色1");
        role.setRole_info("测试角色1的信息");
        role.setCreate_time(new Date());
        role.setIs_lock(0);
        System.out.println(roleMapper.insert(role));
    }

    @Test
    void update() {
        role role = roleMapper.selectByid(3);
        role.setRole_info("修改测试信息");
        System.out.println(roleMapper.update(role));

    }

    @Test
    void selectAll() {
        System.out.println(roleMapper.selectAll());
    }

    @Test
    void selectByid() {
        System.out.println(roleMapper.selectByid(1));
    }

    @Test
    void delete() {
        System.out.println(roleMapper.delete(3));
    }

    @Test
    void testfind(){
        System.out.println(("----- selectAll method test ------"));
        List<role> roleList = roleMapper.selectList(null);
        roleList.forEach(System.out::println);
    }
}