package com.aere.spring;

import com.aere.spring.rabbitmq.config.MQConfigConsumer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by epxpxpx on 5/25/2016.
 */
@ComponentScan(basePackages = "com.aere.spring.rabbitmq")
public class AppMain {
    public static void main(String[] args){
        new AnnotationConfigApplicationContext(MQConfigConsumer.class);
    }
}
