package com.mymolu.global.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor
@ConstructorBinding
@ConfigurationProperties(prefix = "resource")
public class WebConfig implements WebMvcConfigurer {

    private final String absolutePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // localhost:8080/images/image.jpg
        registry.addResourceHandler("/download/**")
            .addResourceLocations(absolutePath);
    }
}
