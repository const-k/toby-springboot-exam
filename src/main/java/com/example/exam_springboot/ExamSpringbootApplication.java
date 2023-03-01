package com.example.exam_springboot;

import com.exam.config.MySpringBootApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;

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

    private final JdbcTemplate jdbcTemplate;

    public ExamSpringbootApplication(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @PostConstruct
    void init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }

    public static void main(String[] args) {
//        MySpringApplication.run(ExamSpringbootApplication.class, args);
        SpringApplication.run(ExamSpringbootApplication.class, args);
    }
}
