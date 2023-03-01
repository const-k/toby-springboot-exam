package com.example.exam_springboot;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ExtendWith(SpringExtension.class) // 스프링 컨텍스트를 이용하는 스프링 컨테이너 테스트 가능
@ContextConfiguration(classes = ExamSpringbootApplication.class)
@TestPropertySource("classpath:/application.properties") // application.properties, yml 을 등록해주는 건 스프링 프레임워크의 기본 동작 방식은 아님, 스프링 부트의 초기화 과정에서 추가해주는 것임
@Transactional
public @interface ExamSpringBootTest {
}
