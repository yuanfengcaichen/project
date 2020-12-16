package club.codeqi.Aspect;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class GetMsg {

    @RabbitListener(queues = "hello")
    public void myListener(String message){
        System.out.println("接受到的消息是："+message);
    }
}
