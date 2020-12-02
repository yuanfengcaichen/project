package club.codeqi.bean.project;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class projectController {

    @Autowired projectMapper projectMapper;

    @PostMapping("/project")
    public Map insertproject(project project){
        Map message=new HashMap();
        Integer result = projectMapper.insert(project);
        message.put("result",result);
        return message;
    }
    @DeleteMapping("/project")
    public Map deleteProject(@RequestBody Map map){
        Integer pid = (Integer) map.get("pid");
        Integer result = projectMapper.delete(pid);
        Map message=new HashMap();
        message.put("result",result);
        return message;
    }
    @PutMapping("/project")
    public Map updateProject(@RequestBody Map map){
        project p = projectMapper.selectByid((Integer) map.get("pid"));
        p.setP_name((String)map.get("p_name"));
        Integer result = projectMapper.update(p);
        Map message=new HashMap();
        message.put("result",result);
        return message;
    }
    @GetMapping("/project/{pid}")
    public project projectByid(@PathVariable("pid") Integer pid){
        return projectMapper.selectByid(pid);
    }

    @Secured("project")
    @GetMapping("/project")
    public ArrayList projectAll(){
        return projectMapper.selectAll();
    }
}
