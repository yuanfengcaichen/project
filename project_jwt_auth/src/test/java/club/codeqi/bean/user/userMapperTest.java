package club.codeqi.bean.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class userMapperTest {
    @Autowired
    userMapper userMapper;

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Test
    void insert() {
        user user = new user();
        user.setUsername("test02");
        user.setPassword(bCryptPasswordEncoder.encode("123"));
        user.setRole_id(1);
        user.setCreate_time(new Date());
        user.setIs_lock(0);
        System.out.println(userMapper.insert(user));
    }

    @Test
    void update() {
    }

    @Test
    void selectAll() {
    }

    @Test
    void selectByid() {
        System.out.println(userMapper.selectByid(1));
    }

    @Test
    void delete() {
    }

    @Test
    void findByName() {
        System.out.println(userMapper.findByName("testuser"));
    }
}