package com.exam.config;

import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

public class MyAutoConfigImportSelector implements DeferredImportSelector {
    private final ClassLoader classLoader;

    public MyAutoConfigImportSelector(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // candidates = 파일에다 설정해둘 자동구성에 사용할  configuration 클래스의 목록들이 들어감
        final List<String> autoConfigs = new ArrayList<>();

        // META-INF/spring 위치의 full-qualified-annotation-name.imports 파일을 자동구성에 사용
        ImportCandidates.load(MyAutoConfiguration.class, classLoader)
            .forEach(autoConfigs::add);

        return autoConfigs.toArray(new String[0]);
    }
}
