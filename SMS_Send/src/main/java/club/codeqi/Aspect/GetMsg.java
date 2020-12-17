package club.codeqi.Aspect;

import club.codeqi.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GetMsg {

    public static final Logger LOGGER = LoggerFactory.getLogger("消息发送记录");
    @RabbitListener(queues = "hello")
    public void myListener(String message){
        Map map = JsonUtils.toMap(message,String.class,String.class);
        LOGGER.info("接受到的消息是："+ map);
        String phone = (String) map.get("phone");
        String code = (String) map.get("code");
        if(phone!=null&&code!=null){
            SMS sms = new SMS();
            sms.setPhone(phone);
            sms.setCode(code);
            Object result = sms.sendSMS();
            LOGGER.info("消息发送结果："+result.toString());
        }
    }
}
