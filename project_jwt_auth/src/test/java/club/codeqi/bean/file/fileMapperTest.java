package club.codeqi.bean.file;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class fileMapperTest {

    @Autowired
    fileMapper fileMapper;

    @Test
    void insert() {
        file file = new file();
        file.setP_id(1);
        file.setS_id(0);
        file.setT_id(0);
        file.setM_id(0);
        file.setOldname("这是文件名");
        file.setFilepath("C://floder");
        file.setCreate_time(new Date());
        fileMapper.insert(file);
    }

    @Test
    void update() {
        file file = fileMapper.selectByid(1);
        file.setOldname("修改文件名");
        fileMapper.update(file);
    }

    @Test
    void selectAll() {
        System.out.println(fileMapper.selectAll());
    }

    @Test
    void selectByid() {
        System.out.println(fileMapper.selectByid(1));
    }

    @Test
    void delete() {
        System.out.println(fileMapper.delete(1));
    }
}