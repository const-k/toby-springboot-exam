package com.example.exam_springboot;

public class HelloController {
    public String hello(String name) {
        final SimpleHelloService helloService = new SimpleHelloService();
        return helloService.sayHello(name);
    }
}
