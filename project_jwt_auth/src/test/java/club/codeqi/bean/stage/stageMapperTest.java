package club.codeqi.bean.stage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class stageMapperTest {

    @Autowired
    stageMapper stageMapper;
    @Test
    void insert() throws ParseException {
        stage stage = new stage();
        stage.setP_id(1);
        stage.setStage_name("测试阶段1");
        stage.setRemarks("测试阶段备注");
        stage.setState(0);
        stage.setCreate_time(new Date());
        stage.setBegin_time(new Date());
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        stage.setEnd_time(sm.parse("2021-01-10 12:40:11"));
        stageMapper.insert(stage);
    }

    @Test
    void update() {
        stage stage = stageMapper.selectByid(2);
        stage.setRemarks("修改备注消息");
        System.out.println(stageMapper.update(stage));
    }

    @Test
    void selectAll() {
        System.out.println(stageMapper.selectAll());
    }

    @Test
    void selectByid() {
        System.out.println(stageMapper.selectByid(2));
    }

    @Test
    void delete() {
        System.out.println(stageMapper.delete(2));
    }
}