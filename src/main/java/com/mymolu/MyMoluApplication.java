package com.mymolu;

import com.mymolu.global.config.SeleniumConfig;
import com.mymolu.global.config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(value = {SeleniumConfig.class, WebConfig.class})
@SpringBootApplication
public class MyMoluApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyMoluApplication.class, args);
 	}
}