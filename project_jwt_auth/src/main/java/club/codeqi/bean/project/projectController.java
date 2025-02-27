package club.codeqi.bean.project;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    //@PreAuthorize("hasAuthority('project')")
    @GetMapping("/projects")
    public PageInfo projectAll(@RequestParam(required = false,name = "pageNum") Integer pageNum,@RequestParam(required = false,name = "pageSize") Integer pageSize){
        if(pageNum == null) pageNum = 1;
        if(pageSize == null) pageSize = 10;
        PageHelper.startPage(pageNum, pageSize);
        List<project> list = projectMapper.selectList(null);
        PageInfo page = new PageInfo(list);
        return page;
    }
}
