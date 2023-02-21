package com.example.exam_springboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//@SpringBootApplication
@Configuration // 자바 코드로 된 구성 정보임을 스프링에 알려주기 위해 사용
public class ExamSpringbootApplication {

    // helloController = factory 메소드, 스프링 컨테이너가 빈 오브젝트를 만들기 위해 사용되는 팩토리 메소드로 인식되도록 @Bean 사용
    @Bean
    public HelloController helloController(HelloService helloService) {
        return new HelloController(helloService);
    }

    @Bean
    public HelloService helloService() {
        return new SimpleHelloService();
    }

    public static void main(String[] args) {
        final AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();

                final ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
                final WebServer webServer = serverFactory.getWebServer(servletContext -> {
                    servletContext.addServlet("dispatcherServlet",
                                              new DispatcherServlet(this))
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
