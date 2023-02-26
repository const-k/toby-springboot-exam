package com.exam.config;

import com.exam.config.EnableMyAutoConfiguration;
import com.exam.config.autoconfig.DispatcherServletConfig;
import com.exam.config.autoconfig.TomcatWebServerConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Configuration // 자바 코드로 된 구성 정보임을 스프링에 알려주기 위해 사용
@ComponentScan
@EnableMyAutoConfiguration
public @interface MySpringBootApplication {
}