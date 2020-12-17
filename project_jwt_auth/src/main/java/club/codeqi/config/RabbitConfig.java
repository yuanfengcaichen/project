package club.codeqi.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {
    @Bean
    public Queue queue(){
        return new Queue("hello");
    }

    public static final String FANOUT_EXCHANGE = "fanout_exchange";
    //队列名称1
    public static final String SMS_QUEUE = "sms_queue";
    //队列名称2
    public static final String EMAIL_QUEUE = "email_queue";

    //声明交换机
    @Bean("fanout_exchange")
    public Exchange topicExchange(){
        return ExchangeBuilder.topicExchange(FANOUT_EXCHANGE).durable(true).build();
    }

    //声明队列1
    @Bean("sms_queue")
    public Queue sms_queue(){
        return QueueBuilder.durable(SMS_QUEUE).build();
    }

    //声明队列2
    @Bean("email_queue")
    public Queue email_queue(){
        return QueueBuilder.durable(EMAIL_QUEUE).build();
    }

    //绑定队列和交换机
    @Bean
    public Binding smsQueueExchange(@Qualifier("sms_queue") Queue queue,
                                     @Qualifier("fanout_exchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }

    //绑定队列和交换机
    @Bean
    public Binding eamilQueueExchange(@Qualifier("email_queue") Queue queue,
                                     @Qualifier("fanout_exchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }
}
