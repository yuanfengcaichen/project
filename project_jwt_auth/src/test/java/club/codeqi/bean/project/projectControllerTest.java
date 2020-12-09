package club.codeqi.bean.project;

import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class projectControllerTest {
    @Autowired
    projectController projectController;

    @Test
    void insertproject() throws ParseException {
        for(int i=0;i<10;i++){
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
        map.put("pid",3);
        map.put("p_name","测试update");
        System.out.println(projectController.updateProject(map));
    }

    @Test
    void projectByid() {
        System.out.println(projectController.projectByid(1));
    }

    @Test
    void projectAll() {
//        PageInfo page = projectController.projectAll(new HashMap());
////        System.out.println(map.size());
////        System.out.println(map);
////        PageInfo page = new PageInfo((List) map.get("list"));
//        System.out.println(page);
    }
}