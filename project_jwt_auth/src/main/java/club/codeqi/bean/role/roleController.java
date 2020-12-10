package club.codeqi.bean.role;

import club.codeqi.bean.user.user;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
