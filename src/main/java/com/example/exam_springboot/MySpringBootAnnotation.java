package com.example.exam_springboot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Configuration // 자바 코드로 된 구성 정보임을 스프링에 알려주기 위해 사용
@ComponentScan
public @interface MySpringBootAnnotation {
}
