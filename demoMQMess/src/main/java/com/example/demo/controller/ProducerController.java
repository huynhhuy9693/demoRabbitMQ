package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/")
public class ProducerController {

    @Autowired
    private RabbitMQSender rabbitMQSender;


    @Value("${app.message}")
    private String message;
    @PostMapping(value = "/user")
    public String publishUserDetails(@RequestBody User user)
    {
        rabbitMQSender.send(user);
        return message;
    }


}
