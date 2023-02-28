package com.exam.config.autoconfig;

import com.exam.config.ConditionalMyOnClass;
import com.exam.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat") // 클래스가 존재하는지, 라이브러리가 존재하는지 체크
public class TomcatWebServerConfig {
    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean // 이미 등록된 ServletWebServerFactory 빈이 없다면 빈 생성, 유저 구성정보 빈을 먼저 등록 후 자동 구성 정보 빈을 등록함
    public ServletWebServerFactory servletWebServerFactory(Environment env) {
        final TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();

        serverFactory.setContextPath(env.getProperty("contextPath"));

        return serverFactory;
    }
}
