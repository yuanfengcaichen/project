package club.codeqi.bean.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class memberMapperTest {

    @Autowired
    memberMapper memberMapper;

    @Test
    void insert() {
        member member = new member();
        member.setP_id(1);
        member.setS_id(3);
        member.setT_id(2);
        member.setState(0);
        member.setU_id(1);
        member.setContent("测试人员的测试任务");
        member.setRemarks("测试人员任务备注");
        member.setCreate_time(new Date());
        member.setBegin_time(new Date());
        member.setEnd_time(new Date());
        memberMapper.insert(member);
    }

    @Test
    void update() {
        member member = memberMapper.selectByid(1);
        member.setRemarks("修改测试任务的备注信息");
        memberMapper.update(member);
    }

    @Test
    void selectAll() {
        System.out.println(memberMapper.selectAll());
    }

    @Test
    void selectByid() {
        System.out.println(memberMapper.selectByid(1));
    }

    @Test
    void delete() {
        System.out.println(memberMapper.delete(1));
    }
}