package cn.itcast.mq.helloworld;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConsumerTest {

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("192.168.150.101");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("itcast");
        factory.setPassword("123321");

        Connection connection = factory.newConnection();


        Channel channel = connection.createChannel();


        String queueName = "simple.queue";
        channel.queueDeclare(queueName, false, false, false, null);


        channel.basicConsume(queueName, true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {

                String message = new String(body);
                System.out.println("Successfully sent message: [" + message + "]");
            }
        });
        System.out.println("Waiting for messages......");
    }
}
