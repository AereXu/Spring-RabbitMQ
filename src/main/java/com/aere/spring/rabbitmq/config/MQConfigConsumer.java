/**
 * Created by epxpxpx on 5/25/2016.
 */
package com.aere.spring.rabbitmq.config;

import com.aere.spring.rabbitmq.MQMessageHandler;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfigConsumer {
    public static final String queueName = "aerexu.queue";
    public static final String exchangeName = "aerexu.exchange";
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("golden-kangaroo.rmq.cloudamqp.com");
        connectionFactory.setUsername("qzovjtxd");
        connectionFactory.setPassword("CPNfRH-JHNGdsdJsU1fb8qncYUMO6X7V");
        connectionFactory.setVirtualHost("qzovjtxd");
        return connectionFactory;
    }

    @Bean
    public SimpleMessageListenerContainer listenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setQueueNames(queueName);
        container.setMessageListener(new MessageListenerAdapter(
                (MQMessageHandler<String>) s -> System.out.println("Recieve message that:"+s)));
        return container;
    }
}
