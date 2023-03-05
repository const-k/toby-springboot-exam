package com.example.exam_springboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

//@ExamSpringBootTest
@JdbcTest
public class JdbcTemplateTest {
    @Autowired JdbcTemplate jdbcTemplate;

    @Test
    void insertAndQuery() {
        jdbcTemplate.update("insert into hello values(?, ?)", "Spring", 3);
        jdbcTemplate.update("insert into hello values(?, ?)", "Boot", 1);

        final Long count = jdbcTemplate.queryForObject("select count(*) from hello", Long.class);
        Assertions.assertThat(count).isEqualTo(2);
    }

    @Test
    void insertAndQuery2() {
        jdbcTemplate.update("insert into hello values(?, ?)", "Spring", 3);
        jdbcTemplate.update("insert into hello values(?, ?)", "Boot", 1);

        final Long count = jdbcTemplate.queryForObject("select count(*) from hello", Long.class);
        Assertions.assertThat(count).isEqualTo(2);
    }
}
