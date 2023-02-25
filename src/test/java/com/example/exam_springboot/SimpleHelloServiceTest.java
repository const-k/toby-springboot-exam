package com.example.exam_springboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SimpleHelloServiceTest {
    @Test
    void simpleHelloService() {
        final SimpleHelloService helloService = new SimpleHelloService();
        final String ret = helloService.sayHello("Spring");

        assertThat(ret).isEqualTo("Hello Spring");
    }
}