package club.codeqi.bean.permission;

import club.codeqi.bean.project.project;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


}
