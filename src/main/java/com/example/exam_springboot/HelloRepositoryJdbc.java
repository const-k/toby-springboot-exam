package com.example.exam_springboot;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@RequiredArgsConstructor
@Repository
public class HelloRepositoryJdbc implements HelloRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Hello findHello(String name) {
        try {
            return jdbcTemplate.queryForObject("select * from hello where name = '" + name + "'",
                                               (rs, rowNum) -> new Hello(
                                                   rs.getString("name"), rs.getInt("count")
                                               ));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void increaseCount(String name) {
        final Hello hello = this.findHello(name);
        if (hello == null) {
            jdbcTemplate.update("insert into hello values(?, ?)", name, 1);
            return;
        }

        jdbcTemplate.update("update hello set count = ? where name = ?", hello.getCount() + 1, name);
    }
}
