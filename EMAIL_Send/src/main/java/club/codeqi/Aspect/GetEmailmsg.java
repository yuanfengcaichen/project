package club.codeqi.Aspect;

import club.codeqi.bean.email;
import club.codeqi.config.RabbitConfig;
import club.codeqi.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GetEmailmsg {
    public static final Logger LOGGER = LoggerFactory.getLogger("消息发送记录");
    @RabbitListener(queues = RabbitConfig.EMAIL_QUEUE)
    public void myListener(String message){
        Map map = JsonUtils.toMap(message,String.class,String.class);
        LOGGER.info("接受到的消息是："+ map);
        String phone = (String) map.get("phone");
        String code = (String) map.get("code");
        if(phone!=null&&code!=null){
            email email = new email();
            try{
                email.sendEmail();
            }
            catch (Throwable throwable){
                System.out.println(throwable.toString());
            }
        }
    }
}
