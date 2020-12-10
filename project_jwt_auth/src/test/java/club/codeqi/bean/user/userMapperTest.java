package club.codeqi.bean.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class userMapperTest {
    @Autowired
    userMapper userMapper;

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Test
    void insert() {
        user user = new user();
        user.setUsername("test04");
        user.setPassword(bCryptPasswordEncoder.encode("123"));
        user.setRole_id(1);
        user.setCreate_time(new Date());
        user.setIs_lock(0);
        System.out.println(userMapper.insert(user));
    }

    @Test
    void update() {
        user user = userMapper.selectByid(2);
        System.out.println(user);
        user.setRole_id(1);
        System.out.println(userMapper.update(user));
    }

    @Test
    void selectAll() {
        System.out.println(userMapper.selectAll());
    }

    @Test
    void select_roleAll() {
        System.out.println(userMapper.select_roleAll());
    }


    @Test
    void selectByid() {
        System.out.println(userMapper.selectByid(1));
    }

    @Test
    void delete() {
        System.out.println(userMapper.delete(6));
    }

    @Test
    void findByName() {
        System.out.println(userMapper.findByName("testuser"));
    }

    @Test
    void testfind(){
        System.out.println(("----- selectAll method test ------"));
        List<user> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }
}