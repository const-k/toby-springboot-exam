package com.example.exam_springboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

//@ExamSpringBootTest
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@Transactional
public class HelloRepositoryTest {
    @Autowired JdbcTemplate jdbcTemplate;

    @Autowired
    HelloRepository helloRepository;

    @Test
    void findHelloFailed() {
        assertThat(helloRepository.findHello("Spring")).isNull();
    }

    @Test
    void increaseCount() {
        assertThat(helloRepository.countOf("spring")).isEqualTo(0);

        helloRepository.increaseCount("spring");
        assertThat(helloRepository.countOf("spring")).isEqualTo(1);

        helloRepository.increaseCount("spring");
        assertThat(helloRepository.countOf("spring")).isEqualTo(2);
    }
}
