package club.codeqi.bean.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class taskMapperTest {

    @Autowired
    taskMapper taskMapper;

    @Test
    void insert() throws ParseException {
        task task = new task();
        task.setTask_name("测试任务1");
        task.setState(0);
        task.setS_id(3);
        task.setP_id(1);
        task.setRemarks("测试任务的备注1");
        task.setBegin_time(new Date());
        task.setCreate_time(new Date());
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        task.setEnd_time(sm.parse("2021-04-30 00:11:22"));
        taskMapper.insert(task);
    }

    @Test
    void update() {
        task task = taskMapper.selectByid(1);
        task.setRemarks("修改测试任务1的备注");
        taskMapper.update(task);
    }

    @Test
    void selectAll() {
        System.out.println(taskMapper.selectAll());
    }

    @Test
    void selectByid() {
        System.out.println(taskMapper.selectByid(1));
    }

    @Test
    void delete() {
        System.out.println(taskMapper.delete(1));
    }
}