package com.mymolu.global.config;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.time.Duration;

@ConstructorBinding
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "selenium")
public class SeleniumConfig {

    private final String driverName;

    public ChromeDriver chromeDriver() {
        System.setProperty("webdriver.chrome.driver", driverName);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));
        driver.manage().window().maximize();
        return driver;
    }
}