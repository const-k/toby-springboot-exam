package com.example.exam_springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@Slf4j
@RestController
public class HelloController {
    private final HelloService helloService;
//    private ApplicationContext applicationContext;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    // 필요한 bean은 생성자를 통해 받음 -> 스프링 컨테이너가 알아서 스캔 후 주입해줌
//    public HelloController(HelloService helloService, ApplicationContext applicationContext) {
//        this.helloService = helloService;
//        this.applicationContext = applicationContext;
//
//        log.info("applicationContext={}", applicationContext);
//    }


    @GetMapping("/hello")
    public String hello(String name) {
        if (Objects.isNull(name) || name.trim().length() == 0) {
            throw new IllegalArgumentException();
        }

        return helloService.sayHello(name);
    }

//    // ApplicationContextAware 구현, 스프링 컨테이너 초기화되는 시점에 호출됨
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        log.info("applicationContext={}", applicationContext);
//    }
}
