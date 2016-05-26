package com.aere.spring.rabbitmq;

/**
 * Created by epxpxpx on 5/25/2016.
 */
public interface MQMessageHandler<In> {
    void handleMessage(In in);
}
