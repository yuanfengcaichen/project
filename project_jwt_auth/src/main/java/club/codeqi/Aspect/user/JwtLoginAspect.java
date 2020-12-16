package club.codeqi.Aspect.user;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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
    @Pointcut("execution(* club.codeqi.bean.user.userController.loginuserinfo(..))")
    public void successlogin(){}


    @Before("successlogin()")
    public void sendSMS(){
    }

    @Around("successlogin()")
    public Object aroundSendSMS(ProceedingJoinPoint pjp) throws Throwable {
        SMS sms = new SMS();
        sms.setPhone("17721330304");
        sms.setCode("1216");
        LOGGER.info("-------------AOP向消息队列发送短信开始-------------------");
        LOGGER.info("向消息队列中发送消息：消息队列: "+"hello"+", 消息内容: "+sms.toString());
        amqpTemplate.convertAndSend("hello",sms.toString());
        //1.开始
        try {
            // 2、执行时
            Object obj =  pjp.proceed();
            LOGGER.info("--------------------AOP向消息队列发送短信结束-------------------------");
            return obj;
        } catch (Throwable e) {
            LOGGER.error(e.toString());// 3、发生异常时
            LOGGER.error("--------------------AOP向消息队列发送短信结束-------------------------");
            throw e;
        }

    }
}
