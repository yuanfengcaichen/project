package club.codeqi.bean.project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class projectControllerTest {
    @Autowired
    projectController projectController;

    @Test
    void insertproject() throws ParseException {
        project project = new project();
        project.setP_name("");
        project.setRemarks("");
        project.setState(0);
        project.setCreat_uid(0);
        project.setCreate_time(new Date());
        project.setBegin_time(new Date());
        SimpleDateFormat sm =new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        String end = "2021-01-10 12:00:00";
        Date enddate = sm.parse(end);
        project.setEnd_time(enddate);
        System.out.println(projectController.insertproject(project));
    }

    @Test
    void deleteProject() {
        HashMap map = new HashMap();
        map.put("pid",2);
        System.out.println(projectController.deleteProject(map));
    }

    @Test
    void updateProject() {
        HashMap map = new HashMap();
        map.put("pid",1);
        map.put("p_name","测试update");
        System.out.println(projectController.updateProject(map));
    }

    @Test
    void projectByid() {
        System.out.println(projectController.projectByid(1));
    }

    @Test
    void projectAll() {
        System.out.println(projectController.projectAll());
    }
}