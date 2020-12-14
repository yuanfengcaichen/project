package club.codeqi.datasource;

import club.codeqi.bean.user.UserService;
import club.codeqi.bean.user.user;
import club.codeqi.bean.user.userMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class redistest {
    @Autowired
    StringRedisTemplate stringRedisTemplate;//操作k-v都是字符串

    @Autowired
    RedisTemplate redisTemplate;//操作k-v对象的
    @Autowired
    club.codeqi.bean.user.userMapper userMapper;
    @Test
    public void redistemplent(){
        stringRedisTemplate.opsForList().leftPush("test1","value1","value2");
        stringRedisTemplate.opsForList().rightPushAll("test3","value1","value2","value3");
    }

    @Test
    public void redisobjtest(){
        //stringRedisTemplate.opsForHash().put("user::usertoken","1","qwertyyuiisdfgsdfg");
        //redisTemplate.opsForValue().set();
//        redisTemplate.opsForHash().put("user:usertoken","1",userMapper.findByName("test02"));
//        redisTemplate.expire("user:usertoken",100, TimeUnit.SECONDS);
        userMapper.findByName("test02");
        user user = userMapper.findByName("test02");
        System.out.println(user);
    }

    @Test
    public void redisobjgettest(){
        Object o = redisTemplate.opsForHash().get("user::usertoken","1");
        System.out.println((user) o);

    }
    @Test
    public void redisexpretest(){
        redisTemplate.expire("user::usertoken",100, TimeUnit.SECONDS);
    }

    @Test
    public void redisdeletetest(){
        redisTemplate.delete("user:usertoken");
    }
}
