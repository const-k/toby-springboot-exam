package com.example.exam_springboot;

import com.exam.config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;

//@SpringBootApplication
@MySpringBootApplication
public class ExamSpringbootApplication {
    public static void main(String[] args) {
//        MySpringApplication.run(ExamSpringbootApplication.class, args);
        SpringApplication.run(ExamSpringbootApplication.class, args);
    }
}
