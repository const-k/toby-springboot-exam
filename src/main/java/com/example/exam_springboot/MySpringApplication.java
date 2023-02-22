package com.example.exam_springboot;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MySpringApplication {
    public static void run(Class<?> applicationClass, String... args) {
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

        applicationContext.register(applicationClass);
        applicationContext.refresh(); // 컨테이너 초기화 -> applicationContext 가 빈을 모두 생성함
    }
}
