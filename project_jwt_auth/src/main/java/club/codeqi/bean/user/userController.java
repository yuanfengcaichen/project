package club.codeqi.bean.user;

import club.codeqi.bean.permission.permission;
import club.codeqi.bean.project.project;
import club.codeqi.config.RsaKeyProperties;
import club.codeqi.domain.Payload;
import club.codeqi.utils.JsonUtils;
import club.codeqi.utils.JwtUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class userController {

    @Autowired
    RsaKeyProperties prop;

    @Autowired
    userMapper userMapper;
    @GetMapping("/userinfo")
    public Map loginuserinfo(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        String token = header.replace("Bearer ","");
        Payload<user> payload = JwtUtils.getInfoFromToken(token,prop.getPublicKey(), user.class);
        user user = payload.getUserInfo();
        //user.getPermissions();//1. 转为json，2. JsonUtil.tolist(json,permission.class)
        user.setPermissions(JsonUtils.toList(JsonUtils.toString(user.getPermissions()), permission.class));
        Map map = new HashMap();
        map.put("result",200);
        map.put("userinfo",user);
        map.put("token",request.getHeader("Authorization"));
        map.put("expire",payload.getExpiration());
        return map;
    }
    @GetMapping("/users")
    public PageInfo userAll(@RequestParam(required = false,name = "pageNum") Integer pageNum, @RequestParam(required = false,name = "pageSize") Integer pageSize){
        if(pageNum == null) pageNum = 1;
        if(pageSize == null) pageSize = 10;
        PageHelper.startPage(pageNum, pageSize);
        List<user> list = userMapper.select_roleAll();//group by uid
        PageInfo page = new PageInfo(list);
        return page;
    }
}
