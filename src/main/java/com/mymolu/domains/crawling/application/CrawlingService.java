package com.mymolu.domains.crawling.application;


import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CrawlingService {

    private final ChromeDriver driver;

    public static final String URL_ILLUSTRATION = "https://www.pixiv.net/tags/%E3%83%96%E3%83%AB%E3%83%BC%E3%82%A2%E3%83%BC%E3%82%AB%E3%82%A4%E3%83%96/illustrations";

    // 짤 크롤링
    public static final String IMAGE_BOX_ILLUSTRATION = "#root > div.charcoal-token > div > div:nth-child(4) > div > div > div.sc-15n9ncy-0.jORshO > section > div.sc-l7cibp-0.juyBTC > div:nth-child(1) > ul > li";

    public void getImages() throws InterruptedException {
        driver.get(URL_ILLUSTRATION);

        List<String> images = new ArrayList<>();
        List<WebElement> imageBox = driver.findElements(By.cssSelector(IMAGE_BOX_ILLUSTRATION));
        for (WebElement img : imageBox) {
            String imageUrl = img.findElement(By.cssSelector("img.sc-rp5asc-10.erYaF")).getAttribute("src");
            images.add(imageUrl);
            System.out.println(imageUrl);
        }
        driver.quit();
    }
}
