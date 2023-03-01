package com.example.exam_springboot;

import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.assertj.core.api.Assertions.assertThat;

class HelloServiceTest {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @UnitTest
    @interface FastUnitTest {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.METHOD, ElementType.ANNOTATION_TYPE })
    @Test
    @interface UnitTest {
    }

    @Test
    void simpleHelloService() {
        final SimpleHelloService helloService = new SimpleHelloService(helloRepositoryStub);

        final String ret = helloService.sayHello("Spring");

        assertThat(ret).isEqualTo("Hello Spring");
    }

    private HelloRepository helloRepositoryStub = new HelloRepository() {
        @Override
        public Hello findHello(String name) {
            return null;
        }

        @Override
        public void increaseCount(String name) {

        }
    };


    @Test
    void helloDecorator() {
        HelloDecorator decorator = new HelloDecorator(name -> name);
        final String ret = decorator.sayHello("Test");

        assertThat(ret).isEqualTo("*Test*");
    }
}