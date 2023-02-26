package com.example.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationTest {

    @Test
    void configuration() {
        final MyConfig myConfig = new MyConfig();
        final Bean1 bean1 = myConfig.bean1();
        final Bean2 bean2 = myConfig.bean2();

        assertThat(bean1.common).isNotSameAs(bean2.common);


        final AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(MyConfig.class);
        ac.refresh();
        final Bean1 bean1BySpring = ac.getBean(Bean1.class);
        final Bean2 bean2BySpring = ac.getBean(Bean2.class);

        assertThat(bean1BySpring.common).isSameAs(bean2BySpring.common);
    }

    @Test
    void proxyCommonMethod() {
        final MyConfig myConfig = new MyConfigProxy();
        final Bean1 bean1 = myConfig.bean1();
        final Bean2 bean2 = myConfig.bean2();

        assertThat(bean1.common).isSameAs(bean2.common);
    }

    static class MyConfigProxy extends MyConfig {
        private Common common;

        @Override
        Common common() {
            if (this.common == null) {
                this.common = super.common();
            }

            return this.common;
        }
    }

    @Configuration // (proxyBeanMethods 가 default로 true 로 되어있는 경우 MyConfig가 직접 빈으로 등록되는 것이 아니라 프록시가 빈으로 등록됨
    static class MyConfig {
        @Bean
        Common common() {
            return new Common();
        }

        @Bean
        Bean1 bean1() {
            return new Bean1(common());
        }

        @Bean
        Bean2 bean2() {
            return new Bean2(common());
        }
    }

    static class Bean1 {
        private final Common common;

        Bean1(Common common) {this.common = common;}
    }

    static class Bean2 {
        private final Common common;

        Bean2(Common common) {this.common = common;}
    }

    static class Common {}
}
