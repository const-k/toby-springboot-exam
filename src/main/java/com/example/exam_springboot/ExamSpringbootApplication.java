package com.example.exam_springboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//@SpringBootApplication
public class ExamSpringbootApplication {

    public static void main(String[] args) {
        final GenericWebApplicationContext applicationContext = new GenericWebApplicationContext();
        applicationContext.registerBean(HelloController.class);
        applicationContext.registerBean(SimpleHelloService.class);
        // 컨테이너 초기화 -> applicationContext 가 빈을 모두 생성함
        applicationContext.refresh();


        final ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        final WebServer webServer = serverFactory.getWebServer(servletContext -> {
            servletContext.addServlet("dispatcherServlet",
                                      new DispatcherServlet(applicationContext))
                .addMapping("/*");
        });

        webServer.start();

    }

}
