package com.example.exam_springboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//@SpringBootApplication
@Configuration // 자바 코드로 된 구성 정보임을 스프링에 알려주기 위해 사용
@ComponentScan
public class ExamSpringbootApplication {
    @Bean
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    public static void main(String[] args) {
        final AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();

                final ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
                final DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);
//                dispatcherServlet.setApplicationContext(this); // bean lifecycle 메서드에 의해 자동으로 applicationContext가 주입됨

                final WebServer webServer = serverFactory.getWebServer(servletContext -> {
                    servletContext.addServlet("dispatcherServlet", dispatcherServlet)
                        .addMapping("/*");
                });
                webServer.start();
            }
        };

        applicationContext.register(ExamSpringbootApplication.class);
        // 컨테이너 초기화 -> applicationContext 가 빈을 모두 생성함
        applicationContext.refresh();
    }

}
