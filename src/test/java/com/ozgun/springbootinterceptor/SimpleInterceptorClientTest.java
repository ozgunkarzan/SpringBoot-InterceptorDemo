package com.ozgun.springbootinterceptor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SimpleInterceptorClientTest {

    @Autowired
    SimpleInterceptorClient simpleInterceptorClient;

    @Test
    void findAllTodos() {
        String todos = simpleInterceptorClient.findAllTodos();
        assertNotNull(todos);
    }
}