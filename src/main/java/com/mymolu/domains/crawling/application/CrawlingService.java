package com.mymolu.domains.crawling.application;

import com.mymolu.global.config.SeleniumConfig;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CrawlingService {

    // 짤 크롤링
    private static final String URL_ILLUSTRATION = "https://www.pixiv.net/tags/%E3%83%96%E3%83%AB%E3%83%BC%E3%82%A2%E3%83%BC%E3%82%AB%E3%82%A4%E3%83%96/illustrations";
    private static final String IMAGE_BOX_ILLUSTRATION = "#root > div.charcoal-token > div > div:nth-child(4) > div > div > div.sc-15n9ncy-0.jORshO > section > div.sc-l7cibp-0.juyBTC > div:nth-child(1) > ul > li";

    public List<String> getImages() {
        ChromeDriver driver = SeleniumConfig.chromeDriver();
        driver.get(URL_ILLUSTRATION);

        Long height = (Long) driver.executeScript("return document.body.scrollHeight");
        Long scroll = 500l;
        while (scroll <= height) {
            driver.executeScript("window.scrollTo(0," + scroll + ")");
            scroll += 500l;
        }

        List<WebElement> imageBox = driver.findElements(By.cssSelector(IMAGE_BOX_ILLUSTRATION));
        List<String> images = imageBox.stream()
                .map(o -> o.findElement(By.cssSelector("img.sc-rp5asc-10.erYaF")).getAttribute("src"))
                .collect(Collectors.toList());
        List<String> imageNames = new ArrayList<>();
        for (String imgUrl : images) {
            String downloadPath = "src/main/resources/static/download/";
            String fileName = imgUrl.substring(imgUrl.lastIndexOf('/') + 1);
            downloadImageWithReferer(imgUrl, downloadPath + fileName);
            imageNames.add(fileName);
        }

        driver.quit();
        return imageNames;
    }

    private static void downloadImageWithReferer(String imageUrl, String destinationFile) {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Referer 헤더 설정
            connection.setRequestProperty("Referer", "https://www.pixiv.net/");

            File folder = new File("src/main/resources/static/download/");
            if (!folder.exists()) {
                folder.mkdir();
            }
            try (InputStream in = connection.getInputStream();
                 FileOutputStream out = new FileOutputStream(destinationFile)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer, 0, 1024)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
