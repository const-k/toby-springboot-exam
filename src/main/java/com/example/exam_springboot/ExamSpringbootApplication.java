package com.example.exam_springboot;

import com.exam.config.MySpringBootApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

//@SpringBootApplication
@Slf4j
@MySpringBootApplication
public class ExamSpringbootApplication {
//    @Bean
//    ApplicationRunner applicationRunner(Environment env) {
//        return args -> {
//            final String name = env.getProperty("my.name");
//            log.info("my.name: {}", name);
//        };
//    }

    public static void main(String[] args) {
//        MySpringApplication.run(ExamSpringbootApplication.class, args);
        SpringApplication.run(ExamSpringbootApplication.class, args);
    }
}
