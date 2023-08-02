package cn.itcast.mq.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAmqpTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMessage2SimpleQueue() {
        String queueName = "simple.queue";
        String message = "Hello, spring amqp!";
        rabbitTemplate.convertAndSend(queueName, message);
    }

    @Test
    public void testSendMessage2WorkQueue() throws InterruptedException {
        String queueName = "simple.queue";
        String message = "Hello, message__";
        for (int i = 1; i <= 50; i++) {
            rabbitTemplate.convertAndSend(queueName, message + i);
            Thread.sleep(20);
        }
    }

    @Test
    public void testSendFanoutExchange() {
        String exchangeName = "itcast.fanout";
        String message = "Hello, everyone!";
        rabbitTemplate.convertAndSend(exchangeName, "", message);
    }

    @Test
    public void testSendDirectExchange() {
        String exchangeName = "itcast.direct";
        String message = "Hello, red!";
        rabbitTemplate.convertAndSend(exchangeName, "red", message);
    }

    @Test
    public void testSendTopicExchange() {
        String exchangeName = "itcast.topic";
        String message = "Nice weather!";
        rabbitTemplate.convertAndSend(exchangeName, "china.weather", message);
    }
}
