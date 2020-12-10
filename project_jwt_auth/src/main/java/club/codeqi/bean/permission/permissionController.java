package club.codeqi.bean.permission;

import club.codeqi.bean.project.project;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class permissionController {
    @Autowired
    permissionMapper permissionMapper;

    @GetMapping("/permisses")
    public PageInfo projectAll(@RequestParam(required = false,name = "pageNum") Integer pageNum, @RequestParam(required = false,name = "pageSize") Integer pageSize){
        if(pageNum == null) pageNum = 1;
        if(pageSize == null) pageSize = 100;
        PageHelper.startPage(pageNum, pageSize);
        List<permission> list = permissionMapper.selectAll();
        PageInfo page = new PageInfo(list);
        return page;
    }

    @GetMapping("/role_permisses")
    public PageInfo projectAll(@RequestParam(required = false,name = "pageNum") Integer pageNum, @RequestParam(required = false,name = "pageSize") Integer pageSize, @RequestParam(required = false,name = "rid") Integer rid){
        if(pageNum == null) pageNum = 1;
        if(pageSize == null) pageSize = 100;
        PageHelper.startPage(pageNum, pageSize);
        List<permission> list = permissionMapper.selectByrid(rid);
        PageInfo page = new PageInfo(list);
        return page;
    }

    @PostMapping("/permisses")
    public Map addrolepermisses(@RequestBody Map map){
        Integer rid = (Integer) map.get("rid");
        ArrayList arrayList = (ArrayList) map.get("rpermisses");
        if(rid!=1){
            permissionMapper.deleteByrid(rid);
            List<permission> list = permissionMapper.selectAll();
            for(permission per : list){
                if(arrayList.contains(per.getPermission_info())){
                    //System.out.println(per);
                    permission permission = new permission();
                    permission.setRole_id(rid);
                    permission.setPermission_code(per.getPermission_code());
                    permission.setPermission_info(per.getPermission_info());
                    permission.setCreate_time(new Date());
                    permissionMapper.insert(permission);
                }
            }
        }
        HashMap resultMap = new HashMap();
        resultMap.put("result",200);
        return resultMap;
    }


}
