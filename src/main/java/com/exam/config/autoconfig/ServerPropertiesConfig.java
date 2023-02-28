package com.exam.config.autoconfig;

import com.exam.config.MyAutoConfiguration;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
public class ServerPropertiesConfig {
    @Bean
    public ServerProperties serverProperties(Environment env) {
//        final ServerProperties properties = new ServerProperties();
//        properties.setContextPath(env.getProperty("contextPath"));
//        properties.setPort(Integer.parseInt(env.getProperty("port")));
//
//        return properties;

        return Binder.get(env).bind("", ServerProperties.class).get();
    }
}
