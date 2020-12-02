package club.codeqi.bean.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class userMapperTest {
    @Autowired
    userMapper userMapper;

    @Test
    void insert() {
    }

    @Test
    void update() {
    }

    @Test
    void selectAll() {
    }

    @Test
    void selectByid() {
    }

    @Test
    void delete() {
    }

    @Test
    void findByName() {
        System.out.println(userMapper.findByName("testuser"));
    }
}