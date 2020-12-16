package club.codeqi.Aspect.user;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class JwtLoginAspect {

    public static final Logger LOGGER = LoggerFactory.getLogger("Token发放记录");
    @Autowired
    AmqpTemplate amqpTemplate;
    @Pointcut("execution(* club.codeqi.filter.JwtLoginFilter.successfulAuthentication(..))")
    public void successlogin(){}

    @Pointcut("execution(* club.codeqi.controller.testController*.sendmsg(..))")
    public void login(){}

    @Before("login()")
    public void sendSMS(){
        System.out.println("向消息队列中发送短信");
        amqpTemplate.convertAndSend("hello","123456");
    }
}
