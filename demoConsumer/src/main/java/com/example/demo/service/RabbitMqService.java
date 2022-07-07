package com.example.demo.service;

import com.example.demo.config.RabbitMQConfig;

import com.example.demo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



@Component
public class RabbitMqService implements RabbitListenerConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMqService.class);
    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {

    }

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receivedMessage(User user)
    {
        logger.info("User details received is ...."+ user.getId());
        logger.info("User details received is ...."+ user.getUsername());
        logger.info("Success");
    }
}
