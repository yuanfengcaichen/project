package club.codeqi.rabbitmq;

import club.codeqi.Aspect.user.topicsend;
import club.codeqi.config.RabbitConfig;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.QueueInformation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

@SpringBootTest
public class sendtest {

    @Autowired
    AmqpTemplate amqpTemplate;
    @Autowired
    AmqpAdmin amqpAdmin;
    @Autowired
    club.codeqi.Aspect.user.topicsend topicsend;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Test
    public void shendsms(){
        System.out.println(Objects.isNull(amqpTemplate));
        //topicsend.send();
        QueueInformation queueInformation = amqpAdmin.getQueueInfo("QUEUE_NAME");
        System.out.println(queueInformation);
        amqpTemplate.convertAndSend("QUEUE_NAME","fdsa");
    }

    @Test
    public void sendbyfactory() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //主机地址;默认为 localhost
        connectionFactory.setHost("192.168.174.130");
        //连接端口;默认为 5672
        connectionFactory.setPort(5672);
        //虚拟主机名称;默认为 /
        connectionFactory.setVirtualHost("/admin");
        //连接用户名；默认为guest
        connectionFactory.setUsername("admin");
        //连接密码；默认为guest
        connectionFactory.setPassword("admin");

        //创建连接
        Connection connection = connectionFactory.newConnection();

        // 创建频道
        Channel channel = connection.createChannel();

        // 声明（创建）队列
        /**
         * 参数1：队列名称
         * 参数2：是否定义持久化队列
         * 参数3：是否独占本次连接
         * 参数4：是否在不使用的时候自动删除队列
         * 参数5：队列其它参数
         */
        channel.queueDeclare("QUEUE_NAME", true, false, false, null);
        // 要发送的信息
        String message = "你好；小兔子！";
        /**
         * 参数1：交换机名称，如果没有指定则使用默认Default Exchage
         * 参数2：路由key,简单模式可以传递队列名称
         * 参数3：消息其它属性
         * 参数4：消息内容
         */
        channel.basicPublish("", "QUEUE_NAME", null, message.getBytes());
        System.out.println("已发送消息：" + message);

        // 关闭资源
        channel.close();
        connection.close();
    }
}
