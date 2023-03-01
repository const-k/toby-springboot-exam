package com.exam.config.autoconfig;

import com.exam.config.ConditionalMyOnClass;
import com.exam.config.EnableMyConfigurationProperties;
import com.exam.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat") // 클래스가 존재하는지, 라이브러리가 존재하는지 체크
//@Import(ServerProperties.class) // 빈 후처리기 사용 방식
@EnableMyConfigurationProperties(ServerProperties.class) // importSelector 사용 방식
public class TomcatWebServerConfig {
//    @Value("${contextPath:}") // BeanFactoryPostProcessor 라는 스프링 컨테이너의 후처리기를 빈으로 등록해줄 때  동작하게 됨
//    String contextPath;

//    @Value("${port:8080}")
//    int port;

    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean // 이미 등록된 ServletWebServerFactory 빈이 없다면 빈 생성, 유저 구성정보 빈을 먼저 등록 후 자동 구성 정보 빈을 등록함
    public ServletWebServerFactory servletWebServerFactory(ServerProperties properties) {
        final TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();

        serverFactory.setContextPath(properties.getContextPath());
        serverFactory.setPort(properties.getPort());

        return serverFactory;
    }

}
