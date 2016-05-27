package com.aere.spring;

import com.aere.spring.env.config.EnvConfig;
import com.aere.spring.mybatis.config.JPAConfig;
import com.aere.spring.rabbitmq.config.MQConfigConsumer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by epxpxpx on 5/25/2016.
 */
@ComponentScan(basePackages = "com.aere.spring")
public class AppMain {
    public static void main(String[] args){
        new AnnotationConfigApplicationContext(
                MQConfigConsumer.class,
                JPAConfig.class,
                EnvConfig.class);
    }
}
