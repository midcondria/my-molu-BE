package com.mymolu.domains.crawling.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CrawlingServiceTest {

    @Autowired
    private CrawlingService crawlingService;

    @DisplayName("픽시브 이미지를 크롤링하면 60장의 이미지 url을 긁어온다.")
    @Test
    void CrawlingServiceTest() throws InterruptedException {
        // given
        List<String> result = crawlingService.getImages();
        // expected
        assertThat(result.size()).isEqualTo(60);
    }
}