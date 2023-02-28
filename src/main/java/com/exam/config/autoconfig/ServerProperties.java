package com.exam.config.autoconfig;

import com.exam.config.MyConfigurationProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MyConfigurationProperties(prefix="server")
public class ServerProperties {
    private String contextPath;
    private int port;
}
