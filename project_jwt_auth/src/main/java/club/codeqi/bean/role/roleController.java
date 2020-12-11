package club.codeqi.bean.role;

import club.codeqi.bean.user.user;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class roleController {
    @Autowired
    roleMapper roleMapper;

    @GetMapping("/roles")
    public PageInfo roleAll(@RequestParam(required = false,name = "pageNum") Integer pageNum, @RequestParam(required = false,name = "pageSize") Integer pageSize){
        if(pageNum == null) pageNum = 1;
        if(pageSize == null) pageSize = 10;
        PageHelper.startPage(pageNum, pageSize);
        List<role> list = roleMapper.selectAll();
        PageInfo page = new PageInfo(list);
        return page;
    }

    @PostMapping("/role")
    public Map addrole(@RequestBody Map map){
        HashMap resultMap = new HashMap();
        resultMap.put("result",200);
        Integer rid = (Integer) map.get("rid");
        String role_name = (String) map.get("role_name");
        String role_info = (String) map.get("role_info");
        Integer is_lock = (Integer) map.get("is_lock");
        if(rid==0){
            role role = new role();
            role.setRole_name(role_name);
            role.setRole_info(role_info);
            role.setIs_lock(is_lock);
            role.setCreate_time(new Date());
            roleMapper.insert(role);
            resultMap.put("type","add");
        }
        else{
            role role = roleMapper.selectByid(rid);
            role.setRole_name(role_name);
            role.setRole_info(role_info);
            role.setIs_lock(is_lock);
            roleMapper.update(role);
            resultMap.put("type","edit");
        }
        return resultMap;
    }

    @DeleteMapping("/role")
    public Map deleterole(@RequestBody Map map){
        List<Integer> rids = (List<Integer>) map.get("rids");
        for(Integer rid : rids){
            roleMapper.delete(rid);
        }
        HashMap resultMap = new HashMap();
        resultMap.put("result",200);
        resultMap.put("type","delete");
        return resultMap;
    }
}
