package com.example.exam_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//@SpringBootApplication
@MySpringBootAnnotation
public class ExamSpringbootApplication {
    public static void main(String[] args) {
//        MySpringApplication.run(ExamSpringbootApplication.class, args);
        SpringApplication.run(ExamSpringbootApplication.class, args);
    }
}
