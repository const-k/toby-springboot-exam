package com.exam.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {
            "com.exam.config.autoconfig.DispatcherServletConfig",
            "com.exam.config.autoconfig.TomcatWebServerConfig"
        };
    }
}
