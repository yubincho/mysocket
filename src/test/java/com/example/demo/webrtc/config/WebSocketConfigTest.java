package com.example.demo.webrtc.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class WebSocketConfigTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {

        assertThat(applicationContext.getBean("webSocketConfig")).isNotNull();
    }

}