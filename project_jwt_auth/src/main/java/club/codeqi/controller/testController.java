package club.codeqi.controller;

import club.codeqi.Aspect.user.topicsend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @Autowired
    club.codeqi.Aspect.user.topicsend topicsend;
    @GetMapping("/hello")
    public String test(){
        return "hello world";
    }
    @GetMapping("/sendmsg")
    public String sendmsg(){
        //topicsend.send();
        return "test ok";
    }
}
