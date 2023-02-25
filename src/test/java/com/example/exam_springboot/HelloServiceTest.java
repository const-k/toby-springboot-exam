package com.example.exam_springboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class HelloServiceTest {
    @Test
    void simpleHelloService() {
        final SimpleHelloService helloService = new SimpleHelloService();
        final String ret = helloService.sayHello("Spring");

        assertThat(ret).isEqualTo("Hello Spring");
    }

    @Test
    void helloDecorator() {
        HelloDecorator decorator = new HelloDecorator(name -> name);
        final String ret = decorator.sayHello("Test");

        assertThat(ret).isEqualTo("*Test*");
    }
}