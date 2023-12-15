package com.mymolu.global.config;

import com.mymolu.domains.crawling.application.CrawlingService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final static String ABS = "\\C:\\Users\\midcon\\Desktop\\my-molu-be\\download\\";

    private final CrawlingService crawlingService;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Path imageAbsolutePath = Paths.get(crawlingService.DOWNLOAD_DIRECTORY).toAbsolutePath();
        // localhost:8080/images/image.jpg
        registry.addResourceHandler("/download/**")
            .addResourceLocations("file://" + ABS);
    }
}
