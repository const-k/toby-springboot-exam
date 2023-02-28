package com.exam.config.autoconfig;

import com.exam.config.MyAutoConfiguration;
import com.exam.config.MyConfigurationProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;

import java.util.Map;

@Slf4j
@MyAutoConfiguration
public class PropertyPostProcessorConfig {
    @Bean
    public BeanPostProcessor propertyPostProcessor(Environment env) {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                final MyConfigurationProperties annotation = AnnotationUtils.findAnnotation(bean.getClass(), MyConfigurationProperties.class);
                if (annotation == null) {
                    return bean;
                }

                final Map<String, Object> attrs = AnnotationUtils.getAnnotationAttributes(annotation);
                final String prefix = (String) attrs.get("prefix");

                // 없으면 빈 생성, 위에서 if로 MyConfigurationProperties 애노테이션으로 걸려줬기 때문에 여기서 bean은 MyConfigurationProperties 붙은 bean임
                return Binder.get(env).bindOrCreate(prefix, bean.getClass());
            }
        };
    }
}
